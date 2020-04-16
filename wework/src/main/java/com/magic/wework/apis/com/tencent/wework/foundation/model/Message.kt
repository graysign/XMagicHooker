package com.magic.wework.apis.com.tencent.wework.foundation.model

import com.magic.wework.mirror.com.tencent.wework.foundation.model.Methods
import com.magic.wework.apis.com.tencent.wework.foundation.model.pb.WwMessage
import de.robv.android.xposed.XposedHelpers

/**
 * @param original com.tencent.wework.foundation.model.Message
 */
data class Message(var original: Any) {

    companion object {

        /**
         * @return
         */
        fun getInfo(original: Any): Any =
            XposedHelpers.callMethod(original, Methods.Message.getInfo.name)

        /**
         * @return
//         */
//        fun requestInfo(original: Any): Any =
//            XposedHelpers.callMethod(original, Methods.Message.requestInfo.name)
//
//        fun isFileMessage(original: Any): Boolean =
//            XposedHelpers.callMethod(original, Methods.Message.isFileMessage.name) as? Boolean ?: false
    }

    val contentType: Int = getInfo().contentType

    fun getInfo(): WwMessage.Message = WwMessage.Message.parseFrom(Companion.getInfo(original))
//
//    fun requestInfo(): WwMessage.Message = WwMessage.Message.parseFrom(Companion.requestInfo(original))
//
//    fun isFileMessage(): Boolean = Companion.isFileMessage(original)

}