package com.cavss.realestatemanager.ui.custom.bottomnavi

import com.cavss.realestatemanager.R

sealed class OptionModel(
    val type : String,
    val inNative : Int
) {
    object BUY : OptionModel(type = "매매", inNative = R.string.checkList_option_buy)
    object JEONSE : OptionModel(type = "전세", inNative = R.string.checkList_option_jeonse)
    object MONTHLY_RENT : OptionModel(type = "월세", inNative = R.string.checkList_option_monthlyRent)
    object SHORT_RENT : OptionModel(type = "단기임대", inNative = R.string.checkList_option_shortRent)

    object OPTION_LIST {
        val list = listOf(
            BUY, JEONSE, MONTHLY_RENT, SHORT_RENT
        )
    }
}
