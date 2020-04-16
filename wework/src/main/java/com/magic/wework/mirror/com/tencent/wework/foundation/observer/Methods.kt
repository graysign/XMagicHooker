package com.magic.wework.mirror.com.tencent.wework.foundation.observer

import com.magic.kernel.core.Clazz
import com.magic.kernel.MagicGlobal.lazy
import com.magic.kernel.helper.ReflecterHelper.findMethodIfExists
import com.magic.kernel.helper.ReflecterHelper.findMethodsByExactParameters
import com.magic.wework.mirror.com.tencent.wework.foundation.model.Classes.Conversation
import com.magic.wework.mirror.com.tencent.wework.foundation.model.Classes.Message
import java.lang.reflect.Method

object Methods {

    object IConversationObserver {

        fun getMethodByName(name: String): Method? {
            return when (name) {
                "onSetReadReceipt" -> OnSetReadReceipt
                "onAddMembers" -> onAddMembers
                "onAddMessages" -> onAddMessages
                "onChangeOwner" -> onChangeOwner
                "onDraftDidChange" -> onDraftDidChange
                "onMessageStateChange" -> onMessageStateChange
                "onMessageUpdate" -> onMessageUpdate
                "onModifyName" -> onModifyName
                "onPropertyChanged" -> onPropertyChanged
                "onRemoveAllMessages" -> onRemoveAllMessages
                "onRemoveMembers" -> onRemoveMembers
                "onRemoveMessages" -> onRemoveMessages
                "onSetAllBan" -> onSetAllBan
                "onSetCollect" -> onSetCollect
                "onSetConfirmAddMember" -> onSetConfirmAddMember
                "onSetMembersBan" -> onSetMembersBan
                "onSetOwnerManager" -> onSetOwnerManager
                "onSetShield" -> onSetShield
                "onSetTop" -> onSetTop
                "onTypingStateUpdate" -> onTypingStateUpdate
                "onUnReadCountChanged" -> onUnReadCountChanged
                else -> null
            }
        }

        val OnSetReadReceipt: Method by lazy("${javaClass.name}.OnSetReadReceipt") {
            findMethodIfExists(Classes.IConversationObserverImpl, "OnSetReadReceipt", Conversation)
        }

        val onAddMembers: Method by lazy("${javaClass.name}.onAddMembers") {
            findMethodIfExists(Classes.IConversationObserverImpl, "onAddMembers", Conversation)
        }

        val onAddMessages: Method by lazy("${javaClass.name}.onAddMessages") {
            findMethodsByExactParameters(
                Classes.IConversationObserverImpl,
                null,
                Conversation,
                Clazz.arrayOf(Message),
                Clazz.Boolean
            ).firstOrNull()
        }

        val onChangeOwner: Method by lazy("${javaClass.name}.onChangeOwner") {
            findMethodIfExists(Classes.IConversationObserverImpl, "onChangeOwner", Conversation)
        }

        val onDraftDidChange: Method by lazy("${javaClass.name}.onDraftDidChange") {
            findMethodIfExists(Classes.IConversationObserverImpl, "onDraftDidChange", Conversation)
        }

        val onMessageStateChange: Method by lazy("${javaClass.name}.onMessageStateChange") {
            findMethodsByExactParameters(
                Classes.IConversationObserverImpl,
                null,
                Conversation,
                Message,
                Clazz.Int
            ).firstOrNull()
        }

        val onMessageUpdate: Method by lazy("${javaClass.name}.onMessageUpdate") {
            findMethodsByExactParameters(
                Classes.IConversationObserverImpl,
                null,
                Conversation,
                Message
            ).firstOrNull()
        }

        val onModifyName: Method by lazy("${javaClass.name}.onModifyName") {
            findMethodIfExists(Classes.IConversationObserverImpl, "onModifyName", Conversation)
        }

        val onPropertyChanged: Method by lazy("${javaClass.name}.onPropertyChanged") {
            findMethodIfExists(Classes.IConversationObserverImpl, "onPropertyChanged", Conversation)
        }

        val onRemoveAllMessages: Method by lazy("${javaClass.name}.onRemoveAllMessages") {
            findMethodIfExists(
                Classes.IConversationObserverImpl,
                "onRemoveAllMessages",
                Conversation
            )
        }

        val onRemoveMembers: Method by lazy("${javaClass.name}.onRemoveMembers") {
            findMethodIfExists(Classes.IConversationObserverImpl, "onRemoveMembers", Conversation)
        }

        val onRemoveMessages: Method by lazy("${javaClass.name}.onRemoveMessages") {
            findMethodsByExactParameters(
                Classes.IConversationObserverImpl,
                null,
                Conversation,
                Clazz.arrayOf(Message)
            ).firstOrNull()
        }

        val onSetAllBan: Method by lazy("${javaClass.name}.onSetAllBan") {
            findMethodIfExists(Classes.IConversationObserverImpl, "onSetAllBan", Conversation)
        }

        val onSetCollect: Method by lazy("${javaClass.name}.onSetCollect") {
            findMethodIfExists(Classes.IConversationObserverImpl, "onSetCollect", Conversation)
        }

        val onSetConfirmAddMember: Method by lazy("${javaClass.name}.onSetConfirmAddMember") {
            findMethodIfExists(
                Classes.IConversationObserverImpl,
                "onSetConfirmAddMember",
                Conversation
            )
        }

        val onSetMembersBan: Method by lazy("${javaClass.name}.onSetMembersBan") {
            findMethodIfExists(Classes.IConversationObserverImpl, "onSetMembersBan", Conversation)
        }

        val onSetOwnerManager: Method by lazy("${javaClass.name}.onSetOwnerManager") {
            findMethodIfExists(Classes.IConversationObserverImpl, "onSetOwnerManager", Conversation)
        }

        val onSetShield: Method by lazy("${javaClass.name}.onSetShield") {
            findMethodIfExists(Classes.IConversationObserverImpl, "onSetShield", Conversation)
        }

        val onSetTop: Method by lazy("${javaClass.name}.onSetTop") {
            findMethodIfExists(Classes.IConversationObserverImpl, "onSetTop", Conversation)
        }

        val onTypingStateUpdate: Method by lazy("${javaClass.name}.onTypingStateUpdate") {
            findMethodIfExists(
                Classes.IConversationObserverImpl,
                "onTypingStateUpdate",
                Conversation
            )
        }

        val onUnReadCountChanged: Method by lazy("${javaClass.name}.ourcc") {
            findMethodsByExactParameters(
                Classes.IConversationObserverImpl,
                null,
                Conversation,
                Clazz.Int,
                Clazz.Int
            ).firstOrNull()
        }

    }

}