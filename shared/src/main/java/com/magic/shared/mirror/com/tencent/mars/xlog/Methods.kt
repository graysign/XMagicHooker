package com.magic.shared.mirror.com.tencent.mars.xlog

import com.magic.kernel.MagicGlobal.lazy
import com.magic.shared.mirror.com.tencent.mars.xlog.Classes.Xlog
import java.lang.reflect.Method

object Methods {
    val Xlog_logWrite: Method by lazy("Xlog_logWrite") {
        Xlog.declaredMethods.find { it.name == "logWrite" }
    }

    val Xlog_logWrite2: Method by lazy("Xlog_logWrite2") {
        Xlog.declaredMethods.find { it.name == "logWrite2" }
    }
}
