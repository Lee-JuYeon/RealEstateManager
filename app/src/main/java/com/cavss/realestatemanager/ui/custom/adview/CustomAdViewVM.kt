package com.cavss.realestatemanager.ui.custom.adview

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class CustomAdViewVM : ViewModel() {
    private val _adViewType : MutableStateFlow<CustomAdViewType> = MutableStateFlow(CustomAdViewType.IMAGE)
    val getAdViewType : StateFlow<CustomAdViewType> = _adViewType
    fun setAdViewType(type : CustomAdViewType) {
        viewModelScope.launch {
            _adViewType.value = type
        }
    }

    init {

    }
}