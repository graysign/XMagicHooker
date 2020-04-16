package com.magic.wework.hookers.interfaces

interface INotificationHooker {

    /**
     * com.tencent.foundation.notification.WeworkNotificationListener
     * com.tencent.foundation.notification.INotificationObserver
     *
     * @param i Int 具体查看 evq  evq$7 关于i的返回值与notificationInfo之间的关系
     * i = 2 : 新消息 Message
     * i = 71 : 连接状态改变
     * @param notificationInfo com.tencent.foundation.notification.NotificationInfo
     */
    fun onObserve(i: Int, notificationInfo: Any) {}

}