//package com.magic.wework.apis.com.tencent.wework.foundation.model
//
//import com.magic.kernel.core.Clazz
//import com.magic.wework.mirror.com.tencent.wework.foundation.model.Methods
//import com.magic.wework.apis.com.tencent.wework.foundation.model.pb.WwUser
//import com.magic.wework.mirror.com.tencent.wework.foundation.model.Classes
//import de.robv.android.xposed.XposedHelpers
//
///**
// * @param original com.tencent.wework.foundation.model.User
// */
//data class User(var original: Any) {
//
//    companion object {
//
//        /**
//         * 获取一个临时的User
//         */
//        fun getTemp() =
//            XposedHelpers.callStaticMethod(Classes.User, Methods.User.getTemp.name)
//
//        fun setInfo(original: Any, info: Any) =
//            XposedHelpers.callMethod(original, Methods.User.setInfo.name, info)
//
//        /**
//         * @return com.tencent.wework.foundation.model.pb.WwUser.User
//         */
//        fun getInfo(original: Any): Any =
//            XposedHelpers.callMethod(original, Methods.User.getInfo.name)
//
//        /**
//    }
//
//    fun getInfo(): WwUser.User = WwUser.User.parseFrom(Companion.getInfo(original))
//
//    fun getRemoteId(): Long = getInfo().remoteId
//
//    fun requestInfo(): WwUser.User = WwUser.User.parseFrom(Companion.requestInfo(original))
//
//    fun isInnerCustomerServer(): Boolean = Companion.isInnerCustomerServer(original)
//
//    fun isWeixinXidUser(): Boolean = Companion.isWeixinXidUser(original)
//
//    fun isExternalCustomerServer(): Boolean = Companion.isExternalCustomerServer(original)
//
//    fun isVipUser(): Boolean = Companion.isVipUser(original)
//
//    fun isGroupRobot(): Boolean = Companion.isGroupRobot(original)
//
//    fun checkUserInfoExist(): Boolean = Companion.checkUserInfoExist(original)
//
//    fun getUserRealName(): String = Companion.getUserRealName(original)
//
//    fun isHasRealName(): Boolean = Companion.isHasRealName(original)
//
//    fun isWechatStranger(): Boolean = Companion.isWechatStranger(original)
//
//    fun getDisplayName(): String = Companion.getDisplayName(original)
//
//    fun getMobilePhone(): String = Companion.getMobilePhone(original)
//
//    fun getHeadUrl(): String = Companion.getHeadUrl(original)
//
//    fun getName(): String = Companion.getName(original)
//
//    fun getUserAttr(): Long = Companion.getUserAttr(original)
//
//    fun isOutFriend(): Boolean = Companion.isOutFriend(original)
//
//    fun isVerfiedUser(): Boolean = Companion.isVerfiedUser(original)
//
//    fun getApplyContent(): String = Companion.getApplyContent(original)
//
//    fun getHolidayInfo(): Common.HolidayInfo? {
//        val holidayInfo = Companion.getHolidayInfo(original)
//        return if (holidayInfo != null) Common.HolidayInfo.parseFrom(holidayInfo) else null
//    }
//
//    fun getSelfAttrInfo(): Common.SelfAttrInfo? {
//        val holidayInfo = Companion.getSelfAttrInfo(original)
//        return if (holidayInfo != null) Common.SelfAttrInfo.parseFrom(holidayInfo) else null
//    }
//
//    fun hasWechatInfo(): Boolean = Companion.hasWechatInfo(original)
//
//    fun getWechatInfo(): WwUser.User? {
//        val user = Companion.getWechatInfo(original)
//        return if (user != null) WwUser.User.parseFrom(user) else null
//    }
//
//    fun isTencentMember(): Boolean = Companion.isTencentMember(original)
//
//    fun getRobotProfile(): Common.RobotProfile? {
//        val profile = Companion.getRobotProfile(original)
//        return if (profile != null) Common.RobotProfile.parseFrom(profile) else null
//    }
//}
