package com.cavss.realestatemanager.ui.custom.progressbar

import android.util.Log
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.cavss.realestatemanager.vm.CheckListVM

@Composable
fun ProgressCheckView(
    height : Dp,
    checkListVM : CheckListVM
) {
    val paddingValue = 40.dp
    val screenWidth = LocalConfiguration.current.screenWidthDp.dp
    val screenWidthByInt = LocalConfiguration.current.screenWidthDp
    val progressBarWidth = screenWidth - paddingValue

    val checkDistance = (checkListVM.getCheckItem.value.filter { it }.size * 40).dp
    Box(
        modifier = Modifier
            .padding(
                vertical = 5.dp,
                horizontal = paddingValue / 2
            )
            .width(progressBarWidth)
            .height(height = height)
            .animateContentSize(
                animationSpec = tween(
                    durationMillis = 200,
                    easing = LinearEasing
                )
            )
            .clickable {
                Log.e("mException", "true list : ${checkListVM.getCheckItem.value.filter { it }}")
            }
    ) {
        Row(
            verticalAlignment = Alignment.Bottom,
            horizontalArrangement = Arrangement.Start,
            modifier = Modifier
        ) {

//            if (checkListVM.getCheckItem.value.filter { it }.size == 0){
//                Text(
//                    text = "_90%",
//                    fontSize = 20.sp,
//                    color = Color.Black,
//                    modifier = Modifier
//                )
//            }

            Text(
                text = "✍🏻",
                fontSize = 40.sp,
                textAlign = TextAlign.End,
                modifier = Modifier
                    .size(height, height)
                    .offset(
                        x = checkDistance
                    )
            )
        }
    }
}