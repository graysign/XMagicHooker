package com.magic.shared.mirror.com.tencent.wcdb

import com.magic.kernel.MagicGlobal.lazy
import com.magic.kernel.MagicGlobal.classLoader
import com.magic.kernel.helper.ReflecterHelper.findClassIfExists

object Classes {
    val SQLiteErrorHandler: Class<*> by lazy("SQLiteErrorHandler") {
        findClassIfExists("${javaClass.name.substringAfter("mirror.")}.DatabaseErrorHandler", classLoader!!)
    }
}