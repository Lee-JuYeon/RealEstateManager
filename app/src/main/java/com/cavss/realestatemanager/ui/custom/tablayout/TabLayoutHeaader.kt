package com.cavss.realestatemanager.ui.custom.tablayout

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import com.cavss.realestatemanager.R
import com.cavss.realestatemanager.ui.custom.bottomnavi.BottomNaviItemView
import com.cavss.realestatemanager.ui.custom.bottomnavi.BottomNaviModel

@Composable
fun TabLayoutHeaader(
    setNavController : NavHostController,
    setTabLayoutModelList : List<TabLayoutModel>
) {
    LazyRow(
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth(),
        content = {
            items(setTabLayoutModelList){ model : TabLayoutModel ->
                Text(
                    text = stringResource(id = model.title),
                    color = Color.White,
                    fontWeight = if (setNavController.currentDestination?.route == model.route) {
                        FontWeight.ExtraBold
                    } else {
                        FontWeight.Bold
                    },
                    fontSize = 20.sp,
                    modifier = Modifier
                        .padding(
                            vertical = 5.dp
                        )
                        .clip(
                            RoundedCornerShape(10.dp)
                        )
                        .background(colorResource(id = R.color.opacityGreen))
                        .padding(
                            start = 10.dp,
                            end = 10.dp,
                            top = 5.dp,
                            bottom = 5.dp
                        )
                        .clickable {
                            setNavController.navigate(model.route){
                                popUpTo(setNavController.graph.findStartDestination().id)
                                launchSingleTop = true
                            }
                        }
                )
            }
        }
    )
}