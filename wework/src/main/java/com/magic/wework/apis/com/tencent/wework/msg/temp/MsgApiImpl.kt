package com.magic.wework.apis.com.tencent.wework.msg.temp

class MsgApiImpl {

    companion object {
        private var instance: MsgApiImpl? = null

        @Synchronized
        fun newInstance(): MsgApiImpl {
            if (instance == null) {
                instance = MsgApiImpl()
            }
            return instance!!
        }

        /** -------------- 来自MsgApiImpl的方法 ---------- */

        /** 获取实例 */
//        private fun getMsgApi(): Any = MK.service(IMsg)

        /**
         * 构建链接消息
         * imageUrl 与 imageData 二选一
         */
//        private fun buildLinkMessage(
//            linkUrl: String, title: String, description: String = "",
//            imageUrl: String?, imageData: ByteArray?
//        ): Any =
//            XposedHelpers.callMethod(
//                getMsgApi(), Methods.MsgApiImpl.buildLinkMessage.name,
//                arrayOf(Clazz.String, Clazz.String, Clazz.String, Clazz.String, Clazz.ByteArray),
//                linkUrl, title, description, imageUrl, imageData
//            )

        /**
         * 构建发送的消息
         * @param type
         *
         */
//        private fun buildMessage(type: Int, messageNano: Any): Any =
//            XposedHelpers.callMethod(
//                getMsgApi(), Methods.MsgApiImpl.buildMessage.name,
//                arrayOf(Clazz.Int, MessageNano),
//                type, messageNano
//            )

        /**
         * 构建文本消息
         */
//        private fun buildTextualMessage(charSequence: CharSequence): Any =
//            XposedHelpers.callMethod(
//                getMsgApi(), Methods.MsgApiImpl.buildTextualMessage.name,
//                arrayOf(Clazz.CharSequence), charSequence
//            )

        /**
         * 发送消息
         * @param context Context
         */
//        private fun sendMessage(
//            context: Context? = null, conversation: Any, message: Any,
//            sendExtraInfo: Any? = null, iSendMessageCallback: Any? = null
//        ) =
//            XposedHelpers.callMethod(
//                getMsgApi(), Methods.MsgApiImpl.sendMessage.name,
//            )

        /**
         * 发送消息
         * @param context Context
         */
//        private fun sendMessage(
//            context: Context? = null, conversation: Any, messageNano: Any, type: Int,
//            sendExtraInfo: Any? = null, iSendMessageCallback: Any? = null
//        ) =
//            XposedHelpers.callMethod(
//                getMsgApi(), Methods.MsgApiImpl.sendMessageNano.name,
//            )

        /**
         * 发送文本消息，带回调
         * @param context
         * @param id conversationId 或者userId
         */
//        private fun sendTextualMessage(
//            iSendMessageCallback: Any?
//        ): Boolean =
//            XposedHelpers.callMethod(
//                getMsgApi(),  Methods.MsgApiImpl.sendTextualMessage.name,
//                arrayOf(
//                    Clazz.Context, Clazz.Long,
//                ),
//                context, id, richMessage, sendExtraInfo, iSendMessageCallback
//            ) as? Boolean ?: false


        /** -------------- 来自MessageManager fff 的方法 ------------ */

        /**
         * 构建文件消息
         * @param filePath 本地路径
         * @param width 如果是图片宽
         * @param height 图片高
         * @param voiceTime 语音时长
         * @param isHd 是否是hd
         *
         * @return com.tencent.wework.foundation.model.pb.WwRichemessage$FileMessage
         */
//        private fun buildFileMessage(filePath: String, width: Int = 0, height: Int = 0, voiceTime: Int = 0, isHd: Boolean = false): Any =
//            XposedHelpers.callStaticMethod(
//                com.magic.wework.mirror.Classes.MessageManager,
//            )

        /**
         * 构建视频消息
         * @param filePath 视频本地路径
         * @param previewImgUrl 视频预览图片
         *
         */
//        private fun buildLocationMessage(
//            latitude: Double = 0.0, longitude: Double = 0.0,
//            title: String?, address: String?, zoom: Double, staticMapUrl: String? = null
//        ) =
//            XposedHelpers.callStaticMethod(
//                com.magic.wework.mirror.Classes.MessageManager,
//            )

        /**
         * 构建视频消息
         * @param filePath 视频本地路径
         * @param previewImgUrl 视频预览图片
         *
         */
//        private fun buildVideoMessage(filePath: String, previewImgUrl: String = "") =
//            XposedHelpers.callStaticMethod(
//                filePath, previewImgUrl
//            )

//        fun getManager(): Any =
//            XposedHelpers.callStaticMethod(
//                com.magic.wework.mirror.Classes.MessageManager,
//                com.magic.wework.mirror.Methods.MessageManager.getManager.name
//            )

        /**
         * 标记消息已读
         * @param localId
         */
//        private fun markRead(localId: Long) =
//            XposedHelpers.callMethod(
//                getManager(),
//            )

        /**
         * 发送文本信息
         * @param context Context
         * @param localId Long 会话的id
         * @param charSequence CharSequence
         * @param z Boolean
         */
//        private fun sendTextualMessage(
//            context: Context? = null, localId: Long,
//        ): Boolean =
//            XposedHelpers.callStaticMethod(
//                context, localId, charSequence, z
//            ) as? Boolean ?: false

        /**
         * 发送本地文件消息
         * @param context Context
         * @param localId Long 会话的id
         * @param filePath String 文件路径
         * @param z Boolean 发送成功后是否删除源文件
         * @param sendExtraInfo com.tencent.wework.msg.api.SendExtraInfo
//         */
//        private fun sendFileMessage(
//            z: Boolean = false, sendExtraInfo: Any = com.magic.wework.apis.com.tencent.wework.msg.api.SendExtraInfo.default
//        ): Boolean =
//            XposedHelpers.callMethod(
//                getManager(),
//            ) as? Boolean ?: false

        /**
         * 发送语音信息
         * @param activity Activity
         * @param conversationId Long 会话的id
         * @param filePath String
         * @param voiceTime Int
         */
//        private fun sendVoiceMessage(
//            activity: Activity? = null, localId: Long,
//        ): Boolean =
//            XposedHelpers.callMethod(
//                getManager(),
//            ) as? Boolean ?: false

        /**
         * 发送本地图片消息
         * @param context Context
         * @param conversationId Long 会话的id
         * @param filePath String 文件路径
         * @param i Int
         * @param z Boolean 发送成功后是否删除文件
         * @param iSendMessageCallback com.tencent.wework.foundation.callback.ISendMessageCallback
         */
//        private fun sendImageMessage(
//            context: Context? = null, localId: Long,
//        ): Boolean =
//            XposedHelpers.callMethod(
//                getManager(),
//            ) as? Boolean ?: false

        /**
         * 发送视频消息
         * @param activity
         * @param localId Long
         * @param videoPath 视频本地地址
         * @param previewImgUrl 预览图片
         */
//        private fun sendVideoMessage(
//            activity: Activity? = null, localId: Long,
//            videoPath: String, previewImgUrl: String = ""
//        ): Boolean =
//            XposedHelpers.callMethod(
//                activity, localId, videoPath, previewImgUrl
//            ) as? Boolean ?: false



        /**
         * 发送地理位置消息
         */
//        private fun sendLocationMessage(
//            context: Context? = null, localId: Long, latitude: Double = 0.0, longitude: Double = 0.0,
//            title: String?, address: String?, zoom: Double, staticMapUrl: String? = null
//        ): Boolean =
//            XposedHelpers.callStaticMethod(
//                com.magic.wework.mirror.Classes.MessageManager,
//                context, localId, latitude, longitude, title, address, zoom, staticMapUrl
//            ) as? Boolean ?: false

        /**
         * 重发消息
         */
//        private fun resendMessage(activity: Activity? = null, localId: Long, messageId: Long, i: Int): Boolean =
//            XposedHelpers.callMethod(
//                getManager(),
//                activity, localId, messageId, i
//            ) as? Boolean ?: false

        /**
         * 获取文件的存储路径
         * @param fileMessage com.tencent.wework.foundation.pb.WwRichmessage$FileMessage
         * @param contentType: Int
         * @param z: Boolean
         * @return 本地存储路径
         */
//        fun getFileLocalPath(fileMessage: Any?, contentType: Int, z: Boolean): String =
//            XposedHelpers.callStaticMethod(
//                com.magic.wework.mirror.Classes.MessageManager,
//                fileMessage, contentType, z
//            ) as String

        /**
         * 获取视频的存储路径
         * @param contentType: Int
         * @return String[0]=视频存储路径 String[1]=预览图片存储路径
         */
//        fun getVideoLocalPaths(videoMessage: Any?, contentType: Int): Array<String>? =
//            XposedHelpers.callStaticMethod(
//                arrayOf(com.magic.wework.mirror.com.tencent.wework.foundation.model.pb.Classes.IWwRichmessage.VideoMessage, Clazz.Int),
//                videoMessage, contentType
//            ) as? Array<String>

    }

//    fun sendMessage(id: Long, messageNano: Any, type: Int, iSendMessageCallback: ICallbacks.ISendMessageCallback? = null) {
//        if (!checkWith()) return
//        val conversation = ConversationApiImpl.newInstance().getConversation(id)
//        when (conversation != null) {
//            true -> Companion.sendMessage(null, conversation, messageNano, type, iSendMessageCallback = getProxySendMessageCallback(iSendMessageCallback))
//            else -> {
//                }
//            }
//        }
//    }
//
//    fun sendTextualMessage(id: Long, charSequence: CharSequence, iSendMessageCallback: ICallbacks.ISendMessageCallback? = null) {
//        if (!checkWith()) return
//        val conversation = ConversationApiImpl.newInstance().getConversation(id)
//        when (conversation != null) {
//                        Companion.sendTextualMessage(id = Conversation(conversation).getLocalId(), richMessage = richMessage, iSendMessageCallback = getProxySendMessageCallback(iSendMessageCallback))
//                    } else {
//                        iSendMessageCallback?.onResult(-1, null, null)
//                    }
//                }
//            }
//        }
//    }
//
//    fun sendVideoMessage(id: Long, videoPath: String, previewImgUrl: String = "", iSendMessageCallback: ICallbacks.ISendMessageCallback? = null) {
//    }
//
//    fun sendVoiceMessage(id: Long, filePath: String, voiceTime: Int, iSendMessageCallback: ICallbacks.ISendMessageCallback? = null) {
//    }
//
//    fun sendWeAppMessage(
//        id: Long, appid: String, username: String,
//        title: String, desc: String = "", pagepath: String,
//        version: Int, type: Int, weappIconUrl: String, thumbUrl: String = "",
//        iSendMessageCallback: ICallbacks.ISendMessageCallback? = null
//    ) {
//        if (!checkWith()) return
//            title = title, desc = desc, pagepath = pagepath,
//            version = version, type = type, weappIconUrl = weappIconUrl, thumbUrl = thumbUrl
//        ).mirror
//    }
//
//    fun sendRemoteFileMessage(id: Long, urlString: String, fileType: IHttpConfigs.Type, iSendRemoteFileMessageCallback: ICustomSendRemoteFileMessageCallback? = null) {
//        val inId = id
//        val inISendRemoteFileMessageCallback = iSendRemoteFileMessageCallback
//        HttpClients.download(urlString = urlString, type = fileType, iDownloadCallback = { localPath, type ->
//            if (localPath == null) {
//                }
//            }
//            when (type) {
//                IHttpConfigs.Type.DEFAULT,
//                IHttpConfigs.Type.FILE -> sendFileMessage(inId, localPath, iSendMessageCallback = iSendMessageCallback)
//                IHttpConfigs.Type.IMAGE -> sendImageMessage(inId, localPath, iSendMessageCallback = iSendMessageCallback)
//                IHttpConfigs.Type.VOICE -> {
//                    val retriever = MediaMetadataRetriever()
//                    retriever.setDataSource(localPath!!)
//                    val duration = ceil(retriever.extractMetadata(MediaMetadataRetriever.METADATA_KEY_DURATION).toFloat() / 1000).toInt()
//                    retriever.release()
//                    Log.e(MsgApiImpl.javaClass.name, "语音消息时长: $duration   $localPath")
//                        false -> iSendRemoteFileMessageCallback?.invoke(false, "voice too long")
//                    }
//                }
//                IHttpConfigs.Type.VIDEO -> sendVideoMessage(inId, localPath, iSendMessageCallback = iSendMessageCallback)
//            }
//        })
//    }
//
}