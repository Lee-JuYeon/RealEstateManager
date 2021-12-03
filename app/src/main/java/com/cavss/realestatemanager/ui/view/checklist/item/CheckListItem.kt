package com.cavss.realestatemanager.ui.view.checklist.item

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.unit.dp
import com.cavss.realestatemanager.model.CheckListModel
import com.cavss.realestatemanager.ui.view.checklist.item.contents.ChecklistCheck
import com.cavss.realestatemanager.ui.view.checklist.item.contents.ChecklistDoubtSituation
import com.cavss.realestatemanager.ui.view.checklist.item.contents.ChecklistTargetView

@Composable
fun CheckListItem(model : CheckListModel){
    val isExpandable = remember { mutableStateOf(false) }
    Column(
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.Start,
        modifier = Modifier
            .fillMaxWidth()
            .border(
                1.dp,
                Color.Black,
                RectangleShape
            )
            .padding(vertical = 5.dp)
            .animateContentSize(
                animationSpec = tween(
                    durationMillis = 200,
                    easing = LinearEasing
                )
            )
    ) {
        ChecklistCheck(
            check = model.check,
            isExpandable = isExpandable
        )

        if (isExpandable.value){
            ChecklistDoubtSituation(doubtSituation = model.doubtSituation)
            ChecklistTargetView(targetList = model.target)

        }
    }
}