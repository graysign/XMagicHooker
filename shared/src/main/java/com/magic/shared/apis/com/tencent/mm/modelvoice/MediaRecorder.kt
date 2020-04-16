package com.magic.shared.apis.com.tencent.mm.modelvoice

import com.magic.kernel.core.Clazz
import com.magic.shared.apis.com.tencent.mm.compatible.deviceinfo.CpuChecker
import com.magic.shared.mirror.com.tencent.mm.modelvoice.Classes
import com.magic.shared.mirror.com.tencent.mm.modelvoice.Methods
import de.robv.android.xposed.XposedHelpers

object MediaRecorder {

    fun setVoiceSilkDecControl(i: Int, bArr: ByteArray, i2: Int): Int =
        XposedHelpers.callStaticMethod(
            Classes.MediaRecorder, Methods.MediaRecorder.SetVoiceSilkDecControl.name,
            arrayOf(Clazz.Int, Clazz.ByteArray, Clazz.Int),
            i, bArr, i2
        ) as Int

    fun silkDecInit(i: Int, bArr: ByteArray, i2: Int): Int =
        XposedHelpers.callStaticMethod(
            Classes.MediaRecorder, Methods.MediaRecorder.SilkDecInit.name,
            arrayOf(Clazz.Int, Clazz.ByteArray, Clazz.Int),
            i, bArr, i2
        ) as Int

    fun silkDecUnInit(): Int =
        XposedHelpers.callStaticMethod(
            Classes.MediaRecorder, Methods.MediaRecorder.SilkDecUnInit.name
        ) as Int

    fun silkDoDec(bArr: ByteArray, s: Short): Int =
        XposedHelpers.callStaticMethod(
            Classes.MediaRecorder, Methods.MediaRecorder.SilkDoDec.name,
            arrayOf(Clazz.ByteArray, Clazz.Short),
            bArr, s
        ) as Int

    /**
     * 初始化silk编码
     */
    fun silkEncInit(sampleRate: Int = 16000, bitRate: Int = 16000, cpuType: Int = CpuChecker.getCpuType()): Int =
        XposedHelpers.callStaticMethod(
            Classes.MediaRecorder, Methods.MediaRecorder.SilkEncInit.name,
            arrayOf(Clazz.Int, Clazz.Int, Clazz.Int),
            sampleRate, bitRate, cpuType
        ) as Int

    /**
     * 设置编码时的控制
     * @param i
     * @param compression default 1 开启压缩
     */
    fun setVoiceSilkControl(i: Int = 200, compression: Int = 1): Int =
        XposedHelpers.callStaticMethod(
            Classes.MediaRecorder, Methods.MediaRecorder.SetVoiceSilkControl.name,
            arrayOf(Clazz.Int, Clazz.Int),
            i, compression
        ) as Int

    /**
     * 开始编码
     */
    fun silkDoEnc(bArr: ByteArray, s: Short = 16000 * 20 * 2 / 1000, bArr2: ByteArray, sArr: ShortArray = shortArrayOf(1), z: Boolean = true): Int =
        XposedHelpers.callStaticMethod(
            Classes.MediaRecorder, Methods.MediaRecorder.SilkDoEnc.name,
            arrayOf(Clazz.ByteArray, Clazz.Short, Clazz.ByteArray, Clazz.ShortArray, Clazz.Boolean),
            bArr, s, bArr2, sArr, z
        ) as Int

    /**
     * 释放编码器
     */
    fun silkEncUnInit(): Int =
        XposedHelpers.callStaticMethod(
            Classes.MediaRecorder, Methods.MediaRecorder.SilkEncUnInit.name
        ) as Int
}