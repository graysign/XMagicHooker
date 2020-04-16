package com.magic.shared.mirror.android.support.v4.app

import com.magic.kernel.MagicGlobal
import com.magic.kernel.MagicGlobal.lazy
import com.magic.kernel.MagicGlobal.classLoader
import com.magic.kernel.MagicGlobal.classes
import com.magic.kernel.helper.ReflecterHelper.findClassesInPackage

object Classes {
    private val packageName = "${MagicGlobal.packageName}.${javaClass.name.replaceBeforeLast("android", "")}".removeSuffix(".${javaClass.simpleName}")

    val NotificationManagerCompat: Class<*> by lazy ("NotificationManagerCompat") {
        findClassesInPackage(classLoader!!, classes!!, packageName)
                .filterByField("android.app.NotificationManager")
                .firstOrNull()
    }
}