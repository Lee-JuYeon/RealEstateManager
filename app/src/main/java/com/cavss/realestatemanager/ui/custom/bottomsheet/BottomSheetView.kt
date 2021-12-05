package com.cavss.realestatemanager.ui.custom.bottomsheet

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.dp
import com.cavss.realestatemanager.vm.MainVm

@Composable
fun BottomSheetView(mainVM : MainVm) {

    val screenSize = LocalConfiguration.current
    val screenWidth = screenSize.screenWidthDp.dp
    val screenHeight = screenSize.screenHeightDp.dp

    val showBottomSheet = remember { mutableStateOf(false) }

    if (showBottomSheet.value){
        Column(
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .size(
                    width = screenWidth,
                    height = screenHeight
                )
                .background(Color.Yellow.copy(0.5f))
                .border(
                    1.dp,
                    Color.Red,
                    RectangleShape
                )
        ) {

        }
    }
}