package com.cavss.realestatemanager.ui.custom.bottomsheet

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
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
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.viewModelScope
import com.cavss.realestatemanager.ui.custom.popup.PopUpType
import com.cavss.realestatemanager.ui.custom.popup.PopUpVM
import com.cavss.realestatemanager.vm.MainVM
import kotlinx.coroutines.Dispatchers
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
                bottomSheetScope.launch(Dispatchers.IO) {
//                    bottomSheetState.animateTo(ModalBottomSheetValue.Expanded)
                    bottomSheetState.show()
                }
            }
            false -> {
                bottomSheetScope.launch(Dispatchers.IO) {
//                    bottomSheetState.animateTo(ModalBottomSheetValue.Hidden)
                    bottomSheetState.hide()
                }
            }
        }
        Log.e("mException", "current value : ${bottomSheetState.currentValue}")
    }

    if (isShow.value){
        when(mainVM.getBottomSheetType.value){
            PopUpType.CHECKLIST_ITEM_IMAGE -> {
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
                        BottomSheetCheckListImage(imageList = mainVM.getCheckListImages.value ?: listOf())
                    }
                ) {}
            }
            else -> {
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
                        Text(
                            text = "ELSE",
                            color = Color.Yellow,
                            fontSize = 20.sp,
                            modifier = Modifier
                        )
                    }
                ) {}
            }
        }
    }else{
        Log.e("mException","show? : ${mainVM.getBottomSheetShows.value}")
    }
}

@Composable
fun BottomSheetCheckListImage(
    imageList : List<String>
){
    val screenWidth = LocalConfiguration.current.screenWidthDp.dp
    val screenHeight = LocalConfiguration.current.screenHeightDp.dp

    val horizontalPaadingValue = 5.dp
    Column(
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .padding(
                top = 40.dp,
//                start = horizontalPaadingValue,
//                end = horizontalPaadingValue,
                bottom = 5.dp
            )
    ) {
        LazyRow(
            contentPadding = PaddingValues(
                horizontal = 10.dp
            ),
            content = {
                items(imageList){ image ->
                    Text(
                        text = image,
                        color = Color.Black,
                        modifier = Modifier
                            .background(Color.White)
                            .size(
                                width = screenWidth - (horizontalPaadingValue * 2),
                                height = screenHeight - 100.dp
                            )
                            .border(
                                1.dp,
                                Color.Black,
                                RectangleShape
                            )
                    )
                }
            }
        )

    }
}