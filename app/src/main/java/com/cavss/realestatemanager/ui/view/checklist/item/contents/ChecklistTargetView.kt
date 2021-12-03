package com.cavss.realestatemanager.ui.view.checklist.item.contents

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.cavss.realestatemanager.R

@Composable
fun ChecklistTargetView(targetList : List<String>){
    LazyRow(
        horizontalArrangement = Arrangement.Start,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .padding(
                start = 10.dp
            )
    ) {
        item {
            Text(
                text = stringResource(id = R.string.checkList_targetTitle),
                color = Color.Black,
                fontSize = 25.sp,
                fontWeight = FontWeight.ExtraBold
            )
        }
        items(targetList){ targets ->
            Text(
                text = targets,
                color = Color.Black,
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp,
                modifier = Modifier
                    .padding(
                        vertical = 5.dp,
                        horizontal = 10.dp
                    )
                    .clip(RoundedCornerShape(10.dp))
                    .border(
                        1.dp,
                        Color.White,
                        RoundedCornerShape(10.dp)
                    )
                    .background(colorResource(id = R.color.thickYellow))
                    .padding(
                        vertical = 5.dp,
                        horizontal = 10.dp
                    )
            )
        }
    }
}