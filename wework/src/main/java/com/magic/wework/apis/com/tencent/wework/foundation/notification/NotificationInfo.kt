package com.magic.wework.apis.com.tencent.wework.foundation.notification

import de.robv.android.xposed.XposedHelpers
import java.io.Serializable

/**
 *  如果在回调
 *  detail = 0 一般情况下为 Message com.tencent.wework.foundation.model.Message
 *  detail2 一般情况下为消息的简短描述，如果是text=[那就是消息内容]，如果是图片=[图片]，如果是语音=[语音] ...
 */
data class NotificationInfo(
    var mDetail: Any? = null,
    var mDetail2: Any? = null,
    var mDetail2int: Int = 0,
    var mDetail3: Int = -1,
    var mDetail4: Long = -1,
    var mRawData: ByteArray = byteArrayOf(),
    @Transient
    var original: Any? = null
) : Serializable {

    companion object {
        /**
         *  @param notificationInfo com.tencent.wework.foundation.notification.NotificationInfo
         */
        fun parse(notificationInfo: Any) : NotificationInfo =
            NotificationInfo(
                mDetail = XposedHelpers.getObjectField(notificationInfo, "mDetail"),
                mDetail2 = XposedHelpers.getObjectField(notificationInfo, "mDetail2"),
                mDetail2int = XposedHelpers.getIntField(notificationInfo, "mDetail2int"),
                mDetail3 = XposedHelpers.getIntField(notificationInfo, "mDetail3"),
                mDetail4 = XposedHelpers.getLongField(notificationInfo, "mDetail4"),
                mRawData = XposedHelpers.getObjectField(notificationInfo, "mRawData") as? ByteArray ?: byteArrayOf(),
                original = notificationInfo
            )
    }

}
