package com.magic.wework.hookers

import android.util.Log
import com.magic.kernel.MagicGlobal
import com.magic.kernel.core.Clazz
import com.magic.kernel.core.HookerCenter
import com.magic.kernel.core.Hooker
import com.magic.wework.hookers.interfaces.INotificationHooker
import com.magic.wework.mirror.com.tencent.wework.foundation.notification.Classes.NotificationInfo
import com.magic.wework.mirror.com.tencent.wework.foundation.notification.Classes.WeworkNotificationListener
import com.magic.wework.mirror.com.tencent.wework.foundation.notification.Methods.WeworkNotificationListener.onObserve

object NotificationHookers : HookerCenter() {

    override val interfaces: List<Class<*>>
        get() = listOf(INotificationHooker::class.java)

    override fun provideEventHooker(event: String): Hooker? {
        return when (event) {
            "onObserve" ->
                iMethodNotifyHooker(
                    clazz = WeworkNotificationListener,
                    method = onObserve,
                    iClazz = INotificationHooker::class.java,
                    iMethodAfter = event,
                    parameterTypes = *arrayOf(Clazz.Int, NotificationInfo)
                )
            else -> {
                if (MagicGlobal.unitTestMode) {
                    throw IllegalArgumentException("Unknown event: $event")
                }
                Log.e(NotificationHookers::class.java.name, "function not found: ${event}")
                return null
            }
        }
    }

}