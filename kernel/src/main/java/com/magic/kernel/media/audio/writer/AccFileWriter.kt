//package com.magic.kernel.media.audio.writer
//
//import android.annotation.TargetApi
//import android.media.MediaCodec
//import android.media.MediaFormat
//import android.os.Build
//import com.hd.audiocapture.CaptureConfig
//import com.hd.audiocapture.CaptureState
//import com.hd.audiocapture.callback.CaptureStreamCallback
//import java.io.DataOutputStream
//import java.io.IOException
//import java.nio.ByteBuffer
//
///**
// * Created by hd on 2018/5/10 .
// */
//class AccFileWriter : AudioFileWriter() {
//    private var mDataOutputStream: DataOutputStream? = null
//    private var captureConfig: CaptureConfig? = null
//    fun init(
//        mDataOutputStream: DataOutputStream?,
//        captureConfig: CaptureConfig?
//    ) {
//        this.mDataOutputStream = mDataOutputStream
//        this.captureConfig = captureConfig
//    }
//
//    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
//    fun start(): Boolean {
//        if (mediaCodec != null) {
//            return true
//        }
//        val type = "audio/mp4a-latm"
//        mediaCodec = try {
//            MediaCodec.createEncoderByType(type)
//        } catch (e: Exception) {
//            e.printStackTrace()
//            return false
//        }
//        val format = MediaFormat()
//        format.setString(MediaFormat.KEY_MIME, type)
//        format.setInteger(MediaFormat.KEY_CHANNEL_COUNT, captureConfig.getChannelCount())
//        format.setInteger(MediaFormat.KEY_SAMPLE_RATE, captureConfig.getSamplingRate())
//        format.setInteger(MediaFormat.KEY_BIT_RATE, captureConfig.getBitrate())
//        format.setInteger(MediaFormat.KEY_AAC_PROFILE, captureConfig.getProfile())
//        bufferInfo = MediaCodec.BufferInfo()
//        mediaCodec!!.configure(format, null, null, MediaCodec.CONFIGURE_FLAG_ENCODE)
//        mediaCodec!!.start()
//        return true
//    }
//
//    private var mediaCodec: MediaCodec? = null
//    private var inputBuffer: ByteBuffer? = null
//    private var outputBuffer: ByteBuffer? = null
//    private var inputBufferIndex = 0
//    private var outputBufferIndex = 0
//    private var bufferInfo: MediaCodec.BufferInfo? = null
//
//    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
//    fun writeData(
//        state: CaptureState,
//        buffer: ByteArray?,
//        offset: Int,
//        count: Int
//    ): Boolean {
//        if (mediaCodec == null) {
//            return false
//        }
//        inputBufferIndex = mediaCodec!!.dequeueInputBuffer(-1)
//        if (inputBufferIndex >= 0) {
//            inputBuffer = mediaCodec!!.inputBuffers[inputBufferIndex]
//            inputBuffer.clear()
//            inputBuffer.put(buffer)
//            mediaCodec!!.queueInputBuffer(inputBufferIndex, offset, count, 0, 0)
//        }
//        outputBufferIndex = mediaCodec!!.dequeueOutputBuffer(bufferInfo!!, 0)
//        while (outputBufferIndex >= 0) {
//            if (CaptureState.RESUME === state) {
//                //------------add acc header--------------
//                val outBitsSize = bufferInfo!!.size
//                val outPacketSize = outBitsSize + 7 // 7 is ADTS size
//                var outData = ByteArray(outPacketSize)
//                outputBuffer = mediaCodec!!.outputBuffers[outputBufferIndex]
//                outputBuffer.position(bufferInfo!!.offset)
//                outputBuffer.limit(bufferInfo!!.offset + bufferInfo!!.size)
//                addADTStoPacket(
//                    outData,
//                    outPacketSize,
//                    captureConfig.getSamplingRate(),
//                    captureConfig.getChannelCount()
//                )
//                outputBuffer.get(outData, 7, outBitsSize)
//                try {
//                    var filterData: ByteArray? = null
//                    if (captureConfig.getCaptureCallback() != null && captureConfig.getCaptureCallback() is CaptureStreamCallback) {
//                        filterData =
//                            (captureConfig.getCaptureCallback() as CaptureStreamCallback).filterContentByte(
//                                outData
//                            )
//                    }
//                    outData =
//                        if (filterData == null || filterData.size <= 0) outData else filterData
//                    mDataOutputStream!!.write(outData)
//                } catch (e: IOException) {
//                    e.printStackTrace()
//                }
//                if (captureConfig.getCaptureCallback() != null && captureConfig.getCaptureCallback() is CaptureStreamCallback) {
//                    (captureConfig.getCaptureCallback() as CaptureStreamCallback).captureContentByte(
//                        outData
//                    )
//                }
//            }
//            mediaCodec!!.releaseOutputBuffer(outputBufferIndex, false)
//            outputBufferIndex = mediaCodec!!.dequeueOutputBuffer(bufferInfo!!, 0)
//        }
//        return true
//    }
//
//    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
//    fun stop(): Boolean {
//        if (mediaCodec != null) {
//            mediaCodec!!.stop()
//            mediaCodec!!.release()
//            mediaCodec = null
//        }
//        return true
//    }
//
//    /**
//     * add acc file header
//     * Add ADTS header at the beginning of each and every AAC packet. This is
//     * needed as MediaCodec encoder generates a packet of raw AAC data.
//     * Note the packetLen must count in the ADTS header itself.
//     */
//    private fun addADTStoPacket(
//        packet: ByteArray,
//        packetLen: Int,
//        sampleInHz: Int,
//        chanCfgCounts: Int
//    ) {
//        val profile = 2 // AAC LC
//        var freqIdx = 8 // 16KHz    39=MediaCodecInfo.CodecProfileLevel.AACObjectELD;
//        when (sampleInHz) {
//            96000 -> freqIdx = 0
//            88200 -> freqIdx = 1
//            64000 -> freqIdx = 2
//            48000 -> freqIdx = 3
//            44100 -> freqIdx = 4
//            32000 -> freqIdx = 5
//            24000 -> freqIdx = 6
//            22050 -> freqIdx = 7
//            16000 -> freqIdx = 8
//            2000 -> freqIdx = 9
//            11025 -> freqIdx = 10
//            8000 -> freqIdx = 11
//            else -> {
//            }
//        }
//        // fill in ADTS data
//        packet[0] = 0xFF.toByte()
//        packet[1] = 0xF9.toByte()
//        packet[2] =
//            ((profile - 1 shl 6) + (freqIdx shl 2) + (chanCfgCounts shr 2)).toByte()
//        packet[3] = ((chanCfgCounts and 3 shl 6) + (packetLen shr 11)).toByte()
//        packet[4] = (packetLen and 0x7FF shr 3).toByte()
//        packet[5] = ((packetLen and 7 shl 5) + 0x1F).toByte()
//        packet[6] = 0xFC.toByte()
//    }
//}