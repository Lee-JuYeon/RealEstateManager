package com.cavss.realestatemanager.model.type

enum class CheckListType(val rawValue : String) {
    SELL_BUY(rawValue = "매매"),
    JEONSE(rawValue = "전세"),
    MONTH_RENT(rawValue = "월세")
}