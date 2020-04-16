package com.magic.wework.mirror.com.tencent.wework.foundation.callback

import com.magic.kernel.MagicGlobal
import com.magic.kernel.MagicGlobal.lazy
import com.magic.kernel.MagicGlobal.classLoader
import com.magic.kernel.helper.ReflecterHelper.findClassIfExists

object Classes {
    private val packageName =
        "${MagicGlobal.packageName}.${javaClass.name.replaceBeforeLast("foundation", "")}".removeSuffix(".${javaClass.simpleName}")

    val IGetChildDepartmentsCallback: Class<*> by lazy("${javaClass.name}.IGetChildDepartmentsCallback") {
        findClassIfExists("$packageName.IGetChildDepartmentsCallback", classLoader!!)
    }

    val IGetDepartmentUserIDMapCallback: Class<*> by lazy("${javaClass.name}.IGetDepartmentUserIDMapCallback") {
        findClassIfExists("$packageName.IGetDepartmentUserIDMapCallback", classLoader!!)
    }

    val ISearchDepartmentCallback: Class<*> by lazy("${javaClass.name}.ISearchDepartmentCallback") {
        findClassIfExists("$packageName.ISearchDepartmentCallback", classLoader!!)
    }
}

