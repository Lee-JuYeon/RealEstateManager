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
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import com.cavss.realestatemanager.R
import com.cavss.realestatemanager.ui.custom.bottomsheet.content.listimage.ListImageView
import com.cavss.realestatemanager.ui.custom.bottomsheet.content.sharesns.ShareSNSView
import com.cavss.realestatemanager.vm.MainVM
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

/*
참고 사이트
https://www.zhangjiaxue.cn/2021/05/27/Jetpack%20Compose/Jetpack%20Compose%20ModalBottomSheetLayout/

 */
@SuppressLint("CoroutineCreationDuringComposition")
@OptIn(ExperimentalMaterialApi::class)
@Composable
fun BottomSheetView(
    mainVM : MainVM,
    bottomSheetVM : BottomSheetVM
) {

    val scope = rememberCoroutineScope()
    val bottomSheetState = rememberModalBottomSheetState(initialValue = ModalBottomSheetValue.Hidden)
    val bottomSheetShows = remember { mutableStateOf(false) }
    val bottomSheetType = remember { mutableStateOf(BottomSheetType.SHARE) }
    bottomSheetVM.apply {
        getBottomSheetShows.observe(LocalLifecycleOwner.current){
            bottomSheetShows.value = it
            when(it){
                true -> {
                    scope.launch(Dispatchers.Main) {
                        try {
                            bottomSheetState.show()
//                            bottomSheetVM.setBottomSheetShows(true)
                        }catch (e:Exception){
                            Log.e("mException", "BottomSheetView, scope, show // Exception : ${e.message}")
                        }
                    }
                }
                false -> {
                    scope.launch(Dispatchers.Main) {
                        try {
                            bottomSheetState.hide()
//                            bottomSheetVM.setBottomSheetShows(false)
                        }catch (e:Exception){
                            Log.e("mException", "BottomSheetView, scope, hide // Exception : ${e.message}")
                        }
                    }
                }
            }
        }
        getBottomSheetType.observe(LocalLifecycleOwner.current){
            bottomSheetType.value = it
        }
    }


    when(bottomSheetShows.value){
        true -> {
            Log.e("mException", "BottomSheetView // set BottomSheetView to shows")
            ModalBottomSheetLayout(
                sheetBackgroundColor = Color.Transparent, // 시트 배경 색
                sheetState = bottomSheetState,
                scrimColor = Color.DarkGray.copy(0.5f), // 시트뷰 뒤의 배경색
                sheetContent = {
                    val cornerRadius = 30.dp
                    Box(
                        modifier = Modifier
                            .padding(
                                start = 5.dp,
                                end = 5.dp,
                                bottom = 1.dp
                            )
                            .clip(
                                RoundedCornerShape(
                                    topStart = cornerRadius,
                                    topEnd = cornerRadius
                                )
                            )
                            .border(
                                1.dp,
                                Color.White,
                                RoundedCornerShape(
                                    topStart = cornerRadius,
                                    topEnd = cornerRadius
                                )
                            )
                            .background(colorResource(id = R.color.background))
                            .padding(
                                start = 10.dp,
                                end = 10.dp,
                                top = cornerRadius,
                                bottom = 5.dp
                            )
                    ) {
                        when(bottomSheetType.value){
                            BottomSheetType.SHARE -> {
                                ShareSNSView()
                            }
                            BottomSheetType.CHECKLIST_PICTURES -> {
                                ListImageView()
                            }
                        }
                    }
                }
            ) {

            }
        }
        false -> {
            Log.e("mException", "BottomSheetView // does not set BottomSheetView to shows")
        }
    }
}

/*
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
 */

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