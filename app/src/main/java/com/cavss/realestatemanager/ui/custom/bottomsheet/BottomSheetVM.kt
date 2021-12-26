package com.cavss.realestatemanager.ui.custom.bottomsheet

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class BottomSheetVM : ViewModel(){
    private val _type = MutableLiveData<BottomSheetType>()
    fun setBottomSheetType(type : BottomSheetType){
        _type.postValue(type)
    }
    val getBottomSheetType : LiveData<BottomSheetType>
        get() = _type

    private val _show = MutableLiveData<Boolean>(false)
    fun setBottomSheetShows(show : Boolean){
        _show.postValue(show)
//        viewModelScope.launch {
//            delay(1000L)
//            _show.value = show
//        }
    }
    //    val getBottomSheetShows : StateFlow<Boolean> = _show
    val getBottomSheetShows : LiveData<Boolean> = _show
}