package com.magic.wework.mirror.com.tencent.wework.foundation.notification

import com.magic.kernel.MagicGlobal.lazy
import com.magic.kernel.core.Clazz
import com.magic.kernel.helper.ReflecterHelper.findMethodsByExactParameters
import java.lang.reflect.Method

object Methods {

    object WeworkNotificationListener {
        val onObserve: Method by lazy("${javaClass.name}.oo") {
            findMethodsByExactParameters(
                Classes.WeworkNotificationListener,
                null,
                Clazz.Int,
                Classes.NotificationInfo
            ).firstOrNull()
        }
    }

}