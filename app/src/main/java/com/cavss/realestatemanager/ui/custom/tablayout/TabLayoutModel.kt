package com.cavss.realestatemanager.ui.custom.tablayout

import com.cavss.realestatemanager.R

sealed class TabLayoutModel(
    val route : String,
    val title : Int
) {
    object BUY : TabLayoutModel("매매", R.string.checkList_option_buy)
    object JEONSE : TabLayoutModel("전세", R.string.checkList_option_jeonse)
    object MONTHLY_RENT : TabLayoutModel("월세", R.string.checkList_option_monthlyRent)

    object RENT_TYPE_LIST {
        val list = listOf(
            JEONSE, MONTHLY_RENT, BUY
        )
    }
}