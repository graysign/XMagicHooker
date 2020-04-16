package com.magic.wework.apis.com.tencent.wework.foundation.model

import com.magic.wework.mirror.com.tencent.wework.foundation.model.Methods
import de.robv.android.xposed.XposedHelpers

/**
 * @property original com.tencent.wework.foundation.model.Conversation
 */
data class Conversation(var original: Any) {

    /**
     * 针对
     */
    companion object {

        /**
         * @return
         */
        fun getInfo(original: Any): Any =
            XposedHelpers.callMethod(original, Methods.Conversation.getInfo.name)

    }

//    fun getInfo(): WwConversation.Conversation =
//        WwConversation.Conversation.parseFrom(Companion.getInfo(original))
//
//    fun getLocalId(): Long = getInfo().id
//
//    fun getRemoteId(): Long = getInfo().id
//
//    fun requestInfo(): WwConversation.Conversation =
//        WwConversation.Conversation.parseFrom(Companion.requestInfo(original))
//
//    fun getLastMessage(): WwMessage.Message? {
//        var message = Companion.getLastMessage(original)
//        return if (message != null) WwMessage.Message.parseFrom(message) else null
//    }
//
//    fun getConvExtra(): WwConversation.Extras? {
//        var extra = Companion.getConvExtra(original)
//        return if (extra != null) WwConversation.Extras.parseFrom(extra) else null
//    }
//
//    fun getIsInactive(): Boolean = Companion.getIsInactive(original)
//
//    fun getIsShield(): Boolean = Companion.getIsShield(original)
//
//    fun getType(): Int = Companion.getType(original)
//
//    fun getCacheMembers(): Array<WwConversation.ConvMember> =
//        WwConversation.ConvMember.parseFromArray(Companion.getCacheMembers(original))
//
//    fun getMemberCount(): Int = Companion.getMemberCount(original)
//
//    fun getForbidSpeakMembers(): Array<WwConversation.ConvMember> =
//        WwConversation.ConvMember.parseFromArray(Companion.getForbidSpeakMembers(original))
//
//    fun getUnForbidSpeakMembers(): Array<WwConversation.ConvMember> =
//        WwConversation.ConvMember.parseFromArray(Companion.getUnForbidSpeakMembers(original))
//
//    fun getMembers(): Array<WwConversation.ConvMember> =
//        WwConversation.ConvMember.parseFromArray(Companion.getMembers(original))
//
//    fun getMembersFilterApp(): Array<WwConversation.ConvMember> =
//        WwConversation.ConvMember.parseFromArray(Companion.getMembersFilterApp(original))
//
//    fun getMembersFilterAppAndGroupRobot(): Array<WwConversation.ConvMember> =
//        WwConversation.ConvMember.parseFromArray(Companion.getMembersFilterAppAndGroupRobot(original))
//
//    fun getMemberByVid(j: Long): WwConversation.ConvMember =
//        WwConversation.ConvMember.parseFrom(Companion.getMemberByVid(original, j))
//
//    fun getMembersFilterAppAndRobotCount(): Int = Companion.getMembersFilterAppAndRobotCount(original)
//
//    fun getUserList(jArr: LongArray): Array<User> =
//        Companion.getUserList(original, jArr).map { User(it) }.toTypedArray()
//
//    fun getMembersFilterGroupRobotCount(): Int = Companion.getMembersFilterGroupRobotCount(original)
//
//    fun getDefaultName(z: Boolean): String = Companion.getDefaultName(original, z)
//
//    fun getAvatorList(j: Long): Array<String> = Companion.getAvatorList(original, j)
//
//    fun isInnerCustomerService(): Boolean = Companion.isInnerCustomerService(original)
//
//    fun isReceiverInternalCustomer(): Boolean = Companion.isReceiverInternalCustomer(original)
//
//    fun isExternalCustomerService(): Boolean = Companion.isExternalCustomerService(original)
//
//    fun isAppConv(): Boolean = Companion.isAppConv(original)
//
//    fun isRobotConv(): Boolean = Companion.isRobotConv(original)
//
//    fun isAddMemberNeedConfirm(): Boolean = Companion.isAddMemberNeedConfirm(original)
//
//    fun isActivateGreet(): Boolean = Companion.isActivateGreet(original)
//
//    fun isExternalGroup(): Boolean = Companion.isExternalGroup(original)
//
//    fun isWechatConversation(): Boolean = Companion.isWechatConversation(original)
//
//    fun isFirstWxRoom(): Boolean = Companion.isFirstWxRoom(original)
//
//    fun hasWechatMember(): Boolean = Companion.hasWechatMember(original)
//
//    fun getFinancialDisagreeVids(): LongArray = Companion.getFinancialDisagreeVids(original)
//
//    fun getShowTime(): Long = Companion.getShowTime(original)
//
//    fun getSortTime(): Long = Companion.getSortTime(original)
//
//    fun containMember(userId: Long) = getUserList(longArrayOf(userId)).isNotEmpty()

}
