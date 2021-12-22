package com.cavss.realestatemanager.ui.view.main.checklist.item.contents

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.cavss.realestatemanager.model.type.PopUpType
import com.cavss.realestatemanager.vm.MainVM

@Composable
fun ChecklistContentViewImage(
    images : List<String>,
    mainVM : MainVM
) {
    val showBottomSheet = remember { mutableStateOf(false) }
    LazyRow(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Start,
        modifier = Modifier
            .padding(
                start = 30.dp,
                end = 5.dp
            )
            .clickable {

            }
    ){
        items(images){ image ->
            Text(
                text = image,
                modifier = Modifier
                    .padding(end = 5.dp)
                    .size(
                        85.dp, 100.dp
                    )
                    .clip(RoundedCornerShape(5.dp))
                    .border(
                        1.dp,
                        Color.Black,
                        RoundedCornerShape(5.dp)
                    )
                    .clickable {
                        showBottomSheet.value = !showBottomSheet.value
                        mainVM.setCheckListImages(images)
                        mainVM.setBottomSheetShows(true)
                        mainVM.setBottomSheetType(PopUpType.CHECKLIST_ITEM_IMAGE)
                    }
            )
        }
    }
}