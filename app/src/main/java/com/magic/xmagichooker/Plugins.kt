package com.magic.xmagichooker

import android.app.Activity
import android.os.Bundle
import android.util.Log
import com.magic.shared.hookers.interfaces.IActivityHooker
//import com.magic.wework.apis.com.google.protobuf.nano.MessageNano
//import com.magic.wework.apis.com.tencent.wework.contact.plugin.ContactApiImpl
//import com.magic.wework.apis.com.tencent.wework.contact.plugin.ContactManagerApiImpl
//import com.magic.wework.apis.com.tencent.wework.contact.plugin.DepartmentApiImpl
//import com.magic.wework.apis.com.tencent.wework.contact.plugin.UserManagerApiImpl
//import com.magic.wework.apis.com.tencent.wework.foundation.impl.WeworkServiceImpl
import com.magic.wework.hookers.interfaces.IApplicationHooker
import com.magic.wework.hookers.interfaces.IConversationHooker
import com.magic.wework.hookers.interfaces.INotificationHooker
import com.magic.wework.apis.com.tencent.wework.foundation.model.Conversation
import com.magic.wework.apis.com.tencent.wework.foundation.model.Message
import com.magic.wework.apis.com.tencent.wework.foundation.notification.NotificationInfo

object Plugins: IActivityHooker, IApplicationHooker, IConversationHooker, INotificationHooker {

    /*  ------------------  IActivityHooker  ----------------- */
    override fun onActivityCreated(activity: Activity, savedInstanceState: Bundle?) {
        Log.e(Plugins::class.java.name, "onActivityCreated   class: ${activity.javaClass}")
    }

    /*  ------------------  IConversationHooker  ----------------- */
    override fun onReconvergeConversation() {
        Log.e(Plugins::class.java.name, "onReconvergeConversation")
    }

    override fun onReloadConvsProperty() {
        Log.e(Plugins::class.java.name, "onReloadConvsProperty")
    }

    override fun onSyncStateChanged(i: Int, i2: Int) {
        Log.e(Plugins::class.java.name, "onSyncStateChanged  i: $i   i2: $i2")
    }

    override fun onAddConversations(conversationArr: Array<Any>) {
        for (conv in conversationArr) {
            Log.e(Plugins.javaClass.name, "onAddConversations  ${Conversation.getInfo(conv)}")
        }
//        ConversationApiImpl.newInstance().updateConversationCache(conversationArr)
//        for (conversation in conversationArr) {
//            val conv = Conversation(conversation)
//            Log.e(Plugins::class.java.name, "onAddConversations   remoteId: ${conv.getInfo().remoteId}  -  name: ${conv.getInfo().name}  -  type: ${conv.getInfo().type}")
//        }
    }

    override fun onExitConversation(conversation: Any) {
        Log.e(Plugins.javaClass.name, "onExitConversation  ${Conversation.getInfo(conversation)}")
//        val conv = Conversation(conversation)
//        Log.e(Plugins::class.java.name, "onExitConversation   remoteId: ${conv.getInfo().remoteId}  -  name: ${conv.getInfo().name}  -  type: ${conv.getInfo().type}")
    }

    override fun onSetReadReceipt(conversation: Any) {
        Log.e(Plugins.javaClass.name, "onSetReadReceipt  ${Conversation.getInfo(conversation)}")
//        val conv = Conversation(conversation)
//        Log.e(Plugins::class.java.name, "onSetReadReceipt   remoteId: ${conv.getInfo().remoteId}  -  name: ${conv.getInfo().name}  -  type: ${conv.getInfo().type}")
    }

    override fun onAddMembers(conversation: Any) {
        Log.e(Plugins.javaClass.name, "onAddMembers  ${Conversation.getInfo(conversation)}")
//        val conv = Conversation(conversation)
//        for (member in conv.getMembers()) {
//            Log.e(Plugins::class.java.name, "onAddMembers  remoteId: ${member.operatorRemoteId}  name: ${member.name}   nickname: ${member.nickName}")
//        }
    }

    override fun onAddMessages(conversation: Any, messageArr: Array<Any>, z: Boolean) {
        for (msg in messageArr) {
            Log.e(Plugins.javaClass.name, "onAddMessages  ${Conversation.getInfo(conversation)}     ${Message.getInfo(msg)}")
        }
//        val conv = Conversation(conversation)
//        for (message0 in messageArr) {
//            Log.e(Plugins::class.java.name, "onAddMessages   for   消息类型: ${Message(message0).getInfo().contentType}")
//            val messageItem = MessageItem(conversation, message0)
//            val contentType = WwMessage.Message.parseFrom(Message.getInfo(message0)).contentType
//            for (msg in messageItem.messages) {
//                when (msg.javaClass) {
//                    WwRichmessage.EmotionMessage::class.java -> {
//                        val msg = msg as WwRichmessage.EmotionMessage
//                        val downloadInfo = msg.getDownloadInfo(contentType)
//                        Log.e(Plugins.javaClass.name, "emotion消息类型: $contentType   地址：$downloadInfo")
//                        if (downloadInfo != null) {
//                            FileDownloadApiImpl.newInstance().downloadFile(downloadInfo) { i, str ->
//                                Log.e(Plugins.javaClass.name, "下载文件：${if (i == 0) "成功" else "失败"}")
//                            }
//                        }
//                    }
//                    WwRichmessage.FileMessage::class.java -> {
//                        val msg = msg as WwRichmessage.FileMessage
//                        val downloadInfo = msg.getDownloadInfo(contentType)
//                        Log.e(Plugins.javaClass.name, "文件消息类型: ${String(msg.extra)} $contentType   地址：$downloadInfo")
//                        if (downloadInfo != null) {
//                            FileDownloadApiImpl.newInstance().downloadFile(downloadInfo) { i, str ->
//                                Log.e(Plugins.javaClass.name, "下载文件：${if (i == 0) "成功" else "失败"}")
//                            }
//                        }
//                    }
//                    WwRichmessage.RichMessage::class.java -> {
//                        for (message in (msg as WwRichmessage.RichMessage).messages) {
//                            when (message.contentType) {
//                                WwMessage.kText, WwMessage.kFile -> {
//                                    val textMessage = WwRichmessage.TextMessage.parseFrom(message.data)
//                                    val timeInterval = System.currentTimeMillis() - (Message(message0).getInfo().sendTime.toLong() * 1000)
//                                    Log.e(Plugins::class.java.name, "onAddMessages 文本消息  ${textMessage.codeLanguage}  消息内容: ${String(textMessage.content)}   时间: $timeInterval")
//                                    val text = String(textMessage.content)
//                                    val textSplits = text.split(":")
//                                    if (timeInterval > 10000) return
//                                    if (text.startsWith("调试", true)) {
//                                        var userId: Long = 7881302516919397
//                                        var sceneType = 0
//                                        if (textSplits.size > 1) {
//                                            val splits = textSplits[1].split(",")
//                                            if (splits.size > 1) {
//                                                userId = splits.first().toString().toLong()
//                                                sceneType = splits.last().toString().toInt()
//                                            } else {
//                                                userId = textSplits.last().toString().toLong()
//                                            }
//                                        }
//                                        val user = ConversationApiImpl.newInstance().getUserWithoutUpdate(userId)
//                                        Log.e(Plugins.javaClass.name, "调试结果before  $userId  $sceneType  $user")
//                                        UserManagerApiImpl.newInstance().getUserByIdWithScene(longArrayOf(userId), sceneType = sceneType) { i, userArr ->
//                                            if (userArr.isNotEmpty()) {
//                                                val userInfos = userArr.map {
//                                                    val userSceneType = UserManagerApiImpl.newInstance().analysisSceneType(it)
//                                                    "rId: ${User(it).getRemoteId()}  sceneType: ${userSceneType.mSceneType} \n"
//                                                }
//                                                MsgApiImpl.newInstance().sendTextualMessage(conv.getLocalId(), "log-调试结果 $userInfos")
//                                            } else {
//                                                MsgApiImpl.newInstance().sendTextualMessage(conv.getLocalId(), "log-调试结果 $i    usersSize: ${userArr.size}")
//                                            }
//                                        }
//                                    } else if (text.startsWith("发送文本消息")) {
//                                        if (textSplits.size > 1) {
//                                            val splits = textSplits[1].split(",")
//                                            if (splits.size > 1) {
//                                                MsgApiImpl.newInstance().sendTextualMessage(splits.first().trim().toLong(), splits.last())
//                                            } else {
//                                                MsgApiImpl.newInstance().sendTextualMessage(conv.getInfo().id, splits.first())
//                                            }
//                                        } else {
//                                            MsgApiImpl.newInstance().sendTextualMessage(conv.getInfo().id, "log-发送消息指令错误，请输入:\n 发送消息:[userId/conversationId],消息内容")
//                                        }
//                                    } else if (text.startsWith("发送图片消息") || text.startsWith("发送语音消息") || text.startsWith("发送视频消息") || text.startsWith("发送文件消息")) {
//                                        var type = IHttpConfigs.Type.DEFAULT
//                                        if (textSplits.first().equals("发送图片消息", true)) {
//                                            type = IHttpConfigs.Type.IMAGE
//                                        } else if (textSplits.first().equals("发送语音消息", true)) {
//                                            type = IHttpConfigs.Type.VOICE
//                                        } else if (textSplits.first().equals("发送视频消息", true)) {
//                                            type = IHttpConfigs.Type.VIDEO
//                                        }
//                                        if (textSplits.size > 1) {
//                                            val splits = text.removeRange(0, 7).split(",")
//                                            var id = conv.getLocalId()
//                                            var urlString = ""
//                                            if (splits.size > 1) {
//                                                id = splits.first().toLong()
//                                                urlString = if (splits.last().toString().startsWith("http")) splits.last().toString() else ""
//                                            } else {
//                                                urlString = splits.last().toString()
//                                            }
//                                            Log.e(Plugins.javaClass.name, "发送xxx消息 id: $id  url: $urlString")
//                                            if (urlString.equals("", false)) {
//                                                MsgApiImpl.newInstance().sendTextualMessage(conv.getInfo().id, "log-发送文件消息指令错误，请输入:\n 发送xxx消息:[userId/conversationId],url地址")
//                                            } else {
//                                                MsgApiImpl.newInstance().sendRemoteFileMessage(id, urlString, type) { success, str ->
//                                                    Log.e(Plugins.javaClass.name, "发送 $type ${if (success) "成功" else "失败: $str"}")
//                                                }
//                                            }
//                                        } else {
//                                            MsgApiImpl.newInstance().sendTextualMessage(conv.getInfo().id, "log-发送文件消息指令错误，请输入:\n 发送xxx消息:[userId/conversationId],url地址")
//                                        }
//                                    } else if (text.startsWith("发送定位消息")) {
//                                        var id = conv.getLocalId()
//                                        if (textSplits.size > 1) {
//                                            id = textSplits.last().toString().trim().toLong()
//                                        }
//                                        MsgApiImpl.newInstance().sendLocationMessage(id, 30.545146942, 104.071510315, "天府软件园B6座(武侯区天华一路99号)", "武侯区天华路", 16.0, null)
//                                    } else if (text.startsWith("发送链接消息")) {
//                                        var id = conv.getLocalId()
//                                        if (textSplits.size > 1) {
//                                            id = textSplits.last().toString().trim().toLong()
//                                        }
//                                        MsgApiImpl.newInstance().sendLinkMessage(
//                                            id = id,
//                                            linkUrl = "http://mp.weixin.qq.com/s?__biz=MjM5MjAwODM4MA==&mid=2650734731&idx=1&sn=94bc42d867aa7d5173afe18cd4cda5bc&chksm=bea7715889d0f84ef82b85b9837cc88fafbfde98fed3969d2c4aeccd46c7fcf46d476d7a89eb&mpshare=1&scene=1&srcid=&sharer_sharetime=1576029680081&sharer_shareid=ab11eb11a7f2d31e2920d4dddbb1a62c#rd",
//                                            title = "GitHub 计划在中国开设分公司；苹果起诉两名中国籍前员工；Vulkan 1.1.130 发布| 极客头条",
//                                            description = "你期待吗？这里是测试的文案，description",
//                                            imageUrl = "http://static.yzscrm.com/msgfile/image/link/6768995955157187709.jpg"
//                                        )
//                                    } else if (text.startsWith("发送小程序消息")) {
//                                        var id = conv.getLocalId()
//                                        if (textSplits.size > 1) {
//                                            id = textSplits.last().toString().trim().toLong()
//                                        }
//                                        MsgApiImpl.newInstance().sendWeAppMessage(
//                                            id = id,
//                                            appid = "wxbebb3cdd9b331046",
//                                            username = "gh_dc5faf6be488@app",
//                                            title = "国务院客户端小程序，你身边的中央人民政府",
//                                            desc = "暂无",
//                                            pagepath = "pages/index/index.html",
//                                            version = 116,
//                                            type = 2,
//                                            thumbUrl = "http://wx.qlogo.cn/mmhead/Q3auHgzwzM5hhxkZWzUUU5z4sI8CGeLymmm49EcS3y7iaiciaiahfzkrUw/96",
//                                            weappIconUrl = "http://wx.qlogo.cn/mmhead/Q3auHgzwzM5hhxkZWzUUU5z4sI8CGeLymmm49EcS3y7iaiciaiahfzkrUw/96"
//                                        )
//                                    } else if (text.startsWith("获取所有群聊")) {
//                                        val conversations = ConversationApiImpl.newInstance().getRoomConversationList()
//                                        val conversationInfos = conversations.map {
//                                            val conv = Conversation(it)
//                                            val convName = if (conv.getInfo().name.isEmpty()) conv.getDefaultName(true) else conv.getInfo().name
//                                            return@map "群rId: ${conv.getRemoteId()}  type: ${conv.getType()}  群名称: $convName \n"
//                                        }
//                                        MsgApiImpl.newInstance().sendTextualMessage(conv.getInfo().id, "log-获取所有群聊信息: \n$conversationInfos")
//                                    } else if (text.startsWith("获取保存到通讯录的群聊")) {
//                                        val conversations = ConversationApiImpl.newInstance().getRoomCollectionConvList()
//                                        val conversationInfos = conversations.map {
//                                            val conv = Conversation(it)
//                                            return@map "群rId: ${conv.getRemoteId()}  群名称: ${conv.getDefaultName(true)}"
//                                        }
//                                        MsgApiImpl.newInstance().sendTextualMessage(conv.getInfo().id, "log-获取保存到通讯录的群聊: \n$conversationInfos")
//                                    } else if (text.startsWith("获取免打扰及置顶会话")) {
//                                        ConversationApiImpl.newInstance().getShieldAndTopConversations(
//                                            iGetShieldConversationCallback = { i, conversationArr ->
//                                                if (i == 0) {
//                                                    val conversationInfos = conversationArr.map {
//                                                        val conv = Conversation(it)
//                                                        val convName = if (conv.getInfo().name.isEmpty()) conv.getDefaultName(true) else conv.getInfo().name
//                                                        return@map "群rId: ${conv.getRemoteId()}  type: ${conv.getType()}  群名称: $convName \n"
//                                                    }
//                                                    MsgApiImpl.newInstance().sendTextualMessage(conv.getInfo().id, "log-获取到免打扰会话: \n$conversationInfos")
//                                                } else {
//                                                    MsgApiImpl.newInstance().sendTextualMessage(conv.getInfo().id, "log-获取到免打扰会话: 失败")
//                                                }
//                                            },
//                                            iGetTopConversationCallback = { i, conversationArr ->
//                                                if (i == 0) {
//                                                    val conversationInfos = conversationArr.map {
//                                                        val conv = Conversation(it)
//                                                        val convName = if (conv.getInfo().name.isEmpty()) conv.getDefaultName(true) else conv.getInfo().name
//                                                        return@map "群rId: ${conv.getRemoteId()}  type: ${conv.getType()}  群名称: $convName \n"
//                                                    }
//                                                    MsgApiImpl.newInstance().sendTextualMessage(conv.getInfo().id, "log-获取到置顶会话: \n$conversationInfos")
//                                                } else {
//                                                    MsgApiImpl.newInstance().sendTextualMessage(conv.getInfo().id, "log-获取到置顶会话: 失败")
//                                                }
//                                            }
//                                        )
//                                    } else if (text.startsWith("获取群二维码")) {
//                                        ConversationApiImpl.newInstance().getConversationQRCode(conv.getLocalId()) { i, str, bArr ->
//                                            if (i == 0 && bArr.isNotEmpty()) {
//                                                LRUCache.cacheInDisk(dir = "qrcode", key = "qrcodegroup_${conv.getLocalId()}", content = bArr) { path ->
//                                                    if (path != null) {
//                                                        MsgApiImpl.newInstance().sendImageMessage(conv.getLocalId(), path!!)
//                                                    } else {
//                                                        MsgApiImpl.newInstance().sendTextualMessage(conv.getLocalId(), "log-获取群二维码: 存储失败 $str")
//                                                    }
//                                                }
//                                            } else {
//                                                MsgApiImpl.newInstance().sendTextualMessage(conv.getLocalId(), "log-获取群二维码: 获取失败 $str")
//                                            }
//                                        }
//                                    } else if (text.startsWith("保存到通讯录")) {
//                                        var convId = conv.getLocalId()
//                                        if (textSplits.size > 1) {
//                                            convId = textSplits.last().trim().toLong()
//                                        }
//                                        ConversationApiImpl.newInstance().saveGroupConvToContactList(convId, true) { i, _, _ ->
//                                            MsgApiImpl.newInstance().sendTextualMessage(conv.getInfo().id, "log-保存到通讯录: ${if (i == 0) "成功" else "失败" }")
//                                        }
//                                    } else if (text.startsWith("创建新群聊")) {
//                                        if (textSplits.size > 1) {
//                                            val userIds = textSplits[1].split(",").map { it.trim().toLong() }.toLongArray()
//                                            if (userIds.size > 1) {
//                                                ConversationApiImpl.newInstance().createConversation(userIds) { i, conversation, str ->
//                                                    if (i == 0 && conversation != null) {
//                                                        val newConv = Conversation(conversation)
//                                                        MsgApiImpl.newInstance().sendTextualMessage(conv.getInfo().id, "log-创建群聊成功 \n群lId: ${newConv.getInfo().id}   \n群rId: ${newConv.getInfo().remoteId}  \n群名称: ${newConv.getDefaultName(true)}")
//                                                    } else {
//                                                        MsgApiImpl.newInstance().sendTextualMessage(conv.getInfo().id, "log-创建群聊失败")
//                                                    }
//                                                }
//                                            } else {
//                                                MsgApiImpl.newInstance().sendTextualMessage(conv.getInfo().id, "log-至少输入两个正确的用户id，如果不知道用户id \n\n 请输入: \"获取我的好友\" 获取")
//                                            }
//                                        } else {
//                                            MsgApiImpl.newInstance().sendTextualMessage(conv.getInfo().id, "log-请按照以下格式输入：\n 创建新群聊: userId0, userId1, userId2... \n 如果不知道用户id \n 请输入: \"获取我的好友\" 获取")
//                                        }
//                                    } else if (text.startsWith("解散群聊")) {
//                                        var convId = conv.getLocalId()
//                                        if (textSplits.size > 1) {
//                                            convId = textSplits.last().trim().toLong()
//                                        }
//                                        ConversationApiImpl.newInstance().dismissConversation(convId) { i ->
//                                            MsgApiImpl.newInstance().sendTextualMessage(conv.getInfo().id, "log-解散群聊 ${if (i == 0) "成功" else "失败" }")
//                                        }
//                                    } else if (text.startsWith("更新会话信息")) {
//                                        var convId = conv.getLocalId()
//                                        if (textSplits.size > 1) {
//                                            convId = textSplits.last().trim().toLong()
//                                        }
//                                        ConversationApiImpl.newInstance().updateConversationFromSvrWithinTime(convId) { i, conversationArr ->
//                                            if (i == 0 && conversationArr != null) {
//                                                val conversationInfos = conversationArr.map {
//                                                    val conv = Conversation(it)
//                                                    return@map "群rId: ${conv.getRemoteId()}  群名称: ${conv.getDefaultName(true)}"
//                                                }
//                                                MsgApiImpl.newInstance().sendTextualMessage(conv.getInfo().id, "log-更新会话信息: \n$conversationInfos")
//                                            } else {
//                                                MsgApiImpl.newInstance().sendTextualMessage(conv.getInfo().id, "log-更新会话信息: 失败")
//                                            }
//                                        }
//                                    } else if (text.startsWith("邀请他人入群")) {
//                                        if (textSplits.size > 1) {
//                                            val splits = textSplits[1].split(",")
//                                            if (splits.size > 1) {
//                                                val convId = splits.first().trim().toLong()
//                                                val userId = splits.last().trim().toLong()
//                                                ConversationApiImpl.newInstance().sendInvitation(convId, longArrayOf(userId)) { i, conversation, bArr ->
//                                                    MsgApiImpl.newInstance().sendTextualMessage(conv.getInfo().id, "log-邀请他人入群 ${if (i == 0) "成功" else "失败" }")
//                                                }
//                                            } else {
//                                                MsgApiImpl.newInstance().sendTextualMessage(conv.getInfo().id, "log-邀请他人入群指令错误, 请按照如下格式: \n 邀请他人入群:convId,userId")
//                                            }
//                                        } else {
//                                            MsgApiImpl.newInstance().sendTextualMessage(conv.getInfo().id, "log-邀请他人入群指令错误, 请按照如下格式: \n 邀请他人入群:convId,userId")
//                                        }
//                                    } else if (text.startsWith("撤回邀请")) {
//                                        if (textSplits.size > 1) {
//                                            val splits = textSplits[1].split(",")
//                                            if (splits.size > 1) {
//                                                val convId = splits.first().trim().toLong()
//                                                val userId = splits.last().trim().toLong()
//                                                ConversationApiImpl.newInstance().revokeMembers(convId, longArrayOf(userId)) { i, conversation ->
//                                                    MsgApiImpl.newInstance().sendTextualMessage(conv.getInfo().id, "log-撤回邀请 ${if (i == 0) "成功" else "失败" }")
//                                                }
//                                            } else {
//                                                MsgApiImpl.newInstance().sendTextualMessage(conv.getInfo().id, "log-撤回邀请指令错误, 请按照如下格式: \n 撤回邀请:convId,userId")
//                                            }
//                                        } else {
//                                            MsgApiImpl.newInstance().sendTextualMessage(conv.getInfo().id, "log-撤回邀请指令错误, 请按照如下格式: \n 撤回邀请:convId,userId")
//                                        }
//                                    } else if (text.startsWith("添加他人入群")) {
//                                        if (textSplits.size > 1) {
//                                            val splits = textSplits[1].split(",")
//                                            if (splits.size > 1) {
//                                                val convId = splits.first().trim().toLong()
//                                                val userId = splits.last().trim().toLong()
//                                                ConversationApiImpl.newInstance().addMembers(convId, longArrayOf(userId)) { i, conversation, str, multiRoomTipsList ->
//                                                    MsgApiImpl.newInstance().sendTextualMessage(conv.getInfo().id, "log-添加他人入群 ${if (i == 0) "成功" else "失败" }")
//                                                }
//                                            } else {
//                                                MsgApiImpl.newInstance().sendTextualMessage(conv.getInfo().id, "log-添加他人入群指令错误, 请按照如下格式: \n 添加他人入群:convId,userId")
//                                            }
//                                        } else {
//                                            MsgApiImpl.newInstance().sendTextualMessage(conv.getInfo().id, "log-添加他人入群指令错误, 请按照如下格式: \n 添加他人入群:convId,userId")
//                                        }
//                                    } else if (text.startsWith("移除群聊")) {
//                                        if (textSplits.size > 1) {
//                                            val splits = textSplits[1].split(",")
//                                            if (splits.size > 1) {
//                                                val convId = splits.first().trim().toLong()
//                                                val userId = splits.last().trim().toLong()
//                                                ConversationApiImpl.newInstance().removeMembers(convId, longArrayOf(userId)) { i, conversation ->
//                                                    MsgApiImpl.newInstance().sendTextualMessage(conv.getInfo().id, "log-移除群聊 ${if (i == 0) "成功" else "失败，你不是群主" }")
//                                                }
//                                            } else {
//                                                MsgApiImpl.newInstance().sendTextualMessage(conv.getInfo().id, "log-移除群聊指令错误, 请按照如下格式: \n 移除群聊:convId,userId")
//                                            }
//                                        } else {
//                                            MsgApiImpl.newInstance().sendTextualMessage(conv.getInfo().id, "log-移除群聊指令错误, 请按照如下格式: \n 移除群聊:convId,userId")
//                                        }
//                                    } else if (text.startsWith("获取成员信息")) {
//                                        var convId = conv.getLocalId()
//                                        if (textSplits.size > 1) {
//                                            convId = textSplits.last().trim().toLong()
//                                        }
//                                        val conversation = ConversationApiImpl.newInstance().getConversation(convId)
//                                        if (conversation != null) {
//                                            val members = Conversation(conversation).getMembers().map { "${it.userRemoteId}     ${ConversationApiImpl.newInstance().getUserName(it.userRemoteId, Conversation(conversation).getLocalId())} \n" }
//                                            MsgApiImpl.newInstance().sendTextualMessage(conv.getInfo().id, "成员信息: \n $members")
//                                        } else {
//                                            MsgApiImpl.newInstance().sendTextualMessage(conv.getInfo().id, "log-获取会话成员: 失败，当前会话不存在")
//                                        }
//                                    } else if (text.startsWith("清除未读消息")) {
//                                        var convId = conv.getLocalId()
//                                        if (textSplits.size > 1) {
//                                            convId = textSplits.last().trim().toLong()
//                                        }
//                                        ConversationApiImpl.newInstance().clearAllUnread(convId)
//                                        Log.e(Plugins.javaClass.name, "log-清除未读消息 成功")
//                                    } else if (text.startsWith("退出群聊")) {
//                                        val conversationId = if (textSplits.size > 1) textSplits[1].trim().toLong() else conv.getInfo().id
//                                        ConversationApiImpl.newInstance().exitConversation(conversationId) { i, conversation ->
//                                            Log.e(Plugins.javaClass.name, "log-退出群聊 ${if (i == 0) "成功" else "失败"}")
//                                        }
//                                    } else if (text.startsWith("修改群名称")) {
//                                        val name = if (textSplits.size > 1) textSplits[1].trim() else "测试修改群名称"
//                                        ConversationApiImpl.newInstance().modifyConversationName(conv.getInfo().id, name) { i, conversation ->
//                                            MsgApiImpl.newInstance().sendTextualMessage(conv.getInfo().id, "log-修改群名称：${if (i == 0) "成功" else "失败" }")
//                                        }
//                                    } else if (text.startsWith("修改群内昵称")) {
//                                        val nickname = if (textSplits.size > 1) textSplits[1].trim() else "测试修改群内昵称"
//                                        ConversationApiImpl.newInstance().modifyConversationNickName(conv.getInfo().id, nickname) { i, conversation ->
//                                            MsgApiImpl.newInstance().sendTextualMessage(conv.getInfo().id, "log-修改群名称：${if (i == 0) "成功" else "失败" }")
//                                        }
//                                    } else if (text.startsWith("撤回该条消息")) {
//                                        MsgApiImpl.newInstance().revokeMessage(conv.getLocalId(), Message(message0).getInfo().id) { i, message ->
//                                            MsgApiImpl.newInstance().sendTextualMessage(conv.getInfo().id, "log-撤回该条消息：${if (i == 0) "成功" else "失败" }")
//                                        }
//                                    } else if (text.startsWith("设置群公告")) {
//                                        var convId = conv.getLocalId()
//                                        var notification = "测试群公告"
//                                        if (textSplits.size > 1) {
//                                            val splits = textSplits[1].split(",")
//                                            if (splits.size > 1) {
//                                                convId = splits.first().trim().toLong()
//                                                notification = splits.last().toString()
//                                            } else {
//                                                notification = splits.last().toString()
//                                            }
//                                        }
//                                        ConversationApiImpl.newInstance().setGroupNotification(convId, notification) { i, conversation ->
//                                            MsgApiImpl.newInstance().sendTextualMessage(conv.getInfo().id, "log-设置群公告：${if (i == 0) "成功" else "失败" }")
//                                        }
//                                    } else if (text.startsWith("置顶")) {
//                                        ConversationApiImpl.newInstance().setTop(conv.getInfo().id, true) { i, conversation ->
//                                            MsgApiImpl.newInstance().sendTextualMessage(conv.getInfo().id, "log-置顶该群: ${if (i == 0) "成功" else "失败" }")
//                                        }
//                                    } else if (text.startsWith("取消置顶")) {
//                                        ConversationApiImpl.newInstance().setTop(conv.getInfo().id, false) { i, conversation ->
//                                            MsgApiImpl.newInstance().sendTextualMessage(conv.getInfo().id, "log-取消置顶该群: ${if (i == 0) "成功" else "失败" }")
//                                        }
//                                    } else if (text.startsWith("免打扰")) {
//                                        ConversationApiImpl.newInstance().setShield(conv.getInfo().id, true) { i, conversation ->
//                                            MsgApiImpl.newInstance().sendTextualMessage(conv.getInfo().id, "log-设置免打扰: ${if (i == 0) "成功" else "失败" }")
//                                        }
//                                    } else if (text.startsWith("取消免打扰")) {
//                                        ConversationApiImpl.newInstance().setShield(conv.getInfo().id, false) { i, conversation ->
//                                            MsgApiImpl.newInstance().sendTextualMessage(conv.getInfo().id, "log-取消免打扰: ${if (i == 0) "成功" else "失败" }")
//                                        }
//                                    } else if (text.startsWith("获取缓存的联系人")) {
//                                        val userInfos = ContactApiImpl.newInstance().getCachedContactList().map {
//                                            val user = User(it)
//                                            Log.e(Plugins.javaClass.name, "获取缓存的联系人 $user")
//                                            var userSceneType = UserManagerApiImpl.newInstance().getUserSceneType(it)
//                                            return@map "rid: ${user.getRemoteId()}  name: ${user.getInfo().name}  sceneType: ${userSceneType.mSceneType} convId: ${userSceneType.mId} \n"
//                                        }
//                                        MsgApiImpl.newInstance().sendTextualMessage(conv.getLocalId(), "log-获取缓存联系人: \n$userInfos")
//                                    } else if (text.startsWith("获取我的二维码")) {
//                                        ContactApiImpl.newInstance().getMyQRCodeImage(true) { i, bArr ->
//                                            if (i == 0 && bArr.isNotEmpty()) {
//                                                LRUCache.cacheInDisk(dir = "qrcode", key = "qrcode", content = bArr) { path ->
//                                                    if (path != null) {
//                                                        MsgApiImpl.newInstance().sendImageMessage(conv.getLocalId(), path!!)
//                                                    } else {
//                                                        MsgApiImpl.newInstance().sendTextualMessage(conv.getLocalId(), "log-获取我的二维码: 存储失败")
//                                                    }
//                                                }
//                                            } else {
//                                                MsgApiImpl.newInstance().sendTextualMessage(conv.getLocalId(), "log-获取我的二维码: 获取失败")
//                                            }
//                                        }
//                                    } else if (text.startsWith("获取二维码")) {
//                                        var type = ContactService.GETCONTACT_BY_QR_CODE
//                                        if (textSplits.size > 1) {
//                                            type = textSplits.last().trim().toInt()
//                                        }
//                                        ContactApiImpl.newInstance().getMyQRCodeImageWithStyle(type) { i, bArr ->
//                                            if (i == 0 && bArr.isNotEmpty()) {
//                                                LRUCache.cacheInDisk(dir = "qrcode", key = "qrcodewithstyle", content = bArr) { path ->
//                                                    if (path != null) {
//                                                        MsgApiImpl.newInstance().sendImageMessage(conv.getLocalId(), path!!)
//                                                    } else {
//                                                        MsgApiImpl.newInstance().sendTextualMessage(conv.getLocalId(), "log-获取二维码: 存储失败")
//                                                    }
//                                                }
//                                            } else {
//                                                MsgApiImpl.newInstance().sendTextualMessage(conv.getLocalId(), "log-获取二维码: 获取失败")
//                                            }
//                                        }
//                                    } else if (text.startsWith("获取公司信息")) {
//                                        ContactApiImpl.newInstance().getOpenCorpInfo(true) { i, j, str ->
//                                            MsgApiImpl.newInstance().sendTextualMessage(conv.getLocalId(), "log-获取公司信息: $i  $j  $str")
//                                        }
//                                    } else if (text.startsWith("修改客户备注")) {
//                                        if (textSplits.size > 1) {
//                                            val userId = textSplits.last().trim().toLong()
//                                            ContactManagerApiImpl.newInstance().updateContactRemarkInfo(userId, realRemark = "外部客户备注", remarks = "这是设置的描述",
//                                                companyRemark = "成都医云测试", remarkPhone = "15308220151,15308220152",
//                                                remarkUrl = "http://b.hiphotos.baidu.com/image/pic/item/0eb30f2442a7d9337119f7dba74bd11372f001e0.jpg") { i, str ->
//                                                MsgApiImpl.newInstance().sendTextualMessage(conv.getInfo().id, "log-修改客户备注: ${if (i == 0) "成功" else "失败" }  \n$str")
//                                            }
//                                        } else {
//                                            MsgApiImpl.newInstance().sendTextualMessage(conv.getInfo().id, "log-修改同事备注指令错误, 请按照如下格式: \n 修改同事备注:userId")
//                                        }
//                                    } else if (text.startsWith("修改同事备注")) {
//                                        if (textSplits.size > 1) {
//                                            val splits = textSplits[1].split(",")
//                                            var realRemark = "备注"
//                                            var remarks = "描述"
//                                            val userId = splits.first().trim().toLong()
//                                            if (splits.size > 2) {
//                                                realRemark = splits[1].toString()
//                                                remarks = splits.last().toString()
//                                            } else if (splits.size > 1) {
//                                                realRemark = splits.last().toString()
//                                            }
//                                            ContactManagerApiImpl.newInstance().updateColleagueRemarkItems(userId, realRemark, remarks) { i, str ->
//                                                MsgApiImpl.newInstance().sendTextualMessage(conv.getInfo().id, "log-修改同事备注: ${if (i == 0) "成功" else "失败" }  \n$str")
//                                            }
//                                        } else {
//                                            MsgApiImpl.newInstance().sendTextualMessage(conv.getInfo().id, "log-修改同事备注指令错误, 请按照如下格式: \n 修改同事备注:userId,备注,描述")
//                                        }
//                                    } else if (text.startsWith("搜索联系人")) {
//                                        if (textSplits.size > 1) {
//                                            val keyword = textSplits.last().trim()
//                                            ContactManagerApiImpl.newInstance().searchContact(keyword) { i, str, userArr ->
//                                                val userInfos = userArr.map {
//                                                    val user = User(it)
//                                                    "rId: ${user.getRemoteId()}   name: ${user.getName()} \n"
//                                                }
//                                                MsgApiImpl.newInstance().sendTextualMessage(conv.getInfo().id, "log-搜索联系人 $i - $str \n 信息:$userInfos")
//                                            }
//                                        } else {
//                                            MsgApiImpl.newInstance().sendTextualMessage(conv.getInfo().id, "log-搜索联系人指令错误, 请按照如下格式: \n 搜索联系人:key")
//                                        }
//                                    } else if (text.startsWith("搜索本地联系人")) {
//                                        if (textSplits.size > 1) {
//                                            val keyword = textSplits.last().trim()
//                                            ContactManagerApiImpl.newInstance().searchLocalContact(keyword = keyword) { i, userArr ->
//                                                val userInfos = userArr.map {
//                                                    val user = User(it)
//                                                    "rId: ${user.getRemoteId()}   name: ${user.getDisplayName()} \n"
//                                                }
//                                                MsgApiImpl.newInstance().sendTextualMessage(conv.getInfo().id, "log-搜索本地联系人 $i \n 信息:$userInfos")
//                                            }
//                                        } else {
//                                            MsgApiImpl.newInstance().sendTextualMessage(conv.getInfo().id, "log-搜索本地联系人指令错误, 请按照如下格式: \n 搜索本地联系人:key")
//                                        }
//                                    } else if (text.startsWith("标记联系人")) {
//                                        var userId: Long = 7881302516919397
//                                        if (textSplits.size > 1) {
//                                            userId = textSplits.last().toString().toLong()
//                                        }
//                                        ContactManagerApiImpl.newInstance().markClient(userId) { i, strArr, str ->
//                                            MsgApiImpl.newInstance().sendTextualMessage(conv.getInfo().id, "log-标记联系人 $i \n strArr:$strArr.to \n str: $str")
//                                        }
//                                    } else if (text.startsWith("获取被标记的联系人")) {
//                                        ContactApiImpl.newInstance().getMarkableContacts { i, userArr, jArr ->
//                                            val userInfos = userArr.map {
//                                                val userInfo = User(it).getInfo()
//                                                "rId: ${userInfo.remoteId}   name: ${userInfo.name} \n"
//                                            }
//                                            MsgApiImpl.newInstance().sendTextualMessage(conv.getInfo().id, "log-标记联系人 $i \n userInfos: $userInfos \n jArr: ${jArr.toString()}")
//                                        }
//                                    } else if (text.startsWith("获取一级部门信息")) {
//                                        DepartmentApiImpl.newInstance().getRootDepartmentList(true) { i, departmentArr ->
//                                            if (i == 0) {
//                                                if (departmentArr.isNotEmpty()) {
//                                                    val deptIds = departmentArr.mapNotNull { Department(it).getInfo().extras?.dualId }.toLongArray()
//                                                    DepartmentApiImpl.newInstance().getDualDepartmentListByIds(deptIds) { i, departmentArr ->
//                                                        if (i == 0) {
//                                                            var departmentsInfo = departmentArr.map {
//                                                                var department = Department(it).getInfo()
//                                                                "rId: ${department.remoteId}  名称: ${department.name}  是否有子部门: ${department.hasSon} \n"
//                                                            }
//                                                            MsgApiImpl.newInstance().sendTextualMessage(conv.getLocalId(), "log-这里是getDualDepartmentListByIds测试: \n $departmentsInfo")
//                                                        }
//                                                    }
//                                                }
//                                                var departmentsInfo = departmentArr.map {
//                                                    var department = Department(it).getInfo()
//                                                    "rId: ${department.remoteId}  名称: ${department.name}  openapiPartyid: ${department.openapiPartyid} \n"
//                                                }
//                                                MsgApiImpl.newInstance().sendTextualMessage(conv.getLocalId(), "log-获取一级部门信息: \n $departmentsInfo")
//                                            } else {
//                                                MsgApiImpl.newInstance().sendTextualMessage(conv.getLocalId(), "log-获取一级部门信息 失败 $i")
//                                            }
//                                        }
//                                    } else if (text.startsWith("获取部门用户信息")) {
//                                        var departmentId = 1688852946270840
//                                        if (textSplits.size > 1) {
//                                            departmentId = textSplits.last().trim().toLong()
//                                        }
//                                        DepartmentApiImpl.newInstance().getDepartmentUserMap(longArrayOf(departmentId)) { i, userArr ->
//                                            if (i == 0) {
//                                                val userInfos = userArr.map {
//                                                    val user = User(it)
//                                                    var userSceneType = UserManagerApiImpl.newInstance().analysisSceneType(it)
//                                                    return@map "rId: ${user.getRemoteId()}   name: ${user.getName()}  sceneType: ${userSceneType.mSceneType}  ${userSceneType.mId}\n"
//                                                }
//                                                MsgApiImpl.newInstance().sendTextualMessage(conv.getLocalId(), "log-获取部门用户信息: \n $userInfos \n 总人数: ${userInfos.size}")
//                                            } else {
//                                                MsgApiImpl.newInstance().sendTextualMessage(conv.getInfo().id, "log-获取部门用户信息 失败 $i")
//                                            }
//                                        }
//                                    } else if (text.startsWith("获取二级部门信息")) {
//                                        DepartmentApiImpl.newInstance().getRootDepartmentList() { i, departmentArr ->
//                                            if (i == 0) {
//                                                for (department in departmentArr) {
//                                                    DepartmentApiImpl.newInstance().getChildDepartments(department) { i, departmentArr ->
//                                                        if (i == 0) {
//                                                            var departmentsInfo = departmentArr.map {
//                                                                var department = Department(it).getInfo()
//                                                                "rId: ${department.remoteId}  名称: ${department.name}  openapiPartyid: ${department.openapiPartyid} \n"
//                                                            }
//                                                            MsgApiImpl.newInstance().sendTextualMessage(conv.getLocalId(), "log-获取二级部门信息: \n $departmentsInfo")
//                                                        } else {
//                                                            MsgApiImpl.newInstance().sendTextualMessage(conv.getLocalId(), "log-获取二级部门信息 失败 $i  ${Department(department).getRemoteId()}")
//                                                        }
//                                                    }
//                                                }
//                                            } else {
//                                                MsgApiImpl.newInstance().sendTextualMessage(conv.getLocalId(), "log-获取二级部门信息 失败 $i")
//                                            }
//                                        }
//                                    } else if (text.startsWith("获取指定部门")) {
//                                        var departmentId: Long = 1688852946270840
//                                        if (textSplits.size > 1) {
//                                            departmentId = textSplits.last().trim().toLong()
//                                        }
//                                        DepartmentApiImpl.newInstance().getDepartmentByIds(longArrayOf(departmentId)) { i, departmentArr ->
//                                            if (i == 0) {
//                                                var departmentsInfo = departmentArr.map {
//                                                    var department = Department(it).getInfo()
//                                                    "rId: ${department.remoteId}  名称: ${department.name}  openapiPartyid: ${department.openapiPartyid} \n"
//                                                }
//                                                MsgApiImpl.newInstance().sendTextualMessage(conv.getLocalId(), "log-获取指定部门: \n $departmentsInfo")
//                                            } else {
//                                                MsgApiImpl.newInstance().sendTextualMessage(conv.getLocalId(), "log-获取指定部门: 部门不存在")
//                                            }
//                                        }
//                                    } else if (text.startsWith("获取部门架构")) {
//                                        var departmentId = 1688852946270840
//                                        if (textSplits.size > 1) {
//                                            departmentId = textSplits.last().trim().toLong()
//                                        }
//                                        DepartmentApiImpl.newInstance().getDepartmentFramework(departmentId) { i, bArr ->
//                                            if (i == 0) {
//                                                if (bArr.isNotEmpty()) {
//                                                    val deptUserMap = MessageNano.parseFrom(bArr, IDeptuser.DepartUserMap)
//                                                    if (deptUserMap != null) {
//                                                        val deptUserMapInfo = Deptuser.DepartUserMap.parseFrom(deptUserMap).departUsers.map {
//                                                            "部门id: ${it.deptId}  用户Ids: ${it.userIds}  \n"
//                                                        }
//                                                        MsgApiImpl.newInstance().sendTextualMessage(conv.getLocalId(), "log-获取部门架构信息:\n $deptUserMapInfo")
//                                                    } else {
//                                                        MsgApiImpl.newInstance().sendTextualMessage(conv.getLocalId(), "log-获取部门架构信息 失败 $i")
//                                                    }
//                                                } else {
//                                                    MsgApiImpl.newInstance().sendTextualMessage(conv.getLocalId(), "log-获取部门架构信息 失败 你不是管理员")
//                                                }
//                                            } else {
//                                                MsgApiImpl.newInstance().sendTextualMessage(conv.getLocalId(), "log-获取部门架构信息 失败 $i")
//                                            }
//                                        }
//                                    } else if (text.startsWith("修改职务")) {
//                                        var jobName = "测试"
//                                        if (textSplits.size > 1) {
//                                            jobName = textSplits.last().toString()
//                                        }
//                                        DepartmentApiImpl.newInstance().modifyUserJob(jobName) { i ->
//                                            MsgApiImpl.newInstance().sendTextualMessage(conv.getLocalId(), "log-修改职务: ${if (i == 0) "成功" else "失败"}")
//                                        }
//                                    } else if (text.startsWith("修改对外职务")) {
//                                        var jobName = "测试"
//                                        if (textSplits.size > 1) {
//                                            jobName = textSplits.last().toString()
//                                        }
//                                        DepartmentApiImpl.newInstance().modifyUserExternJob(jobName) { i ->
//                                            MsgApiImpl.newInstance().sendTextualMessage(conv.getLocalId(), "log-修改对外职务: ${if (i == 0) "成功" else "失败"}")
//                                        }
//                                    } else if (text.startsWith("修改头像")) {
//                                        var avatarUrl = "http://b.hiphotos.baidu.com/image/pic/item/0eb30f2442a7d9337119f7dba74bd11372f001e0.jpg"
//                                        if (textSplits.size > 1) {
//                                            avatarUrl = textSplits.last().toString().trim()
//                                        }
//                                        HttpClients.download(avatarUrl, IHttpConfigs.Type.IMAGE, iDownloadCallback = { localPath, _ ->
//                                            if (localPath != null) {
//                                                DepartmentApiImpl.newInstance().modifyUserAvatar(localPath) { i, str ->
//                                                    MsgApiImpl.newInstance().sendTextualMessage(conv.getLocalId(), "log-修改头像: ${if (i == 0) "成功" else "失败"}  $str")
//                                                }
//                                            }
//                                        })
//                                    } else if (text.startsWith("获取绑定微信状态")) {
//                                        MsgApiImpl.newInstance().sendTextualMessage(conv.getLocalId(), "log-获取绑定微信状态: ${ContactApiImpl.newInstance().getBindWxStatus()}")
//                                    } else if (text.startsWith("删除联系人")) {
//                                        when (textSplits.size > 1) {
//                                            true -> {
//                                                val contactIds = textSplits[1].split(",").map { it.trim().toLong() }.toLongArray()
//                                                UserManagerApiImpl.newInstance().getUserByIdWithScene(contactIds) { i, users ->
//                                                    if (i == 0 && users.isNotEmpty()) {
//                                                        for (user in users) {
//                                                            ContactManagerApiImpl.newInstance().operateContact(ContactService.OPERATE_TYPE_DEL_CONTACT, user = user) { i, str ->
//                                                                MsgApiImpl.newInstance().sendTextualMessage(conv.getInfo().id, "log-删除联系人:  ${if (i == 0) "成功" else "失败"}")
//                                                            }
//                                                        }
//                                                    } else {
//                                                        MsgApiImpl.newInstance().sendTextualMessage(conv.getInfo().id, "log-删除联系人: 未查找到联系人")
//                                                    }
//                                                }
//                                            }
//                                            false -> {
//                                                MsgApiImpl.newInstance().sendTextualMessage(conv.getInfo().id, "log-删除联系人格式错误，请输入：\n删除联系人:[userid],[userid1]...")
//                                            }
//                                        }
//                                    } else if (text.startsWith("获取")) {
//                                        var contactType = 0
//                                        when (String(textMessage.content)) {
//                                            "获取我的微信联系人" -> contactType = ContactService.CONTACT_TYPE_RCT_WEIXIN_FRIENDS_V30
//                                            "获取我的手机联系人" -> contactType = ContactService.CONTACT_TYPE_RCT_MOBILE_FRIENDS_V30
//                                            "获取推荐的好友" -> contactType = ContactService.CONTACT_TYPE_RCT_RECOMMEND_FRIENDS_V30
//                                            "获取我的同事" -> contactType = ContactService.CONTACT_TYPE_RCT_WORKMATE
//                                            "获取我的客户" -> contactType = ContactService.CONTACT_TYPE_RCT_FRIEND_CUSTOMER
//                                            "获取待添加的客户" -> contactType = ContactService.CONTACT_TYPE_RCT_APPLY
//                                            "获取内部联系客户" -> contactType = ContactService.CONTACT_TYPE_INNER_SERVICE_CONTACTS
//                                            "获取联系群组"  -> contactType = ContactService.CONTACT_TYPE_RCT_CONTACTGROUP
//                                            "获取历史好友"  -> contactType = ContactService.CONTACT_TYPE_RCT_FRIEND_HISTORY
//                                            "获取加星联系人"  -> contactType = ContactService.CONTACT_TYPE_STAR_CONTACTS
//                                            "获取其他组织"  -> contactType = ContactService.CONTACT_TYPE_RCT_OTHER_CORP
//                                            "获取保存的群组"  -> contactType = ContactService.CONTACT_TYPE_GROUP_MEM
//                                            "获取我的好友" -> contactType = ContactService.CONTACT_TYPE_RCT_FRIEND
//                                        }
//                                        ContactApiImpl.newInstance().getMatchedContactList(contactType) { i, users ->
//                                            when (i == 0) {
//                                                true -> {
//                                                    if (users.isEmpty()) {
//                                                        MsgApiImpl.newInstance().sendTextualMessage(conv.getInfo().id, "信息： 当前暂无${String(textMessage.content).substring(2)}")
//                                                    } else {
//                                                        val userInfo = users.map {
//                                                            val user = User(it)
//                                                            return@map "remoteId: ${user.getInfo().remoteId}  name: ${user.getDisplayName()}  headUrl: ${user.getHeadUrl()}"
//                                                        }.reduce { acc, s -> "$acc \n $s" }
//                                                        MsgApiImpl.newInstance().sendTextualMessage(conv.getInfo().id, "信息： \n $userInfo")
//                                                    }
//                                                }
//                                                else ->
//                                                    MsgApiImpl.newInstance().sendTextualMessage(conv.getInfo().id, "log-获取${String(textMessage.content).substring(2)}: 失败")
//                                            }
//                                        }
//                                    } else if (text.startsWith("查看指令集")) {
//                                        MsgApiImpl.newInstance().sendTextualMessage(conv.getInfo().id, "log-指令集: 获取${String(textMessage.content).substring(2)}: 失败")
//                                    }
//                                }
//                                WwMessage.kAppContent -> {
//                                    val atMessage = WwRichmessage.AtMessage.parseFrom(message.data)
//                                    Log.e(Plugins::class.java.name, "onAddMessages @消息  ${String(atMessage.name)}  uin: ${atMessage.uin}")
//                                }
//                                else ->
//                                    Log.e(Plugins::class.java.name, "onAddMessages 未解析的消息  ${message.contentType}  消息内容: ${String(message.data)}")
//                            }
//                        }
//                    }
//                    WwRichmessage.LinkMessage::class.java -> {
//                        val msg = msg as WwRichmessage.LinkMessage
//                        val downloadInfo = msg.getDownloadInfo()
//                        Log.e(Plugins.javaClass.name, "链接消息类型: $contentType   $downloadInfo")
//                        Handler(Looper.getMainLooper()).postDelayed({
//                            if (msg.original != null) {
//                                val path = WeworkServiceImpl.getMessageFileDownloadPath(MessageNano.toByteArray(msg.original!!), contentType)
//                                Log.e(Plugins.javaClass.name, "链接消息类型:  $contentType   地址：$path")
//                            }
//                        }, 1)
//                        if (downloadInfo != null) {
//                            FileDownloadApiImpl.newInstance().downloadFile(downloadInfo) { i, str ->
//                                Log.e(Plugins.javaClass.name, "下载文件：${if (i == 0) "成功" else "失败"}")
//                            }
//                        }
//                    }
//                    WwRichmessage.LocationMessage::class.java -> {
//                        val msg = msg as WwRichmessage.LocationMessage
//                        Log.e(Plugins.javaClass.name, "定位消息: address: ${String(msg.address)}  latitude: ${msg.latitude}  longitude: ${msg.longitude}   staticMapUrl: ${String(msg.staticMapUrl)}   title: ${String(msg.title)}  zoom: ${msg.zoom}")
//                    }
//                    WwRichmessage.VideoMessage::class.java -> {
//                        val msg = msg as WwRichmessage.VideoMessage
//                        val downloadInfo = msg.getDownloadInfo(contentType)
//                        Log.e(Plugins.javaClass.name, "视频消息类型: $contentType   $downloadInfo")
//                        Handler(Looper.getMainLooper()).postDelayed({
//                            if (msg.original != null) {
//                                val path = WeworkServiceImpl.getMessageFileDownloadPath(MessageNano.toByteArray(msg.original!!), contentType)
//                                Log.e(Plugins.javaClass.name, "视频消息类型:  $contentType   地址：$path")
//                            }
//                        }, 1)
//                        if (downloadInfo != null) {
//                            FileDownloadApiImpl.newInstance().downloadFile(downloadInfo) { i, str ->
//                                Log.e(Plugins.javaClass.name, "下载文件：${if (i == 0) "成功" else "失败"}")
//                            }
//                        }
//                    }
//                    WwRichmessage.WeAppMessage::class.java -> {
//                        val msg = msg as WwRichmessage.WeAppMessage
//                        val downloadInfo = msg.getDownloadInfo()
//                        Log.e(Plugins.javaClass.name, "小程序消息类型: $contentType   $downloadInfo")
//                        Handler(Looper.getMainLooper()).postDelayed({
//                            if (msg.original != null) {
//                                val path = WeworkServiceImpl.getMessageFileDownloadPath(MessageNano.toByteArray(msg.original!!), contentType)
//                                Log.e(Plugins.javaClass.name, "小程序消息类型:  $contentType   地址：$path")
//                            }
//                        }, 1)
//                        if (downloadInfo != null) {
//                            FileDownloadApiImpl.newInstance().downloadFile(downloadInfo) { i, str ->
//                                Log.e(Plugins.javaClass.name, "下载文件：${if (i == 0) "成功" else "失败"}")
//                            }
//                        }
//                    }
//                    else ->
//                        Log.e(Plugins::class.java.name, "onAddMessages  else  ${msg.javaClass}  消息结构: ${Gson().toJson(msg)}")
//                }
//            }
//        }

    }

    override fun onChangeOwner(conversation: Any) {
        Log.e(Plugins.javaClass.name, "onChangeOwner  ${Conversation.getInfo(conversation)}")
//        val conv = Conversation(conversation)
//        Log.e(Plugins::class.java.name, "onChangeOwner   remoteId: ${conv.getInfo().remoteId}  -  name: ${conv.getInfo().name}  -  type: ${conv.getInfo().type}")
    }

    override fun onDraftDidChange(conversation: Any) {
        Log.e(Plugins.javaClass.name, "onDraftDidChange  ${Conversation.getInfo(conversation)}")
//        val conv = Conversation(conversation)
//        Log.e(Plugins::class.java.name, "onDraftDidChange   remoteId: ${conv.getInfo().remoteId}  -  name: ${conv.getInfo().name}  -  type: ${conv.getInfo().type}")
    }

    override fun onMessageStateChange(conversation: Any, message: Any, i: Int) {
        Log.e(Plugins.javaClass.name, "onMessageStateChange  ${Conversation.getInfo(conversation)}")
//        val conv = Conversation(conversation)
//        Log.e(Plugins::class.java.name, "onMessageStateChange: ${conv.getInfo().remoteId}  -  ${conv.getInfo().name}  -  ${conv.getInfo().type}")
//        val msg = Message(message)
//        Log.e(Plugins::class.java.name, "onMessageStateChange： ${msg.getInfo().contentType}  -   ${String(msg.getInfo().content)}   状态： ${i}")
    }

    override fun onMessageUpdate(conversation: Any, message: Any) {
        Log.e(Plugins.javaClass.name, "onMessageUpdate  ${Conversation.getInfo(conversation)}")
//        val conv = Conversation(conversation)
//        Log.e(Plugins::class.java.name, "onMessageUpdate   remoteId: ${conv.getInfo().remoteId}  -  name: ${conv.getInfo().name}  -  type: ${conv.getInfo().type}")
//        val msg = Message(message)
//        Log.e(Plugins::class.java.name, "onMessageUpdate  类型： ${msg.getInfo().contentType}  -  内容：  ${String(msg.getInfo().content)}")
    }

    override fun onModifyName(conversation: Any) {
        Log.e(Plugins.javaClass.name, "onModifyName  ${Conversation.getInfo(conversation)}")
//        val conv = Conversation(conversation)
//        Log.e(Plugins::class.java.name, "onMessageUpdate   remoteId: ${conv.getInfo().remoteId}  -  name: ${conv.getInfo().name}  -  type: ${conv.getInfo().type}")
    }

    override fun onPropertyChanged(conversation: Any) {
        Log.e(Plugins.javaClass.name, "onPropertyChanged  ${Conversation.getInfo(conversation)}")
//        val conv = Conversation(conversation)
//        Log.e(Plugins::class.java.name, "onPropertyChanged   remoteId: ${conv.getInfo().remoteId}  -  name: ${conv.getInfo().name}  -  type: ${conv.getInfo().type}")
    }

    override fun onRemoveAllMessages(conversation: Any) {
        Log.e(Plugins.javaClass.name, "onRemoveAllMessages  ${Conversation.getInfo(conversation)}")
//        val conv = Conversation(conversation)
//        Log.e(Plugins::class.java.name, "onRemoveAllMessages   remoteId: ${conv.getInfo().remoteId}  -  name: ${conv.getInfo().name}  -  type: ${conv.getInfo().type}")
    }

    override fun onRemoveMembers(conversation: Any) {
        Log.e(Plugins.javaClass.name, "onRemoveMembers  ${Conversation.getInfo(conversation)}")
//        val conv = Conversation(conversation)
//        Log.e(Plugins::class.java.name, "onRemoveMembers   remoteId: ${conv.getInfo().remoteId}  -  name: ${conv.getInfo().name}  -  type: ${conv.getInfo().type}")
//        for (member in conv.getMembers()) {
//            Log.e(Plugins::class.java.name, "onRemoveMembers  remoteId: ${member.operatorRemoteId}  name: ${member.name}   nickname: ${member.nickName}")
//        }
    }

    override fun onRemoveMessages(conversation: Any, message: Any) {
        Log.e(Plugins.javaClass.name, "onRemoveMessages  ${Conversation.getInfo(conversation)}")
//        val conv = Conversation(conversation)
//        Log.e(Plugins::class.java.name, "onRemoveMessages: ${conv.getInfo().remoteId}  -  ${conv.getInfo().name}  -  ${conv.getInfo().type}")
//        val msg = Message(message)
//        Log.e(Plugins::class.java.name, "onRemoveMessages： ${msg.getInfo().contentType}  -   ${String(msg.getInfo().content)}")
    }

    override fun onSetAllBan(conversation: Any) {
        Log.e(Plugins.javaClass.name, "onSetAllBan  ${Conversation.getInfo(conversation)}")
//        val conv = Conversation(conversation)
//        Log.e(Plugins::class.java.name, "onSetAllBan: ${conv.getInfo().remoteId}  -  ${conv.getInfo().name}  -  ${conv.getInfo().type}")
    }

    override fun onSetCollect(conversation: Any) {
        Log.e(Plugins.javaClass.name, "onSetCollect  ${Conversation.getInfo(conversation)}")
//        val conv = Conversation(conversation)
//        Log.e(Plugins::class.java.name, "onSetCollect: ${conv.getInfo().remoteId}  -  ${conv.getInfo().name}  -  ${conv.getInfo().type}")
    }

    override fun onSetConfirmAddMember(conversation: Any) {
        Log.e(Plugins.javaClass.name, "onSetConfirmAddMember  ${Conversation.getInfo(conversation)}")
//        val conv = Conversation(conversation)
//        Log.e(Plugins::class.java.name, "onSetConfirmAddMember: ${conv.getInfo().remoteId}  -  ${conv.getInfo().name}  -  ${conv.getInfo().type}")
    }

    override fun onSetMembersBan(conversation: Any) {
        Log.e(Plugins.javaClass.name, "onSetMembersBan  ${Conversation.getInfo(conversation)}")
//        val conv = Conversation(conversation)
//        Log.e(Plugins::class.java.name, "onSetMembersBan: ${conv.getInfo().remoteId}  -  ${conv.getInfo().name}  -  ${conv.getInfo().type}")
    }

    override fun onSetOwnerManager(conversation: Any) {
        Log.e(Plugins.javaClass.name, "onSetOwnerManager  ${Conversation.getInfo(conversation)}")
//        val conv = Conversation(conversation)
//        Log.e(Plugins::class.java.name, "onSetOwnerManager: ${conv.getInfo().remoteId}  -  ${conv.getInfo().name}  -  ${conv.getInfo().type}")
    }

    override fun onSetShield(conversation: Any) {
        Log.e(Plugins.javaClass.name, "onSetShield  ${Conversation.getInfo(conversation)}")
//        val conv = Conversation(conversation)
//        Log.e(Plugins::class.java.name, "onSetShield: ${conv.getInfo().remoteId}  -  ${conv.getInfo().name}  -  ${conv.getInfo().type}")
    }

    override fun onSetTop(conversation: Any) {
        Log.e(Plugins.javaClass.name, "onSetTop  ${Conversation.getInfo(conversation)}")
//        val conv = Conversation(conversation)
//        Log.e(Plugins::class.java.name, "onSetTop: ${conv.getInfo().remoteId}  -  ${conv.getInfo().name}  -  ${conv.getInfo().type}")
    }

    override fun onTypingStateUpdate(conversation: Any) {
        Log.e(Plugins.javaClass.name, "onTypingStateUpdate  ${Conversation.getInfo(conversation)}")
//        val conv = Conversation(conversation)
//        Log.e(Plugins::class.java.name, "onTypingStateUpdate: ${conv.getInfo().remoteId}  -  ${conv.getInfo().name}  -  ${conv.getInfo().type}")
    }

    override fun onUnReadCountChanged(conversation: Any, i: Int, i2: Int) {
        Log.e(Plugins.javaClass.name, "onUnReadCountChanged  ${Conversation.getInfo(conversation)}   $i   $i2")
//        val conv = Conversation(conversation)
//        Log.e(Plugins::class.java.name, "onUnReadCountChanged: ${conv.getInfo().remoteId}  -  ${conv.getInfo().name}  -  ${conv.getInfo().type}")
    }


    /*  ------------------  INotificationHooker  ----------------- */

    override fun onObserve(i: Int, notificationInfo: Any) {
        Log.e(Plugins.javaClass.name, "收到通知回调 onObserve:  ${NotificationInfo.parse(notificationInfo)}")
//        val info = NotificationInfo.parse(notificationInfo)
//        Log.e(Plugins::class.java.name, "onObserve: i: $i   notificationInfo: ${info.mDetail2int}  ${info.mDetail3}  ${info.mDetail4} detail: ${info.mDetail}  detail2: ${info.mDetail2}  raw: ${String(info.mRawData)}")
//        if (i == 2 && info.mDetail != null) { // 消息
//            val message = Message(info.mDetail!!)
//            if (message.contentType == WwMessage.kFriendApply) { // 好友申请
//                Log.e(Plugins.javaClass.name, "onObserve  好友申请   ${info.mDetail}    ${Thread.currentThread()}")
//                Handler(Looper.getMainLooper()).postDelayed({
//                    ContactApiImpl.newInstance().getMatchedContactList(ContactService.CONTACT_TYPE_RCT_APPLY) { i, users ->
//                        if (i == 0 && users.isNotEmpty()) {
//                            val filterUsers = users.distinctBy { User(it).getRemoteId() }
//                                .filter { !ContactApiImpl.newInstance().isContactAdded(User(it).getRemoteId()) }
//                            for (user in filterUsers) {
//                                ContactManagerApiImpl.newInstance().operateContact(ContactService.OPERATE_TYPE_AGREE, user = user) { i, str ->
//                                    Log.e(Plugins.javaClass.name, "自动通过好友添加 $i")
//                                }
//                            }
//                        }
//                    }
//                }, 1000)
//            } else if (message.contentType == WwMessage.kFriendChanged || message.contentType == WwMessage.kWxFriendChanged) { // 好友变化
//                Log.e(Plugins::class.java.name, "onObserve: 好友变化: $i   notificationInfo: ${info.mDetail}")
//            }
//        }
    }

    /*  ------------------  IContactHooker  ----------------- */
//
//    override fun onApplyUnReadCountChanged(i: Int) {
//        Log.e(Plugins::class.java.name, "onApplyUnReadCountChanged: i: $i")
//    }
//
//    override fun onContactListUnradCountChanged(i: Int, i2: Int, i3: Int) {
//        Log.e(Plugins::class.java.name, "onContactListUnradCountChanged: i: $i  i2: $i2  i3: $i3")
//    }
//
//    override fun onSyncContactFinish(i: Int, z: Boolean) {
//        Log.e(Plugins::class.java.name, "onSyncContactFinish: i: $i  z: $z")
//    }
}