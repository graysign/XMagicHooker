package com.magic.wework.apis.com.tencent.wework.foundation.model.pb

import com.google.gson.Gson
import java.io.Serializable

/**
 * com.tencent.wework.foundation.model.pb.WwMessage
 */
interface WwMessage {

    companion object {
        const val kAck: Int = 2
        const val kAddRoomMember: Int = 1002  // 系统消息
        const val kAdmin: Int = 501
        const val kAdmin2: Int = 50
        const val kAdminCorpAppChange: Int = 2149
        const val kAdminDelUser: Int = 2112
        const val kAdminForbidUser: Int = 2111
        const val kAnonymous: Int = 2048
        const val kApiChangeNotify: Int = 2126
        const val kAppCardMsg: Int = 25
        const val kAppCmdBegin: Int = 2100
        const val kAppCmdEnd: Int = 2199
        const val kAppCommentNotify: Int = 2139
        const val kAppContent: Int = 10
        const val kAppContentSync: Int = 2103
        const val kAppControl: Int = 1009
        const val kAppNews: Int = 35
        const val kAppRichMsg: Int = 37
        const val kAppShareLoginMsg: Int = 66
        const val kAppTaskCard: Int = 46
        const val kAppTaskCardV2: Int = 91
        const val kAppTextCard: Int = 38
        const val kApplyNotify: Int = 18
        const val kAttendance: Int = 200
        const val kAttendanceOutStaticsSummary: Int = 55
        const val kAttendanceWorkStaticsSummary: Int = 71
        const val kAuthGuideCard: Int = 2058
        const val kAuthGuideNotity: Int = 2056
        const val kAuthGuideText: Int = 2057
        const val kAutoCheckinResult: Int = 201
        const val kBBSNotice: Int = 2137
        const val kBombBox: Int = 2128
        const val kBoundary: Int = 9999
        const val kBussinessCardDelAll: Int = 2141
        const val kCardApp: Int = 33
        const val kCardBoth: Int = 31
        const val kCardPc: Int = 32
        const val kChangeRoomName: Int = 1001
        const val kCheckinNotice: Int = 43
        const val kCheckinReminderChange: Int = 2140
        const val kCircleAppChange: Int = 2172
        const val kClearAllTodoRecord: Int = 2158
        const val kClearMailMessage: Int = 2054
        const val kClearOldMessage: Int = 2055
        const val kClockArriveInvalid: Int = 1024
        const val kClockReached : Int= 1010
        const val kCloudDisk: Int = 42
        const val kCloudDiskFeedsMsg: Int = 67
        const val kCmdBegin: Int = 2000
        const val kCmdEnd: Int = 2999
        const val kCollectAck: Int = 1040
        const val kCollectCardMsg: Int = 86
        const val kCommApplyNotify: Int = 56
        const val kCommonRoomDismiss: Int = 1023
        const val kConfirmAddMember: Int = 1029
        const val kContactDismissCard: Int = 107
        const val kContactDismissNotify: Int = 110
        const val kContactGroupDataChange: Int = 2163
        const val kContactGroupInfoChange: Int = 2162
        const val kContentClearAllUnreadCount: Int = 2159
        const val kContentContactDismiss : Int= 2169
        const val kContentContactDismissSuggestSwitch: Int = 1032
        const val kContentContactInherit: Int = 2170
        const val kContentContactNewUser: Int = 103
        const val kContentContactOldUser: Int = 1030
        const val kContentFile: Int = 8
        const val kContentFileCDN: Int = 15
        const val kContentFileP2P: Int = 34
        const val kContentFileWWFTN: Int = 20
        const val kContentFileWWFTNEncrypt: Int = 49
        const val kContentIdSystemTips : Int= 1037
        const val kContentImage: Int = 7
        const val kContentImageCDN: Int = 14
        const val kContentImageP2P: Int = 63
        const val kContentImageWWFTN: Int = 19
        const val kContentImageWWFTNEncrypt: Int = 48
        const val kContentRemind: Int = 11
        const val kContentRobotCard : Int= 88
        const val kContentVideoWWFTN: Int = 22
        const val kContentVideoWWFTNEncrypt: Int = 51
        const val kContentVoiceWWFTN: Int = 21
        const val kContentVoiceWWFTNEncrypt: Int = 50
        const val kControlBegin: Int = 1000
        const val kControlEnd: Int = 1999
        const val kConversationIllegal: Int = 2066
        const val kCorpInfoNotify: Int = 2105
        const val kCorpNameModified: Int = 2136
        const val kCorpPay: Int = 61
        const val kCorpPayAck: Int = 1024
        const val kCorpPayAcrossAPP: Int = 65
        const val kCreateRoom: Int = 1006
        const val kCropCircleListControlNotify: Int = 2151
        const val kCropCircleOrganizationChanged: Int = 2157
        const val kCustomerChanged: Int = 2153
        const val kCustomerGroupSend: Int = 112
        const val kCustomerIdentifierChanged: Int = 2154
        const val kCustomerRapidReplyChange: Int = 2178
        const val kCustomerRelationChange: Int = 2179
        const val kCustomerRuleGroupChanged: Int = 2189
        const val kCustomerService: Int = 1012
        const val kCustomerSettingNotify: Int = 111
        const val kCustomerSettingNotify2: Int = 113
        const val kCustomerShareListChanged: Int = 2181
        const val kCustomerStatChange: Int = 2177
        const val kCustomerVipServiceMsg: Int = 89
        const val kCustomerVipWelcomeMsg: Int = 90
        const val kCustomerWelcomeChange: Int = 115
        const val kDel: Int = 1
        const val kDelClock: Int = 256
        const val kDelConv: Int = 2002
        const val kDelMemberFromDel: Int = 1021
        const val kDelMemberFromOut: Int = 1020
        const val kDeleteAppData: Int = 2121
        const val kDeleteRoomMember: Int = 1003
        const val kDismissCorp = 2109
        const val kDocumentDraftChange: Int = 2004
        const val kDocumentMsgUpdate: Int = 1038
        const val kEmotion: Int = 29
        const val kEncrypt: Int = 8192
        const val kEncryptSdkNotify: Int = 2138
        const val kExitRoom: Int = 1005     // 系统消息
        const val kExternRoomTips: Int = 1025
        const val kExternalForward: Int = 36
        const val kFellowBBS: Int = 2117
        const val kFile: Int = 3
        const val kFileAssistLogin: Int = 2101
        const val kFileAssistLogout: Int = 2102
        const val kFinanialChatInfoChange: Int = 2176
        const val kFinanialTips: Int = 1042
        const val kForward: Int = 4
        const val kFriendApply: Int = 2132
        const val kFriendChanged: Int = 2131
        const val kFriendContactNew: Int = 508
        const val kFriendRecommend: Int = 2129
        const val kFromKF: Int = 2097152
        const val kGeneralTextMessage: Int = 509
        const val kGlobalItemNotify : Int= 2104
        const val kHadAck: Int = 16
        const val kHasAtMe: Int = 8
        const val kHasRead: Int = 4
        const val kHidden: Int = 262144
        const val kHolidayClickCountChange: Int = 2145
        const val kHongBaoAck: Int = 1013
        const val kHongBaoControl: Int = 2052
        const val kHongBaoMsg: Int = 26
        const val kHongBaoSysMsg: Int = 27
        const val kHongbaoRankListMsg: Int = 60
        const val kImage: Int = 1
        const val kInviteControl: Int = 1016
        const val kInviteTipControl: Int = 1017
        const val kInvoice: Int = 57
        const val kInvoiceChangeNotity: Int = 2144
        const val kItilHBDepartColCardMsg: Int = 83
        const val kItilHongBaoAdminMsg: Int = 59
        const val kItilHongbaoMsg: Int = 58
        const val kJobSummary: Int = 105
        const val kJobSummaryLeaderMsg: Int = 82
        const val kJobSummaryPraise: Int = 106
        const val kJobSummarySuperAdminMsg: Int = 81
        const val kJobSummary_comic: Int = 114
        const val kJournalContentNotify: Int = 2143
        const val kKefuAIBeing: Int = 2061
        const val kKefuBeing: Int = 2060
        const val kKickMember: Int = 1004  // 系统消息
        const val kLink: Int = 13
        const val kLishi: Int = 45
        const val kLiveControl: Int = 2051
        const val kLiveStart: Int = 24
        const val kLocation: Int = 6
        const val kLogReport: Int = 2108
        const val kMailPwdChange: Int = 2124
        const val kMarkDownMsg: Int = 80
        const val kMarket: Int = 72
        const val kMchHongBaoMsg: Int = 76
        const val kMeetingAck: Int = 1041
        const val kMeetingInviteMsg: Int = 87
        const val kMisSendFileDeleteNotify: Int = 2062
        const val kMixedMsg: Int = 77
        const val kMobileLoginToPc: Int = 2125
        const val kModifyEmail: Int = 28
        const val kMsgState_DecryptFailed: Int = 5
        const val kMsgState_Decrypting: Int = 4
        const val kMsgState_SendFailed: Int = 3
        const val kMsgState_SendOk: Int = 2
        const val kMsgState_Sending: Int = 1
        const val kMsgState_Unknown: Int = 0
        const val kMsgState_VideoCompress: Int = 6
        const val kMutaInfoNotify: Int = 2115
        const val kNativeJumpText: Int = 75
        const val kNormalEnd : Int= 999
        const val kOfflineMsg: Int = 2003
        const val kOrgChange: Int = 2113
        const val kOtherCorpMsgChange: Int = 2059
        const val kOurDepartmentReadMode: Int = 8388608
        const val kOutMail: Int = 2123
        const val kPVMergeMultiMsg: Int = 1018
        const val kPVMergeMultiMsgOld: Int = 1015
        const val kPVMergeNotify: Int = 2120
        const val kPVMergeSingleMsg: Int = 40
        const val kPVMergeSingleMsgOld: Int = 30
        const val kPVMerge_Push: Int = 503
        const val kPersonalCard: Int = 41
        const val kPrivateClock: Int = 64
        const val kProfilesChanged: Int = 2122
        const val kPromotionControlInfo: Int = 2146
        const val kPstnContent: Int = 12
        const val kPstnMulti: Int = 2106
        const val kPublicClock: Int = 128
        const val kQuoteMessage: Int = 512
        const val kRTXBACKUP: Int = 506
        const val kRTXTeam: Int = 502
        const val kReadReceipt: Int = 131072
        const val kReceiptMode: Int = 16384
        const val kReceiptModeMsg: Int = 1019
        const val kReceivedAck: Int = 1007
        const val kRecommendChanged: Int = 2134
        const val kRecommendNewCorpCard: Int = 52
        const val kRecommendWechatWorkmateChange: Int = 2174
        const val kRedPointNotify: Int = 2127
        const val kReportRead: Int = 2001
        const val kRevoke: Int = 32
        const val kRevokeByAck: Int = 4128
        const val kRevokeMsg: Int = 2063
        const val kRichText: Int = 2
        const val kRoomChangeTips: Int = 1022
        const val kRoomDismiss: Int = 1014
        const val kRoomInfoChanged: Int = 2118
        const val kRoomNotice: Int = 65536
        const val kRoomNoticeTips: Int = 1026
        const val kSMSNotify: Int = 505
        const val kSelfHelpChanged: Int = 2119
        const val kSendFail: Int = 4194304
        const val kSentAck: Int = 1008
        const val kServerRetrySuccess: Int = 33554432
        const val kSessionTagChange: Int = 2160
        const val kSingleConversationChange: Int = 2171
        const val kSurvey: Int = 68
        const val kSystemInfoNotify: Int = 2110
        const val kText: Int = 0
        const val kTextControl: Int = 1011  // 系统消息，为错误提示消息
        const val kThirdApi: Int = 1048576
        const val kThirdAppNoRecvNews: Int = 1039
        const val kThirdPartyEncrypt: Int = 32768
        const val kTnctDocMyCreateListUpdate: Int = 2183
        const val kTnctDocMyViewListUpdate: Int = 2184
        const val kTodoCard: Int = 70
        const val kTodoChangeNotify: Int = 2148
        const val kTodoRemind: Int = 2150
        const val kUpdateApp: Int = 2173
        const val kUpdateMsgByAppInfo: Int = 2064
        const val kUploadPrinterDocResp: Int = 2182
        const val kUserHolidayInfoChange: Int = 2168
        const val kUserInfoNotify: Int = 2114
        const val kUserWorkStatusChange: Int = 2164
        const val kVideo: Int = 5     // 发送-视频
        const val kVideoCDN: Int = 17
        const val kVideoFullCDN: Int = 23  // 企业微信小视频
        const val kVipUserChanged: Int = 2156
        const val kVirtualCorpClaimed: Int = 2133
        const val kVirtualInviteNofity: Int = 2142
        const val kVoice: Int = 9
        const val kVoiceCDN: Int = 16  // 语音
        const val kVote: Int = 69
        const val kVoteAck: Int = 1027
        const val kWWWXOutRoom: Int = 16777216
        const val kWXTokenNeedRefresh: Int = 2152
        const val kWeAPPMsg: Int = 78
        const val kWeAppTemplateCardMsg: Int = 79
        const val kWeChatFriend: Int = 524288
        const val kWechatEmotion: Int = 104  // 微信表情
        const val kWechatImage: Int = 101  // 微信图片
        const val kWechatFile: Int = 102   // 微信文件
        const val kWechatVideo: Int = 103  // 微信小视频
        const val kWeixinPermissionChangeNotify: Int = 2167
        const val kWokLogNotifyMsg: Int = 62
        const val kWokLogSupportTemplateNotifyMsg: Int = 64
        const val kWorkLog: Int = 54
        const val kWorkMateChanged: Int = 2135
        const val kWxFileBackup: Int = 510
        const val kWxFriendChanged: Int = 2130
        const val kWxTokenInvalid: Int = 2116
        const val kWxVoipNotify: Int = 2166
    }

    data class Message(
        var ackSendState: Int = 0,
        var appinfo: ByteArray = byteArrayOf(),
        var asId: Long = 0,
        var content: ByteArray = byteArrayOf(),
        var contentType: Int = 0,
        var isInnerkfMannager: Boolean = false,
        var isUpdateMsg: Boolean = false,
        var outContact: Int = 0,
        var progress: SendProgress? = null,
        var referid: Long = 0,
        var remoteId: Long = 0,
        var sendScene: Int = 4,
        var sendTime: Int = 0,
        var sender: Long = 0,
        var seq: Long = 0,
        var state: Int = 2,
        var url: String = "",
        @Transient
        var original: Any? = null
    ) : Serializable {

        companion object {
            const val ACK_INIT: Int = 0
            const val ACK_SENDFAILED: Int = 2
            const val ACK_SENDING: Int = 1
            const val ACK_SENT: Int = 3
            const val CONTACT_TYPE_COMMUNITY: Int = 6
            const val CONTACT_TYPE_CORPGROUP: Int = 7
            const val CONTACT_TYPE_MAYBE_WX: Int = 4
            const val CONTACT_TYPE_NO: Int = 2
            const val CONTACT_TYPE_UNKNOWN: Int = 0
            const val CONTACT_TYPE_VIP: Int = 5
            const val CONTACT_TYPE_WX: Int = 3
            const val CONTACT_TYPE_YES: Int = 1

            /**
             * @param original
             */
            fun parseFrom(original: Any): Message {
                val json = Gson()
                val message = json.fromJson(json.toJson(original), Message::class.java) ?: Message()
                message.original = message
                return message
            }

        }

        data class SendProgress(
            var now: Long,
            var sendTimeActual: Long,
            var sendTimeEnqueue: Long,
            var total: Long
        ) : Serializable

    }

    data class MessageExtras(
        var canNotBeLastmessage: Boolean = false,
        var decryptRet: Int = -1,
        var disableDataDetector: Boolean = false,
        var firstSentMessageThatDay: Boolean = false,
        var isAlertReachedReaded: Boolean = false,
        var isSvrFail: Boolean = false,
        var openapiAssociateKey: ByteArray = byteArrayOf(),
        var translation: ByteArray = byteArrayOf(),
        var translationProvider: ByteArray = byteArrayOf(),
        var unreaduins: LongArray = longArrayOf(),
        var voiceTextInfo: VoiceTransInfo? = null
    ) : Serializable

    data class VoiceTransInfo(
        var isend: Boolean = false,
        var needMarkRead: Boolean = false,
        var seqid: Long = 0,
        var state: Int = 0,
        var transEndTime: Long = 0,
        var transStartTime: Long = 0,
        var transText: ByteArray = byteArrayOf(),
        var voiceid: ByteArray = byteArrayOf()
    ) : Serializable

}