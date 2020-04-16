package com.magic.wework.apis.com.tencent.wework.msg.temp

class ConversationApiImpl {

    companion object {
        private var instance: ConversationApiImpl? = null

        @Synchronized
        fun newInstance(): ConversationApiImpl {
            if (instance == null) {
                instance = ConversationApiImpl()
            }
            return instance!!
        }

        /** 获取实例 */
//        private fun getConversationApi(): Any = MK.service(IConversation)

        /**
         * 获取会话Item，包含Conversation描述
         * @param localId
         */
//        private fun getConversationItem(localId: Long): Any? =
//            XposedHelpers.callMethod(
//                getConversationApi(), Methods.ConversationApiImpl.getConversationItem.name,
//                arrayOf(Clazz.Long), localId
//            )
//
//        private fun getConversationItemByRemoteId(remoteId: Long): Any? =
//            XposedHelpers.callMethod(
//                getConversationApi(),
//                remoteId
//            )

        /**
         * @param conversationItem
         * @return com.tencent.wework.foundation.model.Conversation
         */
//        private fun getConversation(conversationItem: Any): Any? =
//            XposedHelpers.callMethod(
//                arrayOf(Clazz.Object), conversationItem
//            )

        /**
         * 获取用户在群内的名称
         * @param userId 用户remoteId
         * @param conversationId 会话localId
         */
//        private fun getUserName(userId: Long, conversationId: Long): String =
//            XposedHelpers.callMethod(
//            ) as? String ?: ""

        /**
         * 更新用户信息
         * @param users []com.tencent.wework.foundation.model.User
         */
//        private fun updateUsers(users: Array<Any>, convId: Long = 0, update: Boolean = true) =
//            XposedHelpers.callMethod(
//            )

        /**
         * 更新会话缓存
         * @param conversations []com.tencent.wework.foundation.model.User
         */
//        private fun updateConversationCache(conversations: Array<Any>) =
//            XposedHelpers.callMethod(
//                arrayOf(Clazz.arrayOf(Conversation)), conversations
//            )

        /**
         * 清除所有未读消息
         */
//        private fun clearAllUnread(convId: Long) =
//            XposedHelpers.callMethod(
//                arrayOf(Clazz.Long), convId
//            )

        /**
         * 创建群聊
         * @param userArr []com.tencent.wework.foundation.model.User
         * @param iCommonConversationOperateCallback com.tencent.wework.foundation.callback.ICommonConversationOperateCallback
         */
//        private fun createConversation(
//            userArr: Array<Any>,
//            iCommonConversationOperateCallback: Any
//        ) =
//            XposedHelpers.callMethod(
//                userArr, iCommonConversationOperateCallback
//            )

        /**
         * 获取已存在的用户
         * @param remoteId
         * @return com.tencent.wework.foundation.model.User
         */
//        private fun getUserWithoutUpdate(remoteId: Long): Any? =
//            XposedHelpers.callMethod(
//                arrayOf(Clazz.Long), remoteId
//            )

    }

//    fun getConversationItem(id: Long): Any? {
//        var item = Companion.getConversationItem(id)
//        if (item == null) {
//            item = getConversationItemByRemoteId(id)
//        }
//        return item
//    }
//
//    fun getConversation(id: Long): Any? {
//        val conversationItem = getConversationItem(id)
//        return when (conversationItem != null) {
//            true -> Companion.getConversation(conversationItem)
//            false -> null
//        }
//    }
//
//    fun getConversationList(conversation: Any? = null, type: Int = -1): Array<Any> =
//        ConversationService.getConversationList(conversation, type)
//
//    fun getRoomConversationList(): Array<Any> =
//
//    fun getCollectionConvList(): Array<Any> =
//        ConversationService.getCollectionConvList()
//
//    fun getRoomCollectionConvList(): Array<Any> =
//
//    fun getUserName(userId: Long, convId: Long): String =
//
//    fun getUserWithoutUpdate(userId: Long): Any? =
//        try {
//        } catch (_: Throwable) {
//            null
//        }
//
//    fun getUserWithoutUpdate(userIds: LongArray): Array<Any> {
//        val userList = userIds.map { getUserWithoutUpdate(it) }.filterNotNull()
//        var userArr = java.lang.reflect.Array.newInstance(User, userList.size) as Array<Any>
//        return userArr
//    }
//
//    fun getIsExited(convId: Long): Boolean {
//        val conversation = getConversation(convId)
//        return when (conversation != null) {
//            true -> {
//                val conv = Conversation(conversation)
//                conv.getType() == 1 && conv.getInfo().exited
//            }
//            false -> false
//        }
//    }
//
//    fun getIsRoomOwner(convId: Long, userId: Long = -1): Boolean {
//        var uId = userId
//        if (userId < 0) {
//            uId = Profile.newInstance().userInfo.uin
//        }
//        return when (conversation != null) {
//            true -> {
//                val conv = Conversation(conversation)
//                conv.getType() == 1 && conv.getInfo().creatorId == uId
//            }
//            false -> false
//        }
//    }
//
//    fun getUserInConversation(convId: Long, userIds: LongArray): Array<Any> {
//        val conversation = getConversation(convId)
//        return when (conversation != null) {
//            true -> com.magic.wework.apis.com.tencent.wework.foundation.model.Conversation.getUserList(conversation, userIds)
//            false -> arrayOf()
//        }
//    }
//
//    fun isConversationExists(convId: Long): Boolean = getConversationItem(convId) != null
//
//    fun updateUsers(users: Array<Any>, conversationId: Long = 0, update: Boolean = true) =
//        Companion.updateUsers(users, conversationId, update)
//
//    fun updateConversationCache(conversations: Array<Any>) =
//        Companion.updateConversationCache(conversations)
//
//    fun clearAllUnread(convId: Long) {
//        if (isConversationExists(convId)) {
//            Companion.clearAllUnread(convId)
//        }
//    }
//
//    fun createConversation(userIds: LongArray, iCommonConversationOperateCallback: ICommonConversationOperateCallback? = null) {
//        UserManagerApiImpl.newInstance().getUserByIdWithScene(userIds) { i, userArr ->
//            when (i == 0 && userArr.isNotEmpty()) {
//                    }
//                    Companion.createConversation(userArr, callback)
//                false -> {
//                    iCommonConversationOperateCallback?.invoke(1, null, "创建会话失败，无用户数据")
//                }
//            }
//        }
//    }
//
//    fun exitConversation(convId: Long, iExitConversationCallback: IExitConversationCallback? = null) {
//        if (!checkWith(convId, exists = true, isRoom = true, isRoomOwner = false)) return
//        val conversation = getConversation(convId)!!
//        val callback = Proxy.newProxyInstance(
//        }
//        ConversationService.exitConversation(conversation, callback)
//    }
//
//    fun dismissConversation(convId: Long, iDismissConversationCallback: IDismissConversationCallback? = null) {
//        if (!checkWith(convId, exists = true, isRoom = true, isRoomOwner = true)) return
//        val conversation = getConversation(convId)!!
//        }
//        ConversationService.dismissConversation(conversation, callback)
//    }
//
//    fun sendInvitation(
//        convId: Long, userIds: LongArray,
//        iConversationAddMemberCallback: IConversationAddMemberCallback? = null
//    ) {
//        if (!checkWith(convId, exists = true, isRoom = true, isRoomOwner = true)) return
//        val conversation = getConversation(convId)!!
//        ConversationService.sendInvitation(conversation, userArr, callback)
//    }
//
//    fun revokeMembers(convId: Long, userIds: LongArray, iRemoveMembersCallback: IRemoveMembersCallback? = null) {
//        if (!checkWith(convId, exists = true, isRoom = true, isRoomOwner = true)) return
//        val conversation = getConversation(convId)!!
//            Log.e(ConversationApiImpl::class.java.name, "未找到群内任何相关的用户")
//            return
//        }
//        }
//        ConversationService.revokeMembers(conversation, userArr, callback)
//    }
//
//    fun addMembers(
//        convId: Long, userIds: LongArray, str: String = "",
//        iConversationAddMemberOperateCallback: IConversationAddMemberOperateCallback? = null
//    ) {
//        if (!checkWith(convId, exists = true, isRoom = false, isRoomOwner = false)) return
//        val conversation = getConversation(convId)!!
//        }
//            return@newProxyInstance iConversationAddMemberOperateCallback?.invoke(i, conversation, str, multiRoomTipsList)
//        }
//        ConversationService.addMembers(conversation, userArr, str, callback)
//    }
//
//    fun removeMembers(convId: Long, userIds: LongArray, iRemoveMembersCallback: IRemoveMembersCallback? = null) {
//        if (!checkWith(convId, exists = true, isRoom = true, isRoomOwner = true)) return
//        ConversationService.removeMembers(conversation, userArr, callback)
//    }
//
//    fun updateConversationFromSvrWithinTime(convId: Long, iConversationListCallback: IConversationListCallback? = null) {
//        if (!checkWith(convId, exists = true, isRoom = false, isRoomOwner = false)) return
//        val conversation = getConversation(convId)!!
//        val callback = Proxy.newProxyInstance(
//            }
//            return@newProxyInstance iConversationListCallback?.invoke(i, conversationArr)
//        }
//        ConversationService.updateConversationFromSvrWithinTime(conversation, callback)
//    }
//
//    fun searchConversationsAndUsers(keyword: String, iSearchUserCallback2: ISearchUserCallback2, iSearchConversationCallback: ISearchConversationCallback? = null) {
//        if (keyword.isEmpty()) {
//            Log.e(ConversationApiImpl::class.java.name, "关键字不能为空")
//            return
//        }
//        val userCallback2 = Proxy.newProxyInstance(
//            val result = args.last()
//            return@newProxyInstance iSearchConversationCallback?.invoke(i, result)
//        }
//        ConversationService.searchConversationsAndUsers(keyword, userCallback2, conversationCallback)
//    }
//
//    fun modifyConversationName(
//        convId: Long, name: String,
//        iModifyConversationNameCallback: IModifyConversationNameCallback? = null
//    ) {
//        if (!checkWith(convId, exists = true, isRoom = true, isRoomOwner = false)) return
//            val conversation = args.last()
//            return@newProxyInstance iModifyConversationNameCallback?.invoke(i, conversation)
//        }
//        ConversationService.modifyConversationName(conversation, name, callback)
//    }
//
//    fun modifyConversationNickName(convId: Long, nickname: String, iCoversationOperateCallback: ICoversationOperateCallback? = null) {
//        if (!checkWith(convId, exists = true, isRoom = true, isRoomOwner = false)) return
//        val conversation = getConversation(convId)!!
//        ConversationService.modifyConversationNickName(conversation, nickname, callback)
//    }
//
//    fun saveGroupConvToContactList(
//        convId: Long, z: Boolean,
//        iCommonConversationOperateCallback: ICommonConversationOperateCallback? = null
//    ) {
//        if (!checkWith(convId, exists = true, isRoom = true, isRoomOwner = false)) return
//        }
//        ConversationService.saveGroupConvToContactList(conversation, z, callback)
//    }
//
//    fun hideConversation(convId: Long, iHideConversationCallback: IHideConversationCallback? = null) {
//        if (!checkWith(convId, exists = true, isRoom = false, isRoomOwner = false)) return
//        val conversation = getConversation(convId)!!
//        val callback = Proxy.newProxyInstance(
//            classLoader,
//            return@newProxyInstance iHideConversationCallback?.invoke(i, conversation)
//        }
//        ConversationService.hideConversation(conversation, callback)
//    }
//
//    fun getShieldAndTopConversations(
//        iGetShieldConversationCallback: IGetShieldConversationCallback? = null,
//        iGetTopConversationCallback: IGetTopConversationCallback? = null
//    ) {
//        val shieldCallback = Proxy.newProxyInstance(
//            classLoader,
//            return@newProxyInstance iGetShieldConversationCallback?.invoke(i, conversationArr)
//        }
//
//        }
//        ConversationService.getShieldAndTopConversations(shieldCallback, topCallback)
//    }
//
//    fun getConversationQRCode(convId: Long, iCommonResultDataISBsCallback: ICommonResultDataISBsCallback? = null) {
//        if (!checkWith(convId, exists = true, isRoom = true, isRoomOwner = false)) return
//        val conversation = getConversation(convId)!!
//            return@newProxyInstance iCommonResultDataISBsCallback?.invoke(i, string, bArr)
//        }
//        ConversationService.getConversationQRCode(conversation, callback)
//    }
//
//    fun setRoomOwner(
//        convId: Long, userId: Long,
//        iCoversationOperateCallback: ICoversationOperateCallback? = null
//    ) {
//        if (!checkWith(convId, exists = true, isRoom = true, isRoomOwner = true)) return
//            return@newProxyInstance iCoversationOperateCallback?.invoke(i, conversation)
//        }
//        ConversationService.setRoomOwner(conversation, user, callback)
//    }
//
//    fun setAllForbidden(
//        convId: Long, z: Boolean = false,
//        iCoversationOperateCallback: ICoversationOperateCallback? = null
//    ) {
//        if (!checkWith(convId, exists = true, isRoom = true, isRoomOwner = true)) return
//        val conversation = getConversation(convId)!!
//        val callback = Proxy.newProxyInstance(
//            classLoader,
//            return@newProxyInstance iCoversationOperateCallback?.invoke(i, conversation)
//        }
//        ConversationService.setAllForbidden(conversation, z, callback)
//    }
//
//    fun setConfirmAddMember(
//        convId: Long, needConfirm: Boolean,
//        iCreateConversationCallback: ICreateConversationCallback? = null
//    ) {
//            arrayOf(ICreateConversationCallback)
//        ) { _, _, args ->
//            val i: Int = args.first().toString().toInt()
//            val conversation = args[1] as Any
//            return@newProxyInstance iCreateConversationCallback?.invoke(i, conversation)
//        }
//        ConversationService.setConfirmAddMember(conversation, needConfirm, callback)
//    }
//
//    fun setGroupNotification(
//        convId: Long, str: String, z: Boolean = false,
//        iCoversationOperateCallback: ICoversationOperateCallback? = null
//    ) {
//        if (!checkWith(convId, exists = true, isRoom = true, isRoomOwner = true)) return
//            val conversation = args.last()
//            return@newProxyInstance iCoversationOperateCallback?.invoke(i, conversation)
//        }
//        ConversationService.setGroupNotification(conversation, richMessage, z, callback)
//    }
//
//    fun setTop(
//        convId: Long, z: Boolean,
//        iSetConversationTopCallback: ISetConversationTopCallback? = null
//    ) {
//        if (!checkWith(convId, exists = true, isRoom = false, isRoomOwner = false)) return
//        val conversation = getConversation(convId)!!
//            val conversation = args.last()
//            return@newProxyInstance iSetConversationTopCallback?.invoke(i, conversation)
//        }
//        ConversationService.setTop(conversation, z, callback)
//    }
//
//    fun setShield(
//        convId: Long, z: Boolean,
//        iSetShieldCallback: ISetShieldCallback? = null
//    ) {
//        if (!checkWith(convId, exists = true, isRoom = false, isRoomOwner = false)) return
//            val conversation = args.last()
//            return@newProxyInstance iSetShieldCallback?.invoke(i, conversation)
//        }
//        ConversationService.setShield(conversation, z, callback)
//    }
//
//    private fun checkWith(convId: Long, exists: Boolean, isRoom: Boolean, isExited: Boolean = true, isRoomOwner: Boolean): Boolean {
//        if (!ProfileManager.checkCurrentProfileExist()) {
//            Log.e(ConversationApiImpl::class.java.name, "当前用户未登录")
//            return false
//        }
//        val conversation = getConversation(convId)
//                Log.e(ConversationApiImpl::class.java.name, "当前会话不存在 convId: $convId")
//                return false
//            }
//        }
//        if (isRoom) {
//            if (Conversation(conversation!!).getType() != 1) {
//                Log.e(ConversationApiImpl::class.java.name, "当前会话不是群，不支持此操作 convId: $convId")
//                return false
//            }
//        }
//        if (isExited) {
//            if (getIsExited(convId)) {
//                Log.e(ConversationApiImpl::class.java.name, "你已不在该会话内: $convId")
//                return false
//            }
//        }
//        if (isRoomOwner) {
//            if (!getIsRoomOwner(convId)) {
//                Log.e(ConversationApiImpl::class.java.name, "当前不是群聊或你不是群主: $convId")
//                return false
//            }
//        }
//        return true
//    }


}