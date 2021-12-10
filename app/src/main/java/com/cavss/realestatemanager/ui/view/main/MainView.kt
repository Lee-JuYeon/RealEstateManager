package com.cavss.realestatemanager.ui.view.main

import androidx.activity.viewModels
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.cavss.realestatemanager.R
import com.cavss.realestatemanager.ui.custom.popup.PopUpVM
import com.cavss.realestatemanager.ui.custom.topbar.TopBarVM
import com.cavss.realestatemanager.ui.custom.topbar.TopBarView
import com.cavss.realestatemanager.ui.view.banner.BannerView
import com.cavss.realestatemanager.ui.view.checklist.CheckListView
import com.cavss.realestatemanager.vm.CheckListVM
import com.cavss.realestatemanager.vm.MainVM

@Composable
fun MainView(
    mainVM : MainVM,
    popupVM : PopUpVM,
    checkListVM : CheckListVM
) {

    val heightBlock = LocalConfiguration.current.screenHeightDp.dp / 20

    val topbarVM : TopBarVM = viewModel()

    Column(
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.Start,
        modifier = Modifier
            .fillMaxSize()
            .background(colorResource(id = R.color.background))
    ) {
        // Top Bar 뷰
        TopBarView(
            height = heightBlock * 1,
            topbarVM = topbarVM,
            popupVM = popupVM
        )

        // 실제 뷰
        CheckListView(
            checkListVM = checkListVM,
            heightBlock = heightBlock * 16
        )

        // 배너뷰
        BannerView(
            height = heightBlock * 3
        )
    }
}