package com.cavss.realestatemanager.ui.view.progressbar

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ProgressCheckView(height : Dp) {
    val paddingValue = 40.dp
    val screenWidth = LocalConfiguration.current.screenWidthDp.dp
    val progressBarWidth = screenWidth - paddingValue
    val listSize = 20
    val progressBarBlock = progressBarWidth / listSize
    val currentIndex = remember { mutableStateOf(1) }
    Box(
        modifier = Modifier
            .padding(
                vertical = 5.dp,
                horizontal = paddingValue / 2
            )
            .width(progressBarWidth)
            .height(height = height)
            .clickable {
                currentIndex.value ++
            }
    ) {
        Text(
            text = "✍🏻",
            fontSize = 40.sp,
            textAlign = TextAlign.Start,
            modifier = Modifier
                .size(progressBarWidth, height)
//                .offset(x = progressBarBlock * currentIndex.value)
        )
    }
}