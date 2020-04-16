//package com.magic.shared.hookers
//
//import com.magic.kernel.core.HookerCenter
//import com.magic.kernel.core.Hooker
//import com.magic.shared.hookers.interfaces.IXLogHooker
//import com.magic.shared.mirror.com.tencent.mars.xlog.Constants.toReadableLevel
//import com.magic.shared.mirror.com.tencent.mars.xlog.Methods.Xlog_logWrite
//import com.magic.shared.mirror.com.tencent.mars.xlog.Methods.Xlog_logWrite2
//import de.robv.android.xposed.XC_MethodHook
//import de.robv.android.xposed.XposedBridge
//
//object XLogHookers : HookerCenter() {
//    override val interfaces: List<Class<*>>
//        get() = listOf(IXLogHooker::class.java)
//
//    override fun provideEventHooker(event: String) = when (event) {
//        "onXLogWrite" -> onXLogWriteHooker
//        "onXLogWrite2" -> onXLogWrite2Hooker
//        else -> throw IllegalArgumentException("Unknown event: $event")
//    }
//
//    private val onXLogWriteHooker = Hooker {
//        XposedBridge.hookMethod(Xlog_logWrite, object : XC_MethodHook() {
//            override fun afterHookedMethod(param: MethodHookParam) {
//                val level = toReadableLevel(param.args[0] as Int)
//                val tag = param.args[1] as String? ?: ""
//                val msg = param.args[8] as String? ?: ""
//                notify("onXLogWrite") {
//                    (it as IXLogHooker).onXLogWrite(level, tag, msg)
//                }
//            }
//        })
//    }
//
//    private val onXLogWrite2Hooker = Hooker {
//        XposedBridge.hookMethod(Xlog_logWrite2, object : XC_MethodHook() {
//            override fun afterHookedMethod(param: MethodHookParam) {
//                val level = toReadableLevel(param.args[0] as Int)
//                val tag = param.args[1] as String? ?: ""
//                val msg = param.args[8] as String? ?: ""
//                notify("onXLogWrite2") {
//                    (it as IXLogHooker).onXLogWrite(level, tag, msg)
//                }
//            }
//        })
//    }
//}