package com.magic.wework.apis.com.tencent.wework.foundation.logic

import com.magic.wework.mirror.com.tencent.wework.foundation.logic.Classes.ConversationService
import com.magic.wework.mirror.com.tencent.wework.foundation.logic.Methods
import de.robv.android.xposed.XposedHelpers

object ConversationService {

    /**
     * @return
     */
    private fun getService(): Any =
        XposedHelpers.callStaticMethod(
            ConversationService,
            Methods.ConversationService.getService.name
        )

    /**
     * 获取所有会话
     * @param conversation  可以为空
     * @param type 类型 -1 为全部
     *
     * @return []com.tencent.wework.foundation.model.Conversation
     */
//    fun getConversationList(conversation: Any? = null, type: Int = -1): Array<Any> =
//        XposedHelpers.callMethod(
//            getService(), Methods.ConversationService.GetConversationList.name,
//        ) as? Array<Any> ?: arrayOf()

    /**
     * 获取已保存的会话
     * @return []com.tencent.wework.foundation.model.Conversation
     */
//    fun getCollectionConvList(): Array<Any> =
//        XposedHelpers.callMethod(
//            getService(), Methods.ConversationService.GetCollectionConvList.name
//        ) as? Array<Any> ?: arrayOf()

    /**
     * @param com.tencent.wework.foundation.observer.IConversationListObserver
     */
    fun addObserver(iConversationListObserver: Any) =
        XposedHelpers.callMethod(
            getService(),
            Methods.ConversationService.AddObserver.name,
            iConversationListObserver
        )

    /**
     * @param str String
     * @param userArr []
     * @param conversation
     * @param iCommonConversationOperateCallback
     */
//    fun createConversation(
//        str: String,
//        userArr: Array<Any>,
//        conversation: Any,
//        iCommonConversationOperateCallback: Any
//    ) =
//        XposedHelpers.callMethod(
//            str, userArr, conversation, iCommonConversationOperateCallback
//        )

    /**
     * @param conversation
     * @param iExitConversationCallback
     */
//    fun exitConversation(conversation: Any, iExitConversationCallback: Any) =
//        XposedHelpers.callMethod(
//            getService(), Methods.ConversationService.ExitConversation.name,
//            conversation, iExitConversationCallback
//        )

    /**
     * @param conversation
     * @param iDismissConversationCallback
     */
//    fun dismissConversation(conversation: Any, iDismissConversationCallback: Any) =
//        XposedHelpers.callMethod(
//            getService(), Methods.ConversationService.DismissConversation.name,
//            conversation, iDismissConversationCallback
//        )

    /**
     * @param conversation
     * @param name 群名称
     * @param iModifyConversationNameCallback
     */
//    fun modifyConversationName(conversation: Any, name: String, iModifyConversationNameCallback: Any) =
//        XposedHelpers.callMethod(
//            getService(), Methods.ConversationService.ModifyConversationName.name,
//            conversation, name, iModifyConversationNameCallback
//        )

    /**
     * @param conversation
     * @param nickname
     * @param iCoversationOperateCallback
     */
//    fun modifyConversationNickName(conversation: Any, nickname: String, iCoversationOperateCallback: Any) =
//        XposedHelpers.callMethod(
//            getService(), Methods.ConversationService.modifyConversationNickName.name,
//        )

    /**
     * @param conversation
     * @param iHideConversationCallback c
     */
//    fun hideConversation(conversation: Any, iHideConversationCallback: Any) =
//        XposedHelpers.callMethod(
//            getService(),
//            Methods.ConversationService.HideConversation.name,
//        )

    /**
     * 发送邀请添加某些人入群
     * @param conversation c
     * @param userArr
     * @param iConversationAddMemberCallback
     */
//    fun sendInvitation(conversation: Any, userArr: Array<Any>, iConversationAddMemberCallback: Any) =
//        XposedHelpers.callMethod(
//            getService(), Methods.ConversationService.SendInvitation.name,
//        )

    /**
     * @param conversation
     * @param userArr
     * @param str
     * @param iConversationAddMemberOperateCallback
     */
//    fun addMembers(conversation: Any, userArr: Array<Any>, str: String, iConversationAddMemberOperateCallback: Any) =
//        XposedHelpers.callMethod(
//        )

    /**
     * @param conversation
     * @param userArr
     * @param iRemoveMembersCallback
     */
//    fun removeMembers(conversation: Any, userArr: Array<Any>, iRemoveMembersCallback: Any) =
//        XposedHelpers.callMethod(
//            getService(), Methods.ConversationService.RemoveMembers.name,
//        )

    /**
     * @param conversation
     * @param userArr
     * @param iRemoveMembersCallback
     */
//    fun revokeMembers(conversation: Any, userArr: Array<Any>, iRemoveMembersCallback: Any) =
//        XposedHelpers.callMethod(
//        )

    /**
     * 刷新群信息
     * @param conversation
     * @param iConversationListCallback c
     */
//    fun updateConversationFromSvrWithinTime(conversation: Any, iConversationListCallback: Any) =
//        XposedHelpers.callMethod(
//            conversation, iConversationListCallback
//        )

    /**
     * @param keyword
     * @param iSearchUserCallback2
     * @param iSearchConversationCallback
     */
//    fun searchConversationsAndUsers(keyword: String, iSearchUserCallback2: Any, iSearchConversationCallback: Any) =
//        XposedHelpers.callMethod(
//        )

    /**
     * @param keyword
     * @param conversation
     * @param iSearchUserCallback c
     */
//    fun searchMembersInConversation(keyword: String, conversation: Any, iSearchUserCallback: Any) =
//        XposedHelpers.callMethod(
//            getService(), Methods.ConversationService.SearchMembersInConversation.name,
//            keyword, conversation, iSearchUserCallback
//        )

    /**
     * @param messageId
     * @param iSearchUserCallback
     */
//    fun pickMessage(messageId: Long, iPickMessageCallback: Any) =
//        XposedHelpers.callMethod(
//            getService(), Methods.ConversationService.pickMessage.name,
//            messageId, iPickMessageCallback
//        )

    /**
     * @param message
     * @param iRevokeMessageCallback c
     */
//    fun revokeMessage(message: Any, iRevokeMessageCallback: Any) =
//        XposedHelpers.callMethod(
//            getService(), Methods.ConversationService.RevokeMessage.name,
//            arrayOf(Message, IRevokeMessageCallback),
//            message, iRevokeMessageCallback
//        )

    /**
     * @param message
     * @param iRevokeMessageCallback
     */
//    fun revokeMessageByAck(message: Any, iRevokeMessageCallback: Any) =
//        XposedHelpers.callMethod(
//            getService(), Methods.ConversationService.RevokeMessageByAck.name,
//            message, iRevokeMessageCallback
//        )

    /**
     * @param conversation
     * @param message
     * @param count
     * @param z
     * @param iGetHistoryMessageCallback
     */
//    fun getHistoryMessage(conversation: Any, message: Any? = null, count: Int = 20, z: Boolean = false, iGetHistoryMessageCallback: Any) =
//        XposedHelpers.callMethod(
//            getService(), Methods.ConversationService.getHistoryMessage.name,
//            conversation, message, count, z, iGetHistoryMessageCallback
//        )

    /**
     * 收藏群
     * @param conversation
     * @param z
     * @param iCommonConversationOperateCallback
     */
//    fun saveGroupConvToContactList(conversation: Any, z: Boolean, iCommonConversationOperateCallback: Any) =
//        XposedHelpers.callMethod(
//            getService(), Methods.ConversationService.SaveGroupConvToContactList.name,
//            conversation, z, iCommonConversationOperateCallback
//        )

    /**
     * 获取群二维码
     * @param conversation
     * @param iCommonResultDataISBsCallback
     */
//    fun getConversationQRCode(conversation: Any, iCommonResultDataISBsCallback: Any) =
//        XposedHelpers.callMethod(
//            getService(), Methods.ConversationService.GetConversationQRCode.name,
//            conversation, iCommonResultDataISBsCallback
//        )

    /**
     * @param conversation
     * @param user
     * @param iCoversationOperateCallback
     */
//    fun setRoomOwner(conversation: Any, user: Any, iCoversationOperateCallback: Any) =
//        XposedHelpers.callMethod(
//            getService(), Methods.ConversationService.SetRoomOwner.name,
//            conversation, user, iCoversationOperateCallback
//        )

    /**
     * @param conversation
     * @param z
     * @param iCoversationOperateCallback
     */
//    fun setAllForbidden(conversation: Any, z: Boolean, iCoversationOperateCallback: Any) =
//        XposedHelpers.callMethod(
//            getService(), Methods.ConversationService.SetAllForbidden.name,
//            conversation, z, iCoversationOperateCallback
//        )

    /**
     * 设置群公告
     * @param conversation
     * @param richMessage
     * @param z
     * @param iCoversationOperateCallback
     */
//    fun setGroupNotification(conversation: Any, richMessage: Any, z: Boolean, iCoversationOperateCallback: Any) =
//        XposedHelpers.callMethod(
//            getService(), Methods.ConversationService.SetGroupNotification.name,
//            conversation, richMessage, z, iCoversationOperateCallback
//        )

    /**
     * 设置置顶
     * @param iSetConversationTopCallback
     */
//    fun setTop(conversation: Any, z: Boolean, iSetConversationTopCallback: Any) =
//        XposedHelpers.callMethod(
//            getService(), Methods.ConversationService.SetTop.name,
//            conversation, z, iSetConversationTopCallback
//        )

    /**
     * 设置免打扰
     */
//    fun setShield(conversation: Any, z: Boolean, iSetShieldCallback: Any) =
//        XposedHelpers.callMethod(
//            getService(), Methods.ConversationService.SetShield.name,
//            conversation, z, iSetShieldCallback
//        )

    /**
     * 获取免打扰及置顶群聊
     */
//    fun getShieldAndTopConversations(iGetShieldConversationCallback: Any, iGetTopConversationCallback: Any) =
//        XposedHelpers.callMethod(
//            getService(), Methods.ConversationService.GetShieldAndTopConversations.name,
//            iGetShieldConversationCallback, iGetTopConversationCallback
//        )

    /**
     * 设置添加成员前需要确认
     */
//    fun setConfirmAddMember(conversation: Any, z: Boolean, iCreateConversationCallback: Any) =
//            arrayOf(Conversation, Clazz.Boolean, ICreateConversationCallback),
//            conversation, z, iCreateConversationCallback
//        )

}