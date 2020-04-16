//package com.magic.wework.apis.com.tencent.wework.foundation.logic
//
//import com.magic.kernel.core.Clazz
//import com.magic.wework.mirror.com.tencent.wework.foundation.observer.Classes.IDepartmentServiceObserver
//import com.magic.wework.mirror.com.tencent.wework.foundation.callback.Classes.ICommonResultCallback
//import com.magic.wework.mirror.com.tencent.wework.foundation.callback.Classes.IGetChildDepartmentsCallback
//import com.magic.wework.mirror.com.tencent.wework.foundation.callback.Classes.IGetDepartmentUserIDMapCallback
//import com.magic.wework.mirror.com.tencent.wework.foundation.callback.Classes.IGetParentDepartmentCallback
//import com.magic.wework.mirror.com.tencent.wework.foundation.callback.Classes.IGetUserByIdCallback
//import com.magic.wework.mirror.com.tencent.wework.foundation.callback.Classes.IModifyAvatarCallback
//import com.magic.wework.mirror.com.tencent.wework.foundation.model.Classes.Department
//import com.magic.wework.mirror.com.tencent.wework.foundation.logic.Classes
//import com.magic.wework.mirror.com.tencent.wework.foundation.logic.Methods
//import de.robv.android.xposed.XposedHelpers
//
//object DepartmentService {
//
//    fun getService(): Any =
//        XposedHelpers.callStaticMethod(
//            Classes.DepartmentService,
//            Methods.DepartmentService.getService.name
//        )
//
//    /**
//     * 添加部门变化监听
//     */
//    fun addObserver(iDepartmentServiceObserver: Any) =
//        XposedHelpers.callMethod(
//            getService(), Methods.DepartmentService.AddObserver.name,
//            arrayOf(IDepartmentServiceObserver), iDepartmentServiceObserver
//        )
//
//    /**
//     * 获取指定部门下的child部门
//     * @param department com.tencent.wework.foundation.model.Department
//     * @param iGetChildDepartmentsCallback com.tencent.wework.foundation.callback.IGetChildDepartmentsCallback
//     */
//    fun getChildDepartments(department: Any, iGetChildDepartmentsCallback: Any) =
//
//    /**
//     * 获取部门
//     * @param deptIds
//     * @param iGetChildDepartmentsCallback com.tencent.wework.foundation.callback.IGetChildDepartmentsCallback
//     */
//    fun getDepartmentsByIds(deptIds: LongArray, iGetChildDepartmentsCallback: Any) =
//        XposedHelpers.callMethod(
//        )
//
//    /**
//     * 获取指定部门的组织架构
//     * @param deptId
//     * @param iGetDepartmentUserIDMapCallback com.tencent.wework.foundation.callback.IGetDepartmentUserIDMapCallback
//     */
//    fun getDepartmentFramework(deptId: Long, iGetDepartmentUserIDMapCallback: Any) =
//        XposedHelpers.callMethod(
//            deptId, iGetDepartmentUserIDMapCallback
//        )
//
//    /**
//     * 获取指定部门下的用户
//     * @param departmentIds
//     * @param iGetUserByIdCallback com.tencent.wework.foundation.callback.IGetUserByIdCallback
//     */
//    fun getDepartmentUserMap(departmentIds: LongArray, iGetUserByIdCallback: Any) =
//        XposedHelpers.callMethod(
//            departmentIds, iGetUserByIdCallback
//        )
//
//    /**
//     * @param departmentIds
//     * @param iGetChildDepartmentsCallback com.tencent.wework.foundation.callback.IGetChildDepartmentsCallback
//     */
//    fun getDualDepartmentListByIds(departmentIds: LongArray, iGetChildDepartmentsCallback: Any) =
//        XposedHelpers.callMethod(
//            getService(), Methods.DepartmentService.GetDualDepartmentListByIds.name,
//        )
//
//    /**
//     * 获取指定部门下的child部门
//     * @param department com.tencent.wework.foundation.model.Department
//     * @param iGetParentDepartmentCallback com.tencent.wework.foundation.callback.IGetParentDepartmentCallback
//     */
//    fun getParentDepartment(department: Any, iGetParentDepartmentCallback: Any) =
//        XposedHelpers.callMethod(
//            getService(), Methods.DepartmentService.GetParentDepartment.name,
//        )
//
//    /**
//     * @param z
//     * @param iGetChildDepartmentsCallback com.tencent.wework.foundation.callback.IGetChildDepartmentsCallback
//     */
//    fun getRootDepartmentList(z: Boolean, iGetChildDepartmentsCallback: Any) =
//        XposedHelpers.callMethod(
//            getService(), Methods.DepartmentService.GetRootDepartmentList.name,
//        )
//
//    /**
//     * 登录用户信息
//     */
//    fun loginUser(): Any =
//        XposedHelpers.callMethod(
//            getService(), Methods.DepartmentService.LoginUser.name
//        )
//
//    /**
//     * @param path
//     * @param iModifyAvatarCallback com.tencent.wework.foundation.callback.IModifyAvatarCallback
//     */
//    fun modifyUserAvatar(path: String, iModifyAvatarCallback: Any) =
//        XposedHelpers.callMethod(
//            getService(), Methods.DepartmentService.ModifyUserAvatar.name,
//        )
//
//    /**
//     * 修改职务
//     * @param jobName
//     * @param iCommonResultCallback com.tencent.wework.foundation.callback.ICommonResultCallback
//     */
//    fun modifyUserJob(jobName: String, iCommonResultCallback: Any) =
//        XposedHelpers.callMethod(
//            getService(), Methods.DepartmentService.ModifyUserJob.name,
//        )
//
//    /**
//     * 修改对外显示职务
//     * @param jobName
//     * @param iCommonResultCallback com.tencent.wework.foundation.callback.ICommonResultCallback
//     */
//    fun modifyUserExternJob(jobName: String, iCommonResultCallback: Any) =
//        XposedHelpers.callMethod(
//            getService(), Methods.DepartmentService.ModifyUserExternJob.name,
//        )
//
//}