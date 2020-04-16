package com.magic.shared.hookers.interfaces

import android.content.ContentValues
import com.magic.kernel.core.Operation
import com.magic.kernel.core.Operation.Companion.nop

interface IDatabaseHooker {

    /**
     * open
     */
    fun onDatabaseOpening(path: String, factory: Any?, flags: Int, errorHandler: Any?): Operation<Any> = nop()
    fun onDatabaseOpened(path: String, factory: Any?, flags: Int, errorHandler: Any?, result: Any?): Operation<Any> = nop()

    /**
     * insert
     */
    fun onDatabaseInserting(thisObject: Any, table: String, nullColumnHack: String?, initialValues: ContentValues?, conflictAlgorithm: Int): Operation<Long> = nop()
    fun onDatabaseInserted(thisObject: Any, table: String, nullColumnHack: String?, initialValues: ContentValues?, conflictAlgorithm: Int, result: Long?): Operation<Long> = nop()

    /**
     * delete
     */
    fun onDatabaseDeleting(thisObject: Any, table: String, whereClause: String?, whereArgs: Array<String>?): Operation<Int> = nop()
    fun onDatabaseDeleted(thisObject: Any, table: String, whereClause: String?, whereArgs: Array<String>?, result: Int): Operation<Int> = nop()

    /**
     * update
     */
    fun onDatabaseUpdating(thisObject: Any, table: String, values: ContentValues, whereClause: String?, whereArgs: Array<String>?, conflictAlgorithm: Int): Operation<Int> = nop()
    fun onDatabaseUpdated(thisObject: Any, table: String, values: ContentValues, whereClause: String?, whereArgs: Array<String>?, conflictAlgorithm: Int, result: Int): Operation<Int> = nop()

    /**
     * query
     */
    fun onDatabaseQuerying(thisObject: Any, factory: Any?, sql: String, selectionArgs: Array<String>?, editTable: String?, cancellationSignal: Any?): Operation<Any> = nop()
    fun onDatabaseQueried(thisObject: Any, factory: Any?, sql: String, selectionArgs: Array<String>?, editTable: String?, cancellationSignal: Any?, result: Any?): Operation<Any> = nop()

    /**
     * execSQL
     */
    fun onDatabaseExecuting(thisObject: Any, sql: String, bindArgs: Array<Any?>?, cancellationSignal: Any?) = false
    fun onDatabaseExecuted(thisObject: Any, sql: String, bindArgs: Array<Any?>?, cancellationSignal: Any?) { }

}