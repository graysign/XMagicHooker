package com.magic.wework.mirror.com.tencent.wework

import com.magic.kernel.MagicGlobal
import com.magic.kernel.MagicGlobal.lazy
import com.magic.kernel.MagicGlobal.classLoader
import com.magic.kernel.helper.ReflecterHelper.findClassIfExists

object Classes {
    private val packageName =
        "${MagicGlobal.packageName}.${javaClass.name.substringAfter("mirror.")}".removeSuffix(".${javaClass.simpleName}")

    val MK: Class<*> by lazy("MK") {
        findClassIfExists("$packageName.MK", classLoader!!)
    }

}

