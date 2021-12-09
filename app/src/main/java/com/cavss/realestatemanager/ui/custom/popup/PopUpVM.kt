package com.cavss.realestatemanager.ui.custom.popup

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*

enum class PopUpType{
    ADVIEW_REQUEST,
    ADVIEW_IMAGE,
    ADVIEW_VIDEO,
    TOPBAR_NOTIFY,
    TOPBAR_CONTACT,
    TOPBAR_
}
class PopUpVM : ViewModel() {
    private val _popupType = MutableStateFlow(PopUpType.TOPBAR_NOTIFY)
    val getPopUpType : StateFlow<PopUpType> = _popupType
    fun setPopUpType(type : PopUpType){
        viewModelScope.launch{
            _popupType.value = type
        }
    }

    private val _popupTitle : Flow<Int> = flow {
        try {
            emit(1)
        }catch (e:Exception){
            Log.e("mException", "PopUpVM, _popuptitle, Exception // e : ${e.message}")
        }
    }

    val getPopUpTitle : Job = CoroutineScope(Dispatchers.IO).launch {
        _popupTitle.collect {
            delay(100)
            it
        }
    }

    init {

    }
}

/*
https://two22.tistory.com/16

    lifecycleScope.launchWhenStarted {
        // 2.
        viewModel.userName.collect { userName ->
            userNameLabel.text = userName
        }
    }

 */
