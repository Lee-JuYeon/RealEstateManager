package com.cavss.realestatemanager.ui.custom.tablayout

import androidx.compose.foundation.clickable
import androidx.compose.material.TabRow
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.cavss.realestatemanager.model.TabLayoutModel
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.PagerState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@OptIn(ExperimentalPagerApi::class)
@Composable
fun TabLayoutHeaader(
    setPagerState : PagerState,
    setBackgroundColor : Color,
    setIndicatorColor : Color,
    setTabHeaderList : List<TabLayoutModel>,
    setTabHeaderLayout : @Composable (Modifier, Boolean, TabLayoutModel) -> Unit
) {

    val scope = rememberCoroutineScope()

    TabRow(
        selectedTabIndex = setPagerState.currentPage,
        backgroundColor = setBackgroundColor,
        contentColor = setIndicatorColor
    ) {
        setTabHeaderList.forEachIndexed { index, tabLayoutModel ->
            val selectedTab = setPagerState.currentPage == index
            setTabHeaderLayout(
                Modifier
                    .clickable {
                        scope.launch(Dispatchers.IO) {
                            setPagerState.scrollToPage(index)
                        }
                    },
                selectedTab,
                tabLayoutModel
            )
        }
    }
}