package com.magic.wework.apis.com.tencent.wework.foundation.observer

interface IObservers {

    /** com.tencent.wework.foundation.observer.IDepartmentServiceObserver */
    interface IDepartmentServiceObserver {

        companion object {
            const val STATE_ERROR = 2
            const val STATE_FIRST_ERROR = 4
            const val STATE_FIRST_SYNCING = 1
            const val STATE_INIT = 0
            const val STATE_OK = 3
        }

        fun onSyncStateChanged(syncDepartmentState: Any?, syncDepartmentState2: Any?)

        fun onUserPropertyChanged(j: Long)
    }

    /** com.tencent.wework.foundation.observer.IMessageObserver */
    interface IMessageObserver {

        fun onMessageStateChange(message: Any, i: Int)

        fun onMsgUpdate(message: Any)

        fun onSendProgress(message: Any, j: Long, j2: Long)
    }

}