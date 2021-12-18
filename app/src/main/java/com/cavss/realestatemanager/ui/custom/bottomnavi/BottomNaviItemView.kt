package com.cavss.realestatemanager.ui.custom.bottomnavi

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController


@Composable
fun BottomNaviItemView(
    setModel : BottomNaviModel,
    setColour : Color,
    setNavController : NavHostController
){
    Row(
        modifier= Modifier
            .clip(RoundedCornerShape(corner = CornerSize(10.dp)))
            .background(
                if (setNavController.currentDestination?.route == setModel.type.rawValue) {
                    Color.Green.copy(alpha = 0.1f)
                } else {
                    Color.Transparent
                }
            )
            .clickable {
                when (setModel.type) {
                    BottomNaviType.CHECKLIST -> {
                        setNavController.navigate(setModel.type.rawValue){
                            popUpTo(setNavController.graph.findStartDestination().id)
                            launchSingleTop = true
                        }
                    }
                    BottomNaviType.NOTIFY -> {
                        setNavController.navigate(setModel.type.rawValue){
                            popUpTo(setNavController.graph.findStartDestination().id)
                            launchSingleTop = true
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
            .padding(10.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {

        Image(
            painter = painterResource(id = setModel.icon),
            contentDescription = "이미지",
            contentScale = ContentScale.Crop,
            modifier = Modifier
        )

        if (setNavController.currentDestination?.route == setModel.type.rawValue){
            Text(
                text = stringResource(id = setModel.nativeTitle),
                color = setColour,
                fontSize = 25.sp,
                fontWeight = FontWeight.ExtraBold,
                modifier = Modifier
                    .padding(horizontal = 5.dp)
            )
        }
    }
}