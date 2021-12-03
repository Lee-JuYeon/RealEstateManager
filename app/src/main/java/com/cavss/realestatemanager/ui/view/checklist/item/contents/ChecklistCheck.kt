package com.cavss.realestatemanager.ui.view.checklist.item.contents

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.cavss.realestatemanager.R

@Composable
fun ChecklistCheck(
    check : String,
    isExpandable : MutableState<Boolean>
){

    val isChecked = remember { mutableStateOf(false) }
    val checkBoxSize = 50.dp

    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Start,
        modifier = Modifier
            .fillMaxWidth()
            .clickable {
                isExpandable.value = !isExpandable.value
            }
    ) {
        Box(
            modifier = Modifier
                .size(checkBoxSize, checkBoxSize)
                .clickable {
                    isChecked.value = !isChecked.value
                }
        ) {
            Box(
                modifier = Modifier
                    .size(checkBoxSize - 18.dp, checkBoxSize - 18.dp)
                    .clip(RoundedCornerShape(5.dp))
                    .border(
                        1.dp,
                        Color.Black,
                        RoundedCornerShape(5.dp)
                    )
                    .align(Alignment.Center)
            )
            if (isChecked.value){
                Icon(
                    imageVector = Icons.Filled.Check,
                    contentDescription = "Check" ,
                    modifier = Modifier
                        .align(Alignment.Center),
                    tint = colorResource(id = R.color.green)
                )
            }
        }

        Text(
            text = check,
            color = Color.Black,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .padding(
                    vertical = 5.dp
                )
        )
    }
}