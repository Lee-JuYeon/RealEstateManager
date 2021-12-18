package com.cavss.realestatemanager.ui.view.bottomnaviscreen.checklist

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.cavss.realestatemanager.R
import com.cavss.realestatemanager.model.CheckListModel
import com.cavss.realestatemanager.ui.view.bottomnaviscreen.checklist.item.CheckListItem
import com.cavss.realestatemanager.ui.custom.bottomnavi.OptionView
import com.cavss.realestatemanager.vm.CheckListVM
import com.cavss.realestatemanager.vm.MainVM

@Composable
fun CheckListView(
    mainVM : MainVM,
    checkListVM : CheckListVM,
    heightBlock : Dp
){
    LazyColumn(
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.Start,
        modifier = Modifier
            .background(Color.White)
            .height(heightBlock),
        content = {
            itemsIndexed(checkListVM.getCheckList.value ?: listOf()){ currentPosition : Int, model : CheckListModel->
                CheckListItem(
                    model = model,
                    index = currentPosition,
                    checkListVM = checkListVM,
                    mainVM = mainVM
                )
            }
        }
    )
}
