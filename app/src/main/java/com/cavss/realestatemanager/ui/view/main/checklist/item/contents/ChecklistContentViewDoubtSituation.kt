package com.cavss.realestatemanager.ui.view.main.checklist.item.contents

import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ChecklistContentViewDoubtSituation(doubtSituation : List<String>) {

    Column(
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.Start,
        modifier = Modifier
            .padding(
                start = 30.dp,
                end = 5.dp
            )
    ) {
        doubtSituation.forEachIndexed { index : Int, situation : String->
            Text(
                text = "${index + 1}. ${situation}",
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp,
                color = Color.Black,
                modifier = Modifier
                    .padding(
                        top = 3.dp
                    )
            )
        }
    }
}