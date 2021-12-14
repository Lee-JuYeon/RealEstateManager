package com.cavss.realestatemanager.ui.custom.bottomsheet

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.viewModelScope
import com.cavss.realestatemanager.ui.custom.popup.PopUpVM
import com.cavss.realestatemanager.vm.MainVM
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

@SuppressLint("CoroutineCreationDuringComposition")
@OptIn(ExperimentalMaterialApi::class)
@Composable
fun BottomSheetView(
    mainVM : MainVM
) {
    val bottomSheetState = rememberModalBottomSheetState(initialValue = ModalBottomSheetValue.Expanded)
    val bottomSheetScope = rememberCoroutineScope()
    val context = LocalContext.current

    val isShow = remember { mutableStateOf(false) }
    mainVM.getBottomSheetShows.observe(LocalLifecycleOwner.current){
        isShow.value = it

        when(it){
            true -> {
                bottomSheetState.hide()
            }
            false -> {

            }
        }
        Log.e("mException", "current value : ${bottomSheetState.currentValue}")
    }

    bottomSheetScope.launch {

    }
    if (isShow.value){
        ModalBottomSheetLayout(
            sheetBackgroundColor = Color.LightGray, // 시트 배경 색
            sheetElevation = 5.dp,
            sheetState = bottomSheetState,
            sheetShape = RoundedCornerShape(
                topStart = 30.dp,
                topEnd = 30.dp
            ),
            scrimColor = Color.DarkGray.copy(0.5f), // 시트뷰 뒤의 배경색
            sheetContent = {
                BottomSheetItem()
            }
        ) {
//            Text(
//                text = "배경",
//                color = Color.Magenta,
//                fontSize = 20.sp,
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .fillMaxHeight()
//            )
        }
    }else{
        Log.e("mException","show? : ${mainVM.getBottomSheetShows.value}")
    }
}

@Composable
fun BottomSheetItem(){
    Row(
        verticalAlignment = Alignment.Top,
        horizontalArrangement = Arrangement.Start,
        modifier = Modifier
            .fillMaxWidth()
            .height(500.dp)
    ) {
        Text(
            text = "text11",
            color = Color.Yellow,
            fontSize = 20.sp,
            modifier = Modifier
        )
    }
}