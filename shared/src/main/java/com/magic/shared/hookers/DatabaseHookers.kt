package com.magic.shared.hookers

import com.magic.kernel.core.Clazz
import com.magic.kernel.core.HookerCenter
import com.magic.kernel.core.Hooker
import com.magic.shared.hookers.interfaces.IDatabaseHooker
import com.magic.shared.mirror.com.tencent.wcdb.Classes.SQLiteErrorHandler
import com.magic.shared.mirror.com.tencent.wcdb.database.Classes.SQLiteDatabase
import com.magic.shared.mirror.com.tencent.wcdb.database.Classes.SQLiteDatabase_CursorFactory
import com.magic.shared.mirror.com.tencent.wcdb.support.Classes.CancellationSignal

object DatabaseHookers : HookerCenter() {

    override val interfaces: List<Class<*>>
        get() = listOf(IDatabaseHooker::class.java)

    override fun provideEventHooker(event: String): Hooker? {
        return when (event) {
            "onDatabaseOpening" ->
                iMethodNotifyForOperationsHooker(
                    clazz = SQLiteDatabase,
                    method = "openDatabase",
                    iClazz = IDatabaseHooker::class.java,
                    iMethodBefore = event,
                    parameterTypes = *arrayOf(
                        Clazz.String,
                        SQLiteDatabase_CursorFactory,
                        Clazz.Int,
                        SQLiteErrorHandler
                    )
                )
            "onDatabaseOpened" ->
                iMethodNotifyForOperationsHooker(
                    clazz = SQLiteDatabase,
                    method = "openDatabase",
                    iClazz = IDatabaseHooker::class.java,
                    iMethodAfter = event,
                    needResult = true,
                    parameterTypes = *arrayOf(
                        Clazz.String,
                        SQLiteDatabase_CursorFactory,
                        Clazz.Int,
                        SQLiteErrorHandler
                    )
                )
            "onDatabaseInserting" ->
                iMethodNotifyForOperationsHooker(
                    clazz = SQLiteDatabase,
                    method = "insertWithOnConflict",
                    iClazz = IDatabaseHooker::class.java,
                    iMethodBefore = event,
                    needObject = true,
                    parameterTypes = *arrayOf(
                        Clazz.String,
                        Clazz.String,
                        Clazz.ContentValues,
                        Clazz.Int
                    )
                )
            "onDatabaseInserted" ->
                iMethodNotifyForOperationsHooker(
                    clazz = SQLiteDatabase,
                    method = "insertWithOnConflict",
                    iClazz = IDatabaseHooker::class.java,
                    iMethodBefore = event,
                    needObject = true,
                    needResult = true,
                    parameterTypes = *arrayOf(
                        Clazz.String,
                        Clazz.String,
                        Clazz.ContentValues,
                        Clazz.Int
                    )
                )
            "onDatabaseDeleting" ->
                iMethodNotifyForOperationsHooker(
                    clazz = SQLiteDatabase,
                    method = "delete",
                    iClazz = IDatabaseHooker::class.java,
                    iMethodBefore = event,
                    needObject = true,
                    parameterTypes = *arrayOf(Clazz.String, Clazz.String, Clazz.StringArray)
                )
            "onDatabaseDeleted" ->
                iMethodNotifyForOperationsHooker(
                    clazz = SQLiteDatabase,
                    method = "delete",
                    iClazz = IDatabaseHooker::class.java,
                    iMethodBefore = event,
                    needObject = true,
                    needResult = true,
                    parameterTypes = *arrayOf(Clazz.String, Clazz.String, Clazz.StringArray)
                )
            "onDatabaseUpdating" ->
                iMethodNotifyForOperationsHooker(
                    clazz = SQLiteDatabase,
                    method = "updateWithOnConflict",
                    iClazz = IDatabaseHooker::class.java,
                    iMethodBefore = event,
                    needObject = true,
                    parameterTypes = *arrayOf(
                        Clazz.String,
                        Clazz.ContentValues,
                        Clazz.String,
                        Clazz.StringArray,
                        Clazz.Int
                    )
                )
            "onDatabaseUpdated" ->
                iMethodNotifyForOperationsHooker(
                    clazz = SQLiteDatabase,
                    method = "updateWithOnConflict",
                    iClazz = IDatabaseHooker::class.java,
                    iMethodBefore = event,
                    needObject = true,
                    needResult = true,
                    parameterTypes = *arrayOf(
                        Clazz.String,
                        Clazz.ContentValues,
                        Clazz.String,
                        Clazz.StringArray,
                        Clazz.Int
                    )
                )
            "onDatabaseQuerying" ->
                iMethodNotifyForOperationsHooker(
                    clazz = SQLiteDatabase,
                    method = "rawQueryWithFactory",
                    iClazz = IDatabaseHooker::class.java,
                    iMethodBefore = event,
                    needObject = true,
                    parameterTypes = *arrayOf(
                        SQLiteDatabase_CursorFactory,
                        Clazz.String,
                        Clazz.StringArray,
                        Clazz.String,
                        CancellationSignal
                    )
                )
            "onDatabaseQueried" ->
                iMethodNotifyForOperationsHooker(
                    clazz = SQLiteDatabase,
                    method = "rawQueryWithFactory",
                    iClazz = IDatabaseHooker::class.java,
                    iMethodBefore = event,
                    needObject = true,
                    needResult = true,
                    parameterTypes = *arrayOf(
                        SQLiteDatabase_CursorFactory,
                        Clazz.String,
                        Clazz.StringArray,
                        Clazz.String,
                        CancellationSignal
                    )
                )
            "onDatabaseExecuting" ->
                iMethodNotifyForBypassFlagsHooker(
                    clazz = SQLiteDatabase,
                    method = "executeSql",
                    iClazz = IDatabaseHooker::class.java,
                    iMethodBefore = event,
                    needObject = true,
                    parameterTypes = *arrayOf(Clazz.String, Clazz.ObjectArray, CancellationSignal)
                )
            "onDatabaseExecuted" ->
                iMethodNotifyHooker(
                    clazz = SQLiteDatabase,
                    method = "executeSql",
                    iClazz = IDatabaseHooker::class.java,
                    iMethodBefore = event,
                    needObject = true,
                    parameterTypes = *arrayOf(Clazz.String, Clazz.ObjectArray, CancellationSignal)
                )
            else -> throw IllegalArgumentException("Unknown event: $event")
        }
    }

}