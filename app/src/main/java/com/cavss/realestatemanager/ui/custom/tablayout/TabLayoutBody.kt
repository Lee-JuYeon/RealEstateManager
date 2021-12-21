package com.cavss.realestatemanager.ui.custom.tablayout

import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.cavss.realestatemanager.model.TabLayoutModel
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.PagerScope
import com.google.accompanist.pager.PagerState

@OptIn(ExperimentalPagerApi::class)
@Composable
fun TabLayoutBody(
    setPagerState : PagerState,
    setScrollable : Boolean,
    setBodyContent : @Composable PagerScope.(page: Int) -> Unit
) {
    HorizontalPager(
        state = setPagerState,
        dragEnabled = setScrollable,
        verticalAlignment = Alignment.Top,
        horizontalAlignment = Alignment.Start
    ) {
        setBodyContent(this.currentPage)
    }
}