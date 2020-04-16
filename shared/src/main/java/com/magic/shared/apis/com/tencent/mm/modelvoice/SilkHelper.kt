package com.magic.shared.apis.com.tencent.mm.modelvoice

import android.os.Handler
import android.os.Looper
import android.util.Log
import com.magic.kernel.media.audio.MediaCodecHelper
import java.io.*
import java.util.concurrent.Callable
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors
import java.util.concurrent.FutureTask

object SilkHelper {

    private val mExecutorService: ExecutorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors())
    private val mHandler: Handler = Handler(Looper.getMainLooper())

    fun encodeToSilk(sourcePath: String, destPath: String, start: Long, callback: ((Boolean) -> Unit)? = null) {
        val futureTask = object : FutureTask<Boolean>(Callable {
            var success: Boolean
            success = File(destPath).exists()
            if (!success) {
                val parser = MediaCodecHelper(sourcePath)
                parser.initDecoder()
                success = parser.decode("$sourcePath.pcm", start)
                parser.destory()
                if (success) {
                    try {
                        Log.e(SilkHelper.javaClass.name, "silk初始化开始")
                        var successInt = MediaRecorder.silkEncInit()
                        Log.e(SilkHelper.javaClass.name, "silk初始化： $successInt")
                        successInt = MediaRecorder.setVoiceSilkControl()
                        Log.e(SilkHelper.javaClass.name, "silk设置压缩率： $successInt")
                        var sourceBytes = BufferedInputStream(FileInputStream(File("$sourcePath.pcm"))).use { it.readBytes() }
                        var destBytes = ByteArray(16000 * 20 * 2 / 1000)
                        Log.e(SilkHelper.javaClass.name, "silk文件原大小： ${sourceBytes.size}")
                        successInt = MediaRecorder.silkDoEnc(bArr = sourceBytes, bArr2 = destBytes)
                        val file = File(destPath).also { if (it.parentFile?.exists() == false) it.parentFile?.mkdirs() }
                        val fileOutputStream = FileOutputStream(file)
                        BufferedOutputStream(fileOutputStream).use { it.write(destBytes) }
                        Log.e(SilkHelper.javaClass.name, "silk编码结果： $successInt")
                        success = successInt == 0
                        File("$sourcePath.pcm").deleteOnExit()
                        Log.e(SilkHelper.javaClass.name, "silk删除pcm文件： ")
                        MediaRecorder.silkEncUnInit()
                    } catch (t: Throwable) {
                        success = false
                        Log.e(SilkHelper::class.java.name, "Silk Encode 出错 ${t.localizedMessage}")
                    }
                }
            }
            return@Callable success
        }) {
            override fun done() {
                val success = get()
                if (!success) {
                    File(destPath).deleteOnExit()
                }
                mHandler.post { callback?.invoke(success) }
            }
        }
        mExecutorService.submit(futureTask)
    }

}