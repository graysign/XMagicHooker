package com.magic.wework.apis.com.tencent.wework.foundation.model.pb

import com.google.gson.Gson
import java.io.Serializable

/**
 * com.tencent.wework.foundation.model.pb.WwUser
 */
interface WwUser {

    companion object {
        const val CREATE_BY_BIZMAIL = 10
        const val CREATE_BY_IMPORT = 7
        const val CREATE_BY_MAIL = 5
        const val CREATE_BY_MOBILE = 1
        const val CREATE_BY_QQ = 3
        const val CREATE_BY_QYH = 11
        const val CREATE_BY_SMS = 4
        const val CREATE_BY_WEB = 6
        const val CREATE_BY_WECHAT_FRIEND_MOBILE = 9
        const val CREATE_BY_WECHAT_FRIEND_WEB = 8
        const val CREATE_BY_WECHAT_MESSAGE = 2
        const val Female = 2
        const val GENDER_None = 0
        const val MODIFY_ACCOUNT_ID = 1024
        const val MODIFY_ALIAS = 256
        const val MODIFY_CORP_ADDRESS = 4096
        const val MODIFY_CORP_EXTERNAL_NAME = 131072
        const val MODIFY_CUSTOM = 2048
        const val MODIFY_DEPARTMENT = 64
        const val MODIFY_EMAIL_ADDRESSS = 4
        const val MODIFY_ENGLISH_NAME = 128
        const val MODIFY_EXTERN_ATTRS = 32768
        const val MODIFY_EXTERN_POSITION = 8192
        const val MODIFY_GENDER = 2
        const val MODIFY_INTERNATION_CODE = 512
        const val MODIFY_IS_SYNC_INNER_POSITION = 16384
        const val MODIFY_JOB = 32
        const val MODIFY_LEADER = 65536
        const val MODIFY_MOBILE = 8
        const val MODIFY_NAME = 1
        const val MODIFY_NONE = 0
        const val MODIFY_PHONE = 16
        const val Male = 1
        const val Mobile_Offline = 102
        const val Mobile_Online = 101
        const val PC_Away = 3
        const val PC_Offline = 2
        const val PC_Online = 1
        const val SearchBidItemFlag_Description = 2
        const val SearchBidItemFlag_Remark = 1
        const val SearchBidItemFlag_RoomNick = 4
        const val Status_All_Inactive = 4
    }

    data class User(
        var acctid: String = "",
        var addContactDirectly: Boolean = false,
        var addContactRoomId: Long = 0,
        var alias: String = "",
        var applyHasRead: Boolean = true,
        var attr: Long = 0,
        var avatorUrl: String = "",
        var birthday: String = "",
        var cardSourceVid: Long = 1,
        var contactKey: String = "",
        var corpid: Long = 0,
        var createSeq: Long = 0,
        var createSource: Int = 0,
        var dispOrder: Int = 0,
        var emailAddr: String = "",
        var englishName: String = "",
        var extras: UserExtras? = null,
        var fullPath: String = "",
        var gender: Int = 0,
        var internationCode: String = "",
        var isNameVerified: Boolean = true,
        var isRecommendWorkmateAdded: Boolean = false,
        var isTrim: Boolean = false,
        var isValid: Boolean = true,
        var job: String = "",
        var level: Int = 0,
        var mobile: String = "",
        var name: String = "",
        var number: String = "",
        var onlineStatus: Int = 101,
        var parentIds: LongArray = longArrayOf(),
        var phone: String = "",
        var phoneContactType: Int = 0,
        var recommendContactSource: Int = 0,
        var recommendNickName: String = "",
        var remoteId: Long = 0,
        var searchBidItem: Long = 0,
        var searchMatchOptions: Long = 0,
        var tagBidName: String = "",
        var ticket: ByteArray = byteArrayOf(),
        var unionid: String = "",
        var userDeptInfoList: Array<UserDepartmentInfo> = emptyArray(),
        @Transient
        var original: Any? = null
    ) : Serializable {

        companion object {

            const val PCT_BothFriend = 2
            const val PCT_NoneFriend = 3
            const val PCT_OneWayFriend = 1
            const val PCT_Unknown = 0
            const val RCS_Card = 4
            const val RCS_Phone = 1
            const val RCS_Unknown = 0
            const val RCS_WX = 2
            const val RCS_WorkMate = 3
            const val SMT_Name = 1
            const val SMT_NickName = 2
            const val SMT_RealName = 4
            const val SMT_Unknown = 0
            
            /**
             * @param original com.tencent.wework.foundation.pb.model.WwUser$User
             */
            fun parseFrom(original: Any): User {
                val json = Gson()
                val user = json.fromJson(json.toJson(original), User::class.java) ?: User()
                user.original = original
                return user
            }
        }

    }

    data class UserDepartmentInfo(
        var attr: Long = 0,
        var attr2: Long = 0,
        var circleId: Long = 0,
        var dispOrder: Long = 0,
        var groupId: Long = 0,
        var hash: Long = 0,
        var job: String = "",
        var partyid: Long = 0,
        var seq: Long = 0,
        var vid: Long = 0
    ) : Serializable

    data class UserExtras(
//        var addFriendSource: Contact.AddFriendSource? = null,
//        var applyMsgFlow: Array<ApplyMsgFlow> = arrayOf(),
//        var applyUpdateTime: Long = 0,
//        var attr2: Long = 0,
//        var attribute: Int = 0,
//        var bindEmailStatus: Int = 1,
//        var circleLanguage: Int = 0,
//        var companyRemark: ByteArray = byteArrayOf(),
//        var contactGroupIds: LongArray = longArrayOf(),
//        var contactInfoWx: User? = null,
//        var contactKey: String = "",
//        var corpExternalName: ByteArray = byteArrayOf(),
//        var customInfo: Common.CustomAttrInfo? = null,
//        var customerAddTime: Int = 0,
//        var customerDescription: String = "",
//        var customerUpdateTime: Long = 0,
//        var externJobTitle: ByteArray = byteArrayOf(),
//        var externPosition: ByteArray = byteArrayOf(),
//        var externalCustomInfo: Common.SelfAttrInfo? = null,
//        var headID: Long = 0,
//        var holidayExtraInfo: Common.UserHolidayExtraInfo? = null,
//        var holidayInfo: Common.HolidayInfo? = null,
//        var inviteVid: Long = 0,
//        var isSyncInnerPosition: Boolean = true,
//        var labelIds: Array<WwUserLabelid.ContactCustomerLabelId> = arrayOf(),
        var lastRemarkTime: Int = 0,
        var nameVerifyStatus: Int = 3,
        var newContactApplyContent: String = "",
        var newContactTime: Long = 0,
        var openid: ByteArray = byteArrayOf(),
        var profileCode: ByteArray = byteArrayOf(),
        var pstnExtensionNumber: ByteArray = byteArrayOf(),
        var pstnExtensionNumberNew: ByteArray = byteArrayOf(),
        var realName: String = "",
        var realRemark: ByteArray = byteArrayOf(),
        var recommendReason: Int = 0,
//        var remarkPhone: Array<Common.RemarkPhoneInfo> = arrayOf(),
//        var remarkUrl: ByteArray = byteArrayOf(),
//        var remarks: String = "",
//        var robotProfile: Common.RobotProfile? = null,
//        var tencentInfo: Common.TencentInfo? = null,
//        var underVerifyName: String = "",
//        var userHolidayInfo: Common.UserHolidayInfo? = null,
//        var vCorpNameFull: String = "",
//        var vCorpNameShort: String = "",
//        var vRecommendInfo: Common.VirtualRecommendInfo? = null,
//        var vcode: ByteArray = byteArrayOf(),
//        var virtualCreateMail: String = "",
//        var wcode: ByteArray = byteArrayOf(),
//        var wxIdentytyOpenid: ByteArray = byteArrayOf(),
//        var xcxCorpAddress: ByteArray = byteArrayOf(),
        var xcxStyle: Int = 0
    ) : Serializable {
        companion object {
            const val CA_Add = 1
            const val CA_Apply = 100
            const val CA_HAS_Added = 4
            const val CA_HAS_SEND_INVITE_MSG = 6
            const val CA_HIDE = 5
            const val CA_Invite = 2
            const val CA_Recommend = 3
            const val CA_Unknown = 0
            const val CA_WX_FRIEND_APPLY = 1000
            const val CA_Wait_Confirm = 101
            const val EMAIL_UNBINDED = 5
            const val EMAIL_UNVERIFY = 2
            const val EMAIL_UNVERIFY_LOGOUT = 4
            const val EMAIL_UNVERIFY_PSW = 3
            const val EMAIL_VERIFY = 1
        }

        data class ApplyMsgFlow(
            var content: ByteArray = byteArrayOf(),
            var issender: Boolean = false
        ): Serializable
    }

    data class VirtualRecommendInfo(
        var friendVids: ByteArray = byteArrayOf(),
        var moreThanTwoFriend: Boolean = false,
        var type: Int = 0
    ) : Serializable

    data class WeChatInfo(
        var avatar: String = "",
        var nick: String = ""
    ) : Serializable

    data class WexinInfoByQrcode(
        var gender: Int = 0,
        var imageUrl: String = "",
        var nickName: String = "",
        var openid: ByteArray = byteArrayOf(),
        var status: Int = 0,
        var unionid: ByteArray = byteArrayOf()
    ) : Serializable

}