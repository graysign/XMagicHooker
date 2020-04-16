package com.magic.wework.hookers.interfaces

interface IConversationHooker {

    /** ---------- com.tencent.wework.foundation.observer.IConversationListObserver ---------- */
    fun onReconvergeConversation() {}

    fun onReloadConvsProperty() {}

    /**
     * 状态参考： com.tencent.wework.observer.Constants.IConversationListObserverState
     *  const val STATE_INIT = 0
     *  const val STATE_FIRST_SYNCING = 1
     *  const val STATE_FIRST_SYNC_FAILED = 2
     *  const val STATE_CONNECTING = 3
     *  const val STATE_FETCHING = 4
     *  const val STATE_OK = 5
     *
     */
    fun onSyncStateChanged(i: Int, i2: Int) {}

    /**
     * @param conversationArr []com.tencent.wework.foundation.model.Conversation
     */
    fun onAddConversations(conversationArr: Array<Any>) {}

    /**
     * @param conversation com.tencent.wework.foundation.model.Conversation
     */
    fun onExitConversation(conversation: Any) {}


    /** ---------- com.tencent.wework.foundation.observer.IConversationObserver ---------- */


    /**
     * @param conversation com.tencent.wework.foundation.model.Conversation
     */
    fun onSetReadReceipt(conversation: Any) {}

    /**
     * @param conversation com.tencent.wework.foundation.model.Conversation
     */
    fun onAddMembers(conversation: Any) {}

    /**
     * conversation 添加了消息，他人发送过来的，或者我发送出去的，如果要做消息监听，实现此方法即可
     * @param conversation com.tencent.wework.foundation.model.Conversation
     * @param messageArr []com.tencent.wework.foundation.model.Message
     * @param z Boolean
     */
    fun onAddMessages(conversation: Any, messageArr: Array<Any>, z: Boolean) {}

    /**
     * @param conversation com.tencent.wework.foundation.model.Conversation
     */
    fun onChangeOwner(conversation: Any) {}

    /**
     * @param conversation com.tencent.wework.foundation.model.Conversation
     */
    fun onDraftDidChange(conversation: Any) {}

    /**
     * @param conversation com.tencent.wework.foundation.model.Conversation
     * @param message com.tencent.wework.foundation.model.Message
     * @param i Int
     */
    fun onMessageStateChange(conversation: Any, message: Any, i: Int) {}

    /**
     * @param conversation com.tencent.wework.foundation.model.Conversation
     * @param message com.tencent.wework.foundation.model.Message
     */
    fun onMessageUpdate(conversation: Any, message: Any) {}

    /**
     * @param conversation com.tencent.wework.foundation.model.Conversation
     */
    fun onModifyName(conversation: Any) {}

    /**
     * @param conversation com.tencent.wework.foundation.model.Conversation
     */
    fun onPropertyChanged(conversation: Any) {}

    /**
     * @param conversation com.tencent.wework.foundation.model.Conversation
     */
    fun onRemoveAllMessages(conversation: Any) {}

    /**
     * @param conversation com.tencent.wework.foundation.model.Conversation
     */
    fun onRemoveMembers(conversation: Any) {}

    /**
     * @param conversation com.tencent.wework.foundation.model.Conversation
     * @param message com.tencent.wework.foundation.model.Message
     */
    fun onRemoveMessages(conversation: Any, message: Any) {}

    /**
     * @param conversation com.tencent.wework.foundation.model.Conversation
     */
    fun onSetAllBan(conversation: Any) {}

    /**
     * @param conversation com.tencent.wework.foundation.model.Conversation
     */
    fun onSetCollect(conversation: Any) {}

    /**
     * @param conversation com.tencent.wework.foundation.model.Conversation
     */
    fun onSetConfirmAddMember(conversation: Any) {}

    /**
     * @param conversation com.tencent.wework.foundation.model.Conversation
     */
    fun onSetMembersBan(conversation: Any) {}

    /**
     * @param conversation com.tencent.wework.foundation.model.Conversation
     */
    fun onSetOwnerManager(conversation: Any) {}

    /**
     * @param conversation com.tencent.wework.foundation.model.Conversation
     */
    fun onSetShield(conversation: Any) {}

    /**
     * @param conversation com.tencent.wework.foundation.model.Conversation
     */
    fun onSetTop(conversation: Any) {}

    /**
     * @param conversation com.tencent.wework.foundation.model.Conversation
     */
    fun onTypingStateUpdate(conversation: Any) {}

    /**
     * @param conversation com.tencent.wework.foundation.model.Conversation
     * @param i Int
     * @param i2 Int
     */
    fun onUnReadCountChanged(conversation: Any, i: Int, i2: Int) {}

}