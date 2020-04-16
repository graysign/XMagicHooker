package com.magic.shared.mirror.com.tencent.mm.modelvoice

import com.magic.kernel.MagicGlobal.lazy
import com.magic.kernel.MagicGlobal.classLoader
import com.magic.kernel.helper.ReflecterHelper.findClassIfExists

object Classes {
    private val packageName = "${javaClass.name.substringAfter("mirror.")}".removeSuffix(".${javaClass.simpleName}")

    val MediaRecorder: Class<*> by lazy("${javaClass.name}.MediaRecorder") {
        findClassIfExists("$packageName.MediaRecorder", classLoader!!)
    }
}