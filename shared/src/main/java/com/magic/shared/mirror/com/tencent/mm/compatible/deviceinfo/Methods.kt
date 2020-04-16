package com.magic.shared.mirror.com.tencent.mm.compatible.deviceinfo

import com.magic.kernel.MagicGlobal.lazy
import com.magic.kernel.core.Clazz
import com.magic.kernel.helper.ReflecterHelper.findMethodsByExactParameters
import java.lang.reflect.Method

object Methods {

    object CpuChecker {

        val getCpuFlag: Method by lazy("${javaClass.name}.gcf") {
            findMethodsByExactParameters(Classes.CpuChecker, Clazz.Int).firstOrNull()
        }

    }

}
