package com.magic.wework.mirror

import com.magic.kernel.MagicGlobal.lazy
import com.magic.kernel.core.Clazz
import com.magic.kernel.helper.ReflecterHelper.findMethodsByExactParameters
import java.lang.reflect.Method

object Methods {

    object ConversationEngine {

    }

    object FileUpAndDownLoadEngine {

    }

    object MessageItem {

//        val parse: Method by lazy("${javaClass.name}.parse") {
//            findMethodsByExactParameters(
//                Classes.MessageItem,
//                null,
//                Classes.MessageItem,
//                IWwConversation.Conversation,
//                Message
//            ).mapNotNull {
//                it.takeIf {
//                    "${it.genericReturnType}".equals(
//                        "java.util.List<${Classes.MessageItem.canonicalName}>",
//                        false
//                    )
//                }
//            }.firstOrNull()
//        }

    }

    object MessageManager {

    }
}