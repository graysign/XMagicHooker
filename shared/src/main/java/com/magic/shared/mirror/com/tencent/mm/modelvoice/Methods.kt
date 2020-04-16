package com.magic.shared.mirror.com.tencent.mm.modelvoice

import com.magic.kernel.MagicGlobal.lazy
import com.magic.kernel.core.Clazz
import com.magic.kernel.helper.ReflecterHelper.findMethodsByExactParameters
import java.lang.reflect.Method

object Methods {

    object MediaRecorder {
        val SetVoiceSilkControl: Method by lazy("${javaClass.name}.svsc") {
            findMethodsByExactParameters(
                Classes.MediaRecorder,
                Clazz.Int,
                Clazz.Int,
                Clazz.Int
            ).firstOrNull()
        }

        val SetVoiceSilkDecControl: Method by lazy("${javaClass.name}.svsdc") {
            findMethodsByExactParameters(
                Classes.MediaRecorder,
                Clazz.Int,
                Clazz.Int,
                Clazz.ByteArray,
                Clazz.Int
            ).filter { it.name.contains("Control", true) }.firstOrNull()
        }

        val SilkDecInit: Method by lazy("${javaClass.name}.sdi") {
            findMethodsByExactParameters(
                Classes.MediaRecorder,
                Clazz.Int,
                Clazz.Int,
                Clazz.ByteArray,
                Clazz.Int
            ).filter { it.name.contains("Init", true) }.firstOrNull()
        }

        val SilkDecUnInit: Method by lazy("${javaClass.name}.sdui") {
            findMethodsByExactParameters(
                Classes.MediaRecorder,
                Clazz.Int
            ).filter { it.name.contains("DecUn", true) }.firstOrNull()
        }

        val SilkDoDec: Method by lazy("${javaClass.name}.sdd") {
            findMethodsByExactParameters(
                Classes.MediaRecorder,
                Clazz.Int,
                Clazz.ByteArray,
                Clazz.Short
            ).firstOrNull()
        }

        val SilkEncInit: Method by lazy("${javaClass.name}.sei") {
            findMethodsByExactParameters(
                Classes.MediaRecorder,
                Clazz.Int,
                Clazz.Int,
                Clazz.Int,
                Clazz.Int
            ).firstOrNull()
        }

        val SilkEncUnInit: Method by lazy("${javaClass.name}.seui") {
            findMethodsByExactParameters(
                Classes.MediaRecorder,
                Clazz.Int
            ).filter { it.name.contains("EncUn", true) }.firstOrNull()
        }

        val SilkDoEnc: Method by lazy("${javaClass.name}.sde") {
            findMethodsByExactParameters(
                Classes.MediaRecorder,
                Clazz.Int,
                Clazz.ByteArray,
                Clazz.Short,
                Clazz.ByteArray,
                Clazz.ShortArray,
                Clazz.Boolean
            ).firstOrNull()
        }

        val SilkGetEncSampleRate: Method by lazy("${javaClass.name}.sei") {
            findMethodsByExactParameters(
                Classes.MediaRecorder,
                Clazz.Int,
                Clazz.ByteArray
            ).firstOrNull()
        }

    }

}
