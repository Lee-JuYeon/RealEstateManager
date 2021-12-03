package com.cavss.realestatemanager.ui.view.checklist.item.contents

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

@Composable
fun ChecklistDoubtSituation(doubtSituation : List<String>) {

    LazyColumn(
        modifier = Modifier
            .fillMaxWidth()
    ) {
//        item {
//            Text(
//                text = "의심되는 부분",
//                fontSize = 25.sp,
//                fontWeight = FontWeight.Bold,
//                color = Color.Black,
//                modifier = Modifier
//            )
//        }
        items(doubtSituation){ situation ->
            Text(
                text = situation,
                fontWeight = FontWeight.SemiBold,
                fontSize = 18.sp,
                color = Color.Black
            )
        }
    }
}