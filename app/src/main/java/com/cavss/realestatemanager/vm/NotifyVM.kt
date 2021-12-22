package com.cavss.realestatemanager.vm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.cavss.realestatemanager.ui.view.main.notify.NotifyModel

class NotifyVM : ViewModel() {
    private val _notifyList = MutableLiveData<List<NotifyModel>>()
    fun setNotifyList(list : List<NotifyModel>){
        _notifyList.postValue(list)
    }
    val getNotifyList : LiveData<List<NotifyModel>>
        get() = _notifyList


    init {
        setNotifyList(list = dummyList())
    }

    private fun dummyList() = listOf<NotifyModel>(
        NotifyModel(
            notifyTitle = "공인중개사를 통해 계약하세요",
            notifyDescription = "허위매물 등 사기를 쳤을 경우, 궁인중개사의 \"중개사고\"이기 때문에 책임이 공인중개사에게 있습니다. 따라서 공인중개사를 통하여 거래를 하는 것이 그나마 안전합니다.",
            notifyUpdateDate = "22th December, 2021"
        ),
        NotifyModel(
            notifyTitle = "개인정보 처리방침",
            notifyDescription = "ㅁㄴㅇㄹㅁㄴㅇㄹㅁㅇㄹㅁ",
            notifyUpdateDate = "22th December, 2021"
        )
    )
}