package com.magic.kernel.media.audio

import android.media.MediaCodec
import android.media.MediaExtractor
import android.media.MediaFormat
import android.util.Log
import java.io.File
import java.io.FileInputStream
import java.io.FileOutputStream

/**
 * @property path 音频原始路径
 */
class MediaCodecHelper(filePath: String) {
    private val mMediaExtractor = MediaExtractor()
    private var mMediaCodecDecoder: MediaCodec? = null
    private var mMediaCodecEncoder: MediaCodec? = null
    var mSampleRate = 8000
    var mBitRate = 8000

    companion object {
       const val TIMEOUT_US = 100L
    }

    init {
        try {
            mMediaExtractor.setDataSource(filePath)
        } catch (t: Throwable) {
            Log.e(MediaCodecHelper.javaClass.name, "parseFrom  t1: ${t.message}")
            try {
                mMediaExtractor.setDataSource(FileInputStream(filePath).fd)
            } catch (t: Throwable) {
                Log.e(MediaCodecHelper.javaClass.name, "parseFrom  t1: ${t.message}")
            }
        }

        // 音频媒体轨道只有一条，大于的则表示不是单一音频
        if (mMediaExtractor.trackCount > 1) {
            Log.e(MediaCodecHelper.javaClass.name, "parseFrom  trackCount: ${mMediaExtractor.trackCount}")
        }
    }

    fun initDecoder() {
        for (i in 0..mMediaExtractor.trackCount) {
            val mediaFormat = mMediaExtractor.getTrackFormat(i)
            try {
                mSampleRate = mediaFormat.getInteger(MediaFormat.KEY_SAMPLE_RATE)
                mBitRate = mediaFormat.getInteger(MediaFormat.KEY_BIT_RATE)
            } catch (t: Throwable) {
                Log.e(MediaCodecHelper.javaClass.name, "initDecoder catch: ${t.message}")
            }
            var mime = mediaFormat.getString(MediaFormat.KEY_MIME)
            if (mime.equals("audio/ffmpeg", true)) {
                mime = MediaFormat.MIMETYPE_AUDIO_MPEG
            }
            mediaFormat.setString(MediaFormat.KEY_MIME, mime)
            if (mime.startsWith("audio", true)) {
                mMediaExtractor.selectTrack(i)
                mMediaCodecDecoder = MediaCodec.createDecoderByType(mime)
                mMediaCodecDecoder?.configure(mediaFormat, null, null, 0); break
            }
        }
    }

    /**
     * @param destPath 解码到文件
     * @param start 从某个点开始
     */
    fun decode(destPath: String, start: Long = 0): Boolean {
        if (mMediaCodecDecoder == null) return false
        val decoder = mMediaCodecDecoder!!
        if (start > 0) {
            mMediaExtractor.seekTo(start * 1000, MediaExtractor.SEEK_TO_CLOSEST_SYNC)
        }
        decoder.start()
        var info = MediaCodec.BufferInfo()
        var isEOS = false
        val file = File(destPath).also { if (it.parentFile?.exists() == false) it.parentFile?.mkdirs() }
        val fileOutputStream = FileOutputStream(file)
        while (!isEOS) {
            try {
                val inIndex = decoder.dequeueInputBuffer(TIMEOUT_US)
                if (inIndex > 0) {
                    var inputBuffers = decoder.getInputBuffer(inIndex)
                    var sampleSize = mMediaExtractor.readSampleData(inputBuffers!!, 0)
                    if (sampleSize < 0) {
                        decoder.queueInputBuffer(inIndex, 0, 0, 0, MediaCodec.BUFFER_FLAG_END_OF_STREAM)
                        isEOS = true
                    } else {
                        decoder.queueInputBuffer(inIndex, 0, sampleSize, mMediaExtractor.sampleTime, 0)
                        mMediaExtractor.advance()
                    }
                    when (val outIndex = decoder.dequeueOutputBuffer(info, TIMEOUT_US)) {
                        MediaCodec.INFO_OUTPUT_BUFFERS_CHANGED -> {

                        }
                        MediaCodec.INFO_OUTPUT_FORMAT_CHANGED -> {

                        }
                        MediaCodec.INFO_TRY_AGAIN_LATER -> {

                        }
                        else -> {
                            var outputBuffer = decoder.getOutputBuffer(outIndex)
                            if (outputBuffer != null) {
                                val chunk = ByteArray(info.size)
                                outputBuffer.get(chunk)
                                outputBuffer.clear()
                                fileOutputStream.write(chunk)
                                decoder.releaseOutputBuffer(outIndex, false)
                            }
                        }
                    }
                    if (info.flags and MediaCodec.BUFFER_FLAG_END_OF_STREAM != 0) {
                        fileOutputStream.close()
                        Log.e(MediaCodecHelper::class.java.name, "解码完成: BUFFER_FLAG_END_OF_STREAM")
                        break
                    }
                }
            } catch (e: Throwable) {
                return false
            }
        }
        return true
    }

    fun initEncoder() {

    }

    // 先默认转换为wav
    fun encode(mime: String, destPath: String) {

    }

    fun destory() {
        mMediaCodecDecoder?.stop()
        mMediaCodecDecoder?.release()
        mMediaExtractor?.release()
    }

}