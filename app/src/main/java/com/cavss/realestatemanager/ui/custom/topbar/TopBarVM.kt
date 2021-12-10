package com.cavss.realestatemanager.ui.custom.topbar

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class TopBarVM : ViewModel() {
    private val _topbarList = MutableLiveData<List<TopBarModel>>(TopBarModel.TOPBAR_LIST.mainList)
    fun setTopBarList(list : List<TopBarModel>){ _topbarList.postValue(list) }
    val getTopBarList : LiveData<List<TopBarModel>> = _topbarList
}