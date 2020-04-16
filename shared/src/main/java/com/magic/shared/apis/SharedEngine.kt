package com.magic.shared.apis

import com.magic.kernel.core.HookerCenter
import com.magic.shared.hookers.ActivityHookers
import com.magic.shared.hookers.DatabaseHookers
import com.magic.shared.hookers.FileHookers

object SharedEngine {

    var hookerCenters: List<HookerCenter> = listOf(
        ActivityHookers
//        DatabaseHookers,
//        FileHookers
    )
}
