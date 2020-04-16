package com.magic.wework.apis.com.tencent.wework.foundation.model

data class WechatDownloadItem(
    var isCompleted: Boolean,
    var isFromSendMsg: Boolean,
    var isManualStopped: Boolean,
    var isRunning: Boolean,
    var lec: Int,
    var progress: Long,
    var total: Long,
    var url: String
)

