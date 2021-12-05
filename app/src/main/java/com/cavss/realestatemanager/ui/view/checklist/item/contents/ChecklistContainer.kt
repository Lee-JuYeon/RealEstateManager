package com.cavss.realestatemanager.ui.view.checklist.item.contents

import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.cavss.realestatemanager.R

@Composable
fun ChecklistContainer(
    emoji : String,
    title : String,
    content : @Composable () -> Unit
) {

    Column(
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.Start,
        modifier = Modifier
            .padding(
                start = 10.dp,
                end = 5.dp,
                bottom = 10.dp
            )
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start,
            modifier = Modifier
        ) {

            Text(
                text = emoji,
                fontSize = 23.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black,
                modifier = Modifier
                    .size(30.dp, 30.dp)
            )

            Text(
                text = title,
                fontSize = 23.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black,
                modifier = Modifier
                    .height(30.dp)
            )
        }

        content()
    }
}