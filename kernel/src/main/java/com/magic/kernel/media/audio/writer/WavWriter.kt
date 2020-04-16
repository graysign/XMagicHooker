//package com.magic.kernel.media.audio.writer
//
//import android.media.AudioFormat
//import java.io.DataOutputStream
//import java.io.FileNotFoundException
//import java.io.IOException
//import java.io.RandomAccessFile
//
//class WavWriter {
//
//    private inner class WavHeader {
//        var mChunkID = "RIFF"
//        var mChunkSize = 0
//        var mFormat = "WAVE"
//        var mSubChunk1ID = "fmt "
//        var mSubChunk1Size = 16
//        var mAudioFormat: Short = 1
//        var mNumChannel: Short = 1
//        var mSampleRate = 8000
//        var mByteRate = 0
//        var mBlockAlign: Short = 0
//        var mBitsPerSample: Short = 8
//        var mSubChunk2ID = "data"
//        var mSubChunk2Size = 0
//
//        constructor() {}
//        constructor(sampleRateInHz: Int, channels: Int, bitsPerSample: Int) {
//            mSampleRate = sampleRateInHz
//            mBitsPerSample = bitsPerSample.toShort()
//            mNumChannel = channels.toShort()
//            mByteRate = mSampleRate * mNumChannel * mBitsPerSample / 8
//            mBlockAlign = (mNumChannel * mBitsPerSample / 8).toShort()
//        }
//
//        companion object {
//            const val WAV_FILE_HEADER_SIZE = 44
//            const val WAV_CHUNKSIZE_EXCLUDE_DATA = 36
//            const val WAV_CHUNKSIZE_OFFSET = 4
//            const val WAV_SUB_CHUNKSIZE1_OFFSET = 16
//            const val WAV_SUB_CHUNKSIZE2_OFFSET = 40
//        }
//    }
//
//    private var header: WavHeader? = null
//    private var mDataSize = 0
//    private var mFilepath: String? = null
//    private var mDataOutputStream: DataOutputStream? = null
//    private var captureConfig: CaptureConfig? = null
//    fun init(
//        mDataOutputStream: DataOutputStream?,
//        captureConfig: CaptureConfig
//    ) {
//        header = WavHeader(
//            captureConfig.getSamplingRate(),
//            AudioFormat.CHANNEL_IN_MONO,
//            AudioFormat.ENCODING_PCM_16BIT
//        )
//        mDataSize = 0
//        this.mDataOutputStream = mDataOutputStream
//        this.captureConfig = captureConfig
//        mFilepath = captureConfig.getFile().getAbsolutePath()
//    }
//
//    fun start(): Boolean {
//        if (mDataOutputStream == null) {
//            return false
//        }
//        try {
//            mDataOutputStream!!.writeBytes(header!!.mChunkID)
//            mDataOutputStream!!.write(Utils.intToByteArray(header!!.mChunkSize), 0, 4)
//            mDataOutputStream!!.writeBytes(header!!.mFormat)
//            mDataOutputStream!!.writeBytes(header!!.mSubChunk1ID)
//            mDataOutputStream!!.write(Utils.intToByteArray(header!!.mSubChunk1Size), 0, 4)
//            mDataOutputStream!!.write(Utils.shortToByteArray(header!!.mAudioFormat), 0, 2)
//            mDataOutputStream!!.write(Utils.shortToByteArray(header!!.mNumChannel), 0, 2)
//            mDataOutputStream!!.write(Utils.intToByteArray(header!!.mSampleRate), 0, 4)
//            mDataOutputStream!!.write(Utils.intToByteArray(header!!.mByteRate), 0, 4)
//            mDataOutputStream!!.write(Utils.shortToByteArray(header!!.mBlockAlign), 0, 2)
//            mDataOutputStream!!.write(Utils.shortToByteArray(header!!.mBitsPerSample), 0, 2)
//            mDataOutputStream!!.writeBytes(header!!.mSubChunk2ID)
//            mDataOutputStream!!.write(Utils.intToByteArray(header!!.mSubChunk2Size), 0, 4)
//        } catch (e: Exception) {
//            e.printStackTrace()
//            return false
//        }
//        return true
//    }
//
//    fun writeData(
//        state: CaptureState,
//        buffer: ByteArray,
//        offset: Int,
//        count: Int
//    ): Boolean {
//        var buffer = buffer
//        if (mDataOutputStream == null) {
//            return false
//        }
//        if (CaptureState.RESUME === state) {
//            try {
//                var filterData: ByteArray? = null
//                if (captureConfig.getCaptureCallback() != null && captureConfig.getCaptureCallback() is CaptureStreamCallback) {
//                    filterData =
//                        (captureConfig.getCaptureCallback() as CaptureStreamCallback).filterContentByte(
//                            buffer
//                        )
//                }
//                buffer = if (filterData == null || filterData.size <= 0) buffer else filterData
//                mDataOutputStream!!.write(buffer, offset, buffer.size)
//                mDataSize += count
//                if (captureConfig.getCaptureCallback() != null && captureConfig.getCaptureCallback() is CaptureStreamCallback) {
//                    (captureConfig.getCaptureCallback() as CaptureStreamCallback).captureContentByte(
//                        buffer
//                    )
//                }
//            } catch (e: Exception) {
//                e.printStackTrace()
//                return false
//            }
//        }
//        return true
//    }
//
//    fun stop(): Boolean {
//        if (mDataOutputStream == null) {
//            return false
//        }
//        try {
//            val wavFile = RandomAccessFile(mFilepath, "rw")
//            wavFile.seek(WavFileWriter.WavFileHeader.Companion.WAV_CHUNKSIZE_OFFSET.toLong())
//            wavFile.write(
//                Utils.intToByteArray(mDataSize + WavFileWriter.WavFileHeader.Companion.WAV_CHUNKSIZE_EXCLUDE_DATA),
//                0,
//                4
//            )
//            wavFile.seek(WavFileWriter.WavFileHeader.Companion.WAV_SUB_CHUNKSIZE2_OFFSET.toLong())
//            wavFile.write(Utils.intToByteArray(mDataSize), 0, 4)
//            wavFile.close()
//        } catch (e: FileNotFoundException) {
//            e.printStackTrace()
//            return false
//        } catch (e: IOException) {
//            e.printStackTrace()
//            return false
//        }
//        return true
//    }
//
//}