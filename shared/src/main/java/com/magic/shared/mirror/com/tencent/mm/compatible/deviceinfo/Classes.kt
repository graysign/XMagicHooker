package com.magic.shared.mirror.com.tencent.mm.compatible.deviceinfo

import com.magic.kernel.MagicGlobal
import com.magic.kernel.MagicGlobal.lazy
import com.magic.kernel.MagicGlobal.classLoader
import com.magic.kernel.helper.ReflecterHelper.findClassIfExists

object Classes {
    private val packageName = "${javaClass.name.substringAfter("mirror.")}".removeSuffix(".${javaClass.simpleName}")

    val CpuChecker: Class<*> by lazy("{$packageName.CpuChecker") {
        findClassIfExists("$packageName.CpuChecker", classLoader!!)
    }
}