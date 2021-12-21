package com.cavss.realestatemanager.vm

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cavss.realestatemanager.model.CheckListModel
import com.cavss.realestatemanager.util.checklist.CheckListData
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class CheckListVM : ViewModel() {
    private val _checkList = MutableLiveData<List<CheckListModel>>()
    fun setCheckList(list : List<CheckListModel>){ _checkList.value = list }
    val getCheckList : LiveData<List<CheckListModel>>
        get() = _checkList

    private val _checkItem : MutableStateFlow<MutableList<Boolean>> = MutableStateFlow(mutableListOf<Boolean>())
    val getCheckItem : StateFlow<MutableList<Boolean>> = _checkItem
    fun setCheckItemAll(list : MutableList<Boolean>) {
        viewModelScope.launch {
            _checkItem.value = list
        }
    }
    fun setCheckItem(index : Int, change : Boolean){
        viewModelScope.launch {
            _checkItem.value[index] = change
        }
    }

    init {
        setCheckList(list = CheckListData.CHECKLIST_JEONSE)
        setCheckItemAll(list = MutableList(_checkList.value?.size ?: 0){ _ -> false})
    }
}