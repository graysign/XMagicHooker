package com.magic.wework.mirror.com.tencent.wework.foundation.notification

import android.util.Log
import com.magic.kernel.MagicGlobal
import com.magic.kernel.MagicGlobal.lazy
import com.magic.kernel.MagicGlobal.classLoader
import com.magic.kernel.helper.ReflecterHelper.findClassIfExists

object Classes {
    private val packageName =
        "${MagicGlobal.packageName}.${javaClass.name.replaceBeforeLast("foundation", "")}".removeSuffix(".${javaClass.simpleName}")

    val NotificationInfo: Class<*> by lazy("${javaClass.name}.NotificationInfo") {
        findClassIfExists("$packageName.NotificationInfo", classLoader!!)
    }

    val WeworkNotificationListener: Class<*> by lazy("${javaClass.name}.WeworkNotificationListener") {
        var clazz = findClassIfExists("$packageName.WeworkNotificationListener", classLoader!!)
        return@lazy clazz
    }


}
