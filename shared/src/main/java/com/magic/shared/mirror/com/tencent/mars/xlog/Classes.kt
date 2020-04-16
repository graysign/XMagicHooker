package com.magic.shared.mirror.com.tencent.mars.xlog

import com.magic.kernel.MagicGlobal.lazy
import com.magic.kernel.MagicGlobal.classLoader
import com.magic.kernel.helper.ReflecterHelper.findClassIfExists

object Classes {
    val Xlog: Class<*> by lazy("Xlog") {
        findClassIfExists("${javaClass.name.substringAfterLast("mirror.")}.Xlog", classLoader!!)
    }
}