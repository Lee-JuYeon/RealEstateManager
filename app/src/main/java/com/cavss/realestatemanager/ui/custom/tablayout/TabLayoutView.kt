package com.cavss.realestatemanager.ui.custom.tablayout

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import com.cavss.realestatemanager.model.TabLayoutModel
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.PagerScope
import com.google.accompanist.pager.rememberPagerState

@OptIn(ExperimentalPagerApi::class)
@Composable
fun TabLayoutView(
    setHeight : Dp,
    setExtraLayout : @Composable () -> Unit,
    setTabHeaderList : List<TabLayoutModel>,
    setTabHeaderBackgroundColour : Color,
    setTabHeaderIndicatorColour : Color,
    setTabHeaderLayout :  @Composable (Modifier, Boolean, TabLayoutModel) -> Unit,
    setTabBodyScrollable : Boolean,
    setTabBodyLayout : @Composable PagerScope.(page: Int) -> Unit
) {
    val pageState = rememberPagerState(pageCount = setTabHeaderList.size)
    Column(
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxWidth()
            .height(setHeight)
    ) {
        setExtraLayout()

        TabLayoutHeaader(
            setPagerState = pageState,
            setBackgroundColor = setTabHeaderBackgroundColour,
            setIndicatorColor = setTabHeaderIndicatorColour,
            setTabHeaderList = setTabHeaderList,
            setTabHeaderLayout = { clickEvent : Modifier, isClicked : Boolean, model : TabLayoutModel ->
                setTabHeaderLayout(clickEvent, isClicked, model)
            }
        )

        TabLayoutBody(
            setPagerState = pageState,
            setScrollable = setTabBodyScrollable
        ) {
            setTabBodyLayout(this.currentPage)
        }
    }
}