package com.magic.shared.mirror.com.tencent.wcdb.database

import com.magic.kernel.MagicGlobal.lazy
import com.magic.kernel.MagicGlobal.classLoader
import com.magic.kernel.helper.ReflecterHelper.findClassIfExists

object Classes {
    private val packageName = javaClass.name.substringAfter("mirror.").removeSuffix(".${javaClass.simpleName}")

    val SQLiteDatabase: Class<*> by lazy("SQLiteDatabase") {
        findClassIfExists("$packageName.SQLiteDatabase", classLoader!!)
    }

    val SQLiteDatabase_CursorFactory: Class<*> by lazy("SQLiteCursorFactory") {
        findClassIfExists("${SQLiteDatabase.canonicalName}\$CursorFactory", classLoader!!)
    }

}


