package com.cavss.realestatemanager.ui.custom.popup

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*

class PopUpVM : ViewModel() {
    private val _popupType = MutableStateFlow(PopUpType.NONE)
    val getPopUpType : StateFlow<PopUpType> = _popupType
    fun setPopUpType(type : PopUpType){
        viewModelScope.launch{
            _popupType.value = type
        }
    }

    private val _popupTitle = MutableStateFlow("")
    val getPopUpTitle : StateFlow<String> = _popupTitle
    fun setPopUpTitle(title : String){
        viewModelScope.launch {
            _popupTitle.value = title
        }
    }


    init {

    }

    override fun onCleared() {
        super.onCleared()

    }

}

/*
https://two22.tistory.com/16

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

    fun getTitle(){
        viewModelScope.launch {

        }
    }

    lifecycleScope.launchWhenStarted {
        // 2.
        viewModel.userName.collect { userName ->
            userNameLabel.text = userName
        }
    }

 */
