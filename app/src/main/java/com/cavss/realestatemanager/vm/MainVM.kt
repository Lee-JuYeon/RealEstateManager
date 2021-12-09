package com.cavss.realestatemanager.vm

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

enum class BottomSheetType(val rawValue : String){
    CHECKLIST_RELATIVE_PHOTO(rawValue = "CHECKLIST_RELATIVE_PHOTO"),
    CHECKLIST_SHARE(rawValue = "CHECKLIST_SHARE")
}

class MainVM : ViewModel() {

    private val _bottomSheet = MutableStateFlow<BottomSheetType>(BottomSheetType.CHECKLIST_RELATIVE_PHOTO)
    fun setBottomSheet(list : BottomSheetType){
        viewModelScope.launch {
            _bottomSheet.value = list
        }
        viewModelScope.launch {
            _bottomSheet.collect {  type ->

            }
        }
    }
    val getBottomSheet : StateFlow<BottomSheetType>
        get() = _bottomSheet



}

/*
Dispatchers.Main
- 이 디스패처를 사용하여 기본 Android 스레드에서 코루틴을 실행합니다.
  이 디스패처는 UI와 상호작용하고 빠른 작업을 실행하기 위해서만 사용해야 합니다.
  예를 들어 suspend 함수를 호출하고 Android UI 프레임워크 작업을 실행하며 LiveData 객체를 업데이트합니다.

Dispatchers.IO
- 이 디스패처는 기본 스레드 외부에서 디스크 또는 네트워크 I/O를 실행하도록 최적화되어 있습니다.
  예를 들어 회의실 구성요소를 사용하고 파일에서 읽거나 파일에 쓰며 네트워크 작업을 실행합니다.

Dispatchers.Default
- 이 디스패처는 CPU를 많이 사용하는 작업을 기본 스레드 외부에서 실행하도록 최적화되어 있습니다.
  예를 들어 목록을 정렬하고 JSON을 파싱합니다.
 */