package com.magic.wework.apis.com.tencent.wework.foundation.logic

import com.google.gson.Gson
import java.io.Serializable

data class SyncDepartmentState(
    var now: Long = 0,
    var state: Int = 0,
    var total: Long = 0,
    @Transient
    var original: Any? = null
) : Serializable {
    companion object {

        /**
         * @param original com.tencent.wework.foundation.logic.SyncDepartmentState
         */
        fun parseFrom(original: Any): SyncDepartmentState {
            val json = Gson()
            val state = json.fromJson(json.toJson(original), SyncDepartmentState::class.java) ?: SyncDepartmentState()
            state.original = original
            return state
        }
    }
}
