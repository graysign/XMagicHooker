package com.magic.shared.apis.com.tencent.mm.compatible.deviceinfo

import com.magic.shared.mirror.com.tencent.mm.compatible.deviceinfo.Classes
import com.magic.shared.mirror.com.tencent.mm.compatible.deviceinfo.Methods
import de.robv.android.xposed.XposedHelpers
import kotlin.contracts.Returns

object CpuChecker {

    fun getCpuFlag(): Int =
        XposedHelpers.callStaticMethod(Classes.CpuChecker, Methods.CpuChecker.getCpuFlag.name) as Int

    fun getCpuType(): Int {
        val flag = getCpuFlag()
        var cpuType = 2
        if (flag.and(1024) != 0) {
            cpuType = 4
        } else if(flag.and(512) != 0) {
            cpuType = 2
        }
        return cpuType
    }

}