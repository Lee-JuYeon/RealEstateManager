package com.cavss.realestatemanager.ui.view.checklist

import android.Manifest
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.cavss.realestatemanager.R
import com.cavss.realestatemanager.model.CheckListModel
import com.cavss.realestatemanager.ui.custom.adview.CustomAdView
import com.cavss.realestatemanager.ui.custom.adview.CustomAdViewType
import com.cavss.realestatemanager.ui.view.checklist.item.CheckListItem
import com.cavss.realestatemanager.ui.view.checklist.optionview.OptionView
import com.cavss.realestatemanager.ui.custom.progressbar.ProgressCheckView
import com.cavss.realestatemanager.ui.view.banner.BannerView
import com.cavss.realestatemanager.util.internet.InternetManager
import com.cavss.realestatemanager.util.permission.PermissionRequestView
import com.cavss.realestatemanager.vm.CheckListVM

@Composable
fun CheckListView(checkListVM : CheckListVM){
    val heightBlock = LocalConfiguration.current.screenHeightDp.dp / 20

    Column(
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.Start,
    ) {
        ProgressCheckView(
            height = heightBlock * 1,
            checkListVM = checkListVM
        )
        Text(
            text = stringResource(id = R.string.checkList_title),
            color = Color.Black,
            fontSize = 40.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .padding(
                    vertical = 5.dp,
                    horizontal = 20.dp
                )
                .height(height = heightBlock * 1)
        )
        OptionView(
            height = heightBlock * 1
        )
        LazyColumn(
            modifier = Modifier
                .background(Color.White)
                .height(heightBlock * 14),
            content = {
                itemsIndexed(checkListVM.getCheckList.value ?: listOf()){ currentPosition : Int, model : CheckListModel->
                    CheckListItem(
                        model = model,
                        index = currentPosition,
                        checkListVM = checkListVM
                    )
                }
            }
        )

        BannerView(height = heightBlock * 3)
    }
}
