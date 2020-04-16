package com.magic.wework.mirror.com.tencent.wework.foundation.model.pb

import com.magic.kernel.MagicGlobal
import com.magic.kernel.MagicGlobal.lazy
import com.magic.kernel.MagicGlobal.classLoader
import com.magic.kernel.helper.ReflecterHelper.findClassIfExists

object Classes {
    private val packageName = "${MagicGlobal.packageName}.${javaClass.name.replaceBeforeLast("foundation", "")}".removeSuffix(".${javaClass.simpleName}")

    /** ----------- ExtendableMessageNano ---------- */
    object ICommon {

        val Common: Class<*> by lazy("${javaClass.name}.Common") {
            findClassIfExists("$packageName.Common", classLoader!!)
        }

    }

    object IWwUser {

        val WwUser: Class<*> by lazy("${javaClass.name}.WwUser") {
            findClassIfExists("${packageName}.WwUser", classLoader!!)
        }

        val User: Class<*> by lazy("${javaClass.name}.User") {
            var clazz = findClassIfExists("${WwUser.canonicalName}\$User", classLoader!!)
            if (clazz == null) {
                clazz = findClassIfExists("${WwUser.canonicalName}.User", classLoader!!)
            }
            return@lazy clazz
        }

    }

}

