package com.magic.shared.mirror.com.tencent.wcdb.support

import com.magic.kernel.MagicGlobal.lazy
import com.magic.kernel.MagicGlobal.classLoader
import com.magic.kernel.helper.ReflecterHelper.findClassIfExists

object Classes {
    val CancellationSignal: Class<*> by lazy("CancellationSignal") {
        findClassIfExists("${javaClass.name.substringAfter("mirror.")}.CancellationSignal", classLoader!!)
    }
}
