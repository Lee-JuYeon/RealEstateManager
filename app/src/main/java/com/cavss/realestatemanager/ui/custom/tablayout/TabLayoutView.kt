package com.cavss.realestatemanager.ui.custom.tablayout

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import androidx.navigation.compose.rememberNavController

@Composable
fun TabLayoutView(
    setTabLayoutModelList : List<TabLayoutModel>,
    setHeight : Dp,
    setExtraLayout : @Composable () -> Unit
) {
    val navController = rememberNavController()
    Column(
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxWidth()
            .height(setHeight)
    ) {
        setExtraLayout()

        TabLayoutHeaader(
            setNavController = navController,
            setTabLayoutModelList = setTabLayoutModelList
        )
        TabLayoutBody(
            setNavController = navController,
            setBodyModelList = setTabLayoutModelList
        )
    }
}