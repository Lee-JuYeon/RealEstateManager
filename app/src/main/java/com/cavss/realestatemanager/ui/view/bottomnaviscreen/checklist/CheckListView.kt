package com.cavss.realestatemanager.ui.view.bottomnaviscreen.checklist

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.cavss.realestatemanager.model.CheckListModel
import com.cavss.realestatemanager.model.type.CheckListType
import com.cavss.realestatemanager.ui.view.bottomnaviscreen.checklist.item.CheckListItem
import com.cavss.realestatemanager.util.checklist.CheckListData
import com.cavss.realestatemanager.vm.CheckListVM
import com.cavss.realestatemanager.vm.MainVM

@Composable
fun CheckListView(
    setMainVM : MainVM,
    setCheckListVM : CheckListVM,
    setType : CheckListType
){
    val typeFilteredCheckList : List<CheckListModel> = when(setType){
        CheckListType.BUY -> {
            CheckListData.CHECKLIST_BUY
        }
        CheckListType.JEONSE -> {
            CheckListData.CHECKLIST_JEONSE
        }
        CheckListType.MONTHLY_RENT -> {
            CheckListData.CHECKLIST_MONTHLYRENT
        }
    }
    LazyColumn(
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.Start,
        modifier = Modifier
            .background(Color.White)
            .fillMaxHeight(),
        content = {
            itemsIndexed(typeFilteredCheckList){ currentPosition : Int, model : CheckListModel->
                CheckListItem(
                    model = model,
                    index = currentPosition,
                    checkListVM = setCheckListVM,
                    mainVM = setMainVM
                )
            }
        }
    )
}
