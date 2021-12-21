package com.cavss.realestatemanager.model

import com.cavss.realestatemanager.R
import com.cavss.realestatemanager.model.type.BottomNaviType

sealed class BottomNaviModel(
    val type : BottomNaviType,
    val nativeTitle : Int,
    val icon : Int
) {
    object CHECKLIST : BottomNaviModel(type = BottomNaviType.CHECKLIST, nativeTitle = R.string.bottomNavi_checkList, icon = R.drawable.checklist)
    object NOTIFY : BottomNaviModel(type = BottomNaviType.NOTIFY, nativeTitle = R.string.bottomNavi_notify, icon = R.drawable.notify)

    object BOTTOM_NAVI_LIST {
        val list = listOf(
            CHECKLIST, NOTIFY
        )
    }
}