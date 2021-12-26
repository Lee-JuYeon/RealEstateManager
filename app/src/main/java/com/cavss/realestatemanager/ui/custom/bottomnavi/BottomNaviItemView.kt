package com.cavss.realestatemanager.ui.custom.bottomnavi

import android.util.Log
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import com.cavss.realestatemanager.model.BottomNaviModel
import com.cavss.realestatemanager.model.type.BottomNaviType
/*
TODO :
 1. navHostController 업데이트 관리
 2. light effect 마름모 구현
 */

@Composable
fun BottomNaviItemView(
    setModel : BottomNaviModel,
    setColour : Color,
    setNavController : NavHostController
){
    Box(
        modifier= Modifier
            .clickable {
                Log.e("mException","클릭 : ${setModel.type.rawValue} / 네비 : ${setNavController.currentDestination!!.route}")
                when (setModel.type) {
                    BottomNaviType.CHECKLIST -> {
                        setNavController.navigate(setModel.type.rawValue) {
//                            popUpTo(setNavController.graph.findStartDestination().id)
//                            launchSingleTop = false
                        }
                    }
                    BottomNaviType.NOTIFY -> {
                        setNavController.navigate(setModel.type.rawValue) {
//                            popUpTo(setNavController.graph.findStartDestination().id)
//                            launchSingleTop = false
                        }
                    }
                }
            }
            .animateContentSize(
                animationSpec = tween(
                    durationMillis = 200,
                    easing = LinearEasing
                )
            )
            .fillMaxHeight()
    ) {
        Text(
            text = stringResource(id = setModel.nativeTitle),
            color = setColour,
            fontSize = 25.sp,
            fontWeight = FontWeight.ExtraBold,
            modifier = Modifier
                .padding(horizontal = 5.dp)
                .align(Alignment.Center)
        )
        if (setNavController.currentDestination?.route == setModel.type.rawValue){
            Box(
                modifier = Modifier
                    .width((stringResource(id = setModel.nativeTitle).length * 15).dp)
                    .background(Color.White)
                    .height(5.dp)
                    .align(Alignment.BottomCenter)
            )
            Box(
                modifier = Modifier
                    .width((stringResource(id = setModel.nativeTitle).length * 20).dp)
                    .fillMaxHeight()
                    .background(
                        brush = Brush.verticalGradient(
                            colors = listOf(
                                Color.White.copy(0.0f),
                                Color.White.copy(0.0f),
                                Color.White.copy(0.1f),
                                Color.White.copy(0.1f),
                                Color.White.copy(0.2f),
                                Color.White.copy(0.2f),
                                Color.White.copy(0.3f)
                            )
                        )
                    )
                    .align(Alignment.Center)
            )
        }
    }
}