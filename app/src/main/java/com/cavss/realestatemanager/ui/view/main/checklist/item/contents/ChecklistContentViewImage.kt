package com.cavss.realestatemanager.ui.view.main.checklist.item.contents

import android.util.Log
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
import com.cavss.realestatemanager.ui.custom.bottomsheet.BottomSheetType
import com.cavss.realestatemanager.ui.custom.bottomsheet.BottomSheetVM
import com.cavss.realestatemanager.vm.MainVM

/*
TODO : 이미지를 더블클릭해야 바텀시트가 올라감
 */

@Composable
fun ChecklistContentViewImage(
    images : List<String>,
    setBottomSheetVM : BottomSheetVM
) {
    LazyRow(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Start,
        modifier = Modifier
            .clickable {
                try {
                    setBottomSheetVM.let {
                        it.setBottomSheetType(BottomSheetType.CHECKLIST_PICTURES)
                        it.setBottomSheetShows(true)
                    }
                }catch (e:Exception){
                    Log.e("mException", "ChecklistContentViewImage, while clicking // Exception : ${e.message}")
                }finally {
                    Log.e("mException", "ChecklistContentViewImage, clicked ")
                }
            }
            .padding(
                start = 30.dp,
                end = 5.dp
            )
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
            )
        }
    }
}