package com.cavss.realestatemanager.ui.custom.tablayout

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
fun TabLayoutBody(
    setNavController : NavHostController,
    setBodyModelList : List<TabLayoutModel>
) {

    NavHost(
        navController = setNavController,
        startDestination = TabLayoutModel.JEONSE.route
    ) {
        setBodyModelList.forEach { model ->
            composable(route = model.route) {
                Text(
                    text = stringResource(id = model.title),
                    color = Color.Black,
                    modifier = Modifier
                        .fillMaxSize()
                        .border(
                            1.dp,
                            Color.Black,
                            RectangleShape
                        )
                )
//                setBodyLayoutList
            }
        }
    }

}