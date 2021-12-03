package com.cavss.realestatemanager.model

data class CheckListModel(
    val type : List<String>,
    val check : String,
    val trick : List<String>,
    val target : List<String>,
    val doubtSituation : List<String>,
    val relativeLaw : List<String>,
) {
}