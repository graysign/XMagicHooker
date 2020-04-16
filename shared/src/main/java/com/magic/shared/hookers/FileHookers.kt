package com.magic.shared.hookers

import com.magic.kernel.core.Clazz
import com.magic.kernel.core.HookerCenter
import com.magic.kernel.core.Hooker
import com.magic.shared.hookers.interfaces.IFileHooker

object FileHookers: HookerCenter() {

    override val interfaces: List<Class<*>>
        get() = listOf(IFileHooker::class.java)

    override fun provideEventHooker(event: String): Hooker? {
        return when (event) {
            "onFileDeleting" ->
                iMethodNotifyForOperationsHooker(
                    clazz = Clazz.File,
                    method = "delete",
                    iClazz = IFileHooker::class.java,
                    iMethodBefore = event,
                    needObject = true
                )
            "onFileDeleted" ->
                iMethodNotifyForOperationsHooker(
                    clazz = Clazz.File,
                    method = "delete",
                    iClazz = IFileHooker::class.java,
                    iMethodAfter = event,
                    needObject = true,
                    needResult = true
                )
            "onFileReading" ->
                iConstructorNotifyHooker(
                    clazz = Clazz.FileInputStream,
                    iClazz = IFileHooker::class.java,
                    iMethodBefore = event,
                    parameterTypes = *arrayOf(Clazz.File)
                )
            "onFileWriting" ->
                iConstructorNotifyHooker(
                    clazz = Clazz.FileInputStream,
                    iClazz = IFileHooker::class.java,
                    iMethodBefore = event,
                    parameterTypes = *arrayOf(Clazz.File, Clazz.Boolean)
                )
            else -> throw IllegalArgumentException("Unknown event: $event")
        }
    }

}