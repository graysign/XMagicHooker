package com.magic.shared.hookers.interfaces

import java.io.File
import com.magic.kernel.core.Operation
import com.magic.kernel.core.Operation.Companion.nop

interface IFileHooker {

    /**
     * delete
     */
    fun onFileDeleting(file: File): Operation<Boolean> = nop()
    fun onFileDeleted(result: Boolean, file: File): Operation<Boolean> = nop()

    /**
     * read
     */
    fun onFileReading(file: File) { }

    /**
     * write
     */
    fun onFileWriting(file: File, append: Boolean) { }
}