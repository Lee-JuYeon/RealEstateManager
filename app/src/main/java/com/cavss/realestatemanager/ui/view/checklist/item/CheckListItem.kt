package com.cavss.realestatemanager.ui.view.checklist.item

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.cavss.realestatemanager.R
import com.cavss.realestatemanager.model.CheckListModel
import com.cavss.realestatemanager.ui.view.checklist.item.contents.*
import com.cavss.realestatemanager.vm.CheckListVM

@Composable
fun CheckListItem(
    model : CheckListModel,
    index : Int,
    checkListVM : CheckListVM
){
    val isExpandable = remember { mutableStateOf(false) }
    Column(
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.Start,
        modifier = Modifier
            .fillMaxWidth()
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
            isExpandable = isExpandable,
            checkListVM = checkListVM,
            index = index
        )

        if (isExpandable.value){
            ChecklistContainer(
                emoji = "\uD83E\uDD14",
                title = stringResource(id = R.string.checkList_doubtSituationTitle)
            ) {
                ChecklistDoubtSituation(doubtSituation = model.doubtSituation)
            }

            ChecklistContainer(
                emoji = "🦹🏻",
                title = stringResource(id = R.string.checkList_relativeTrickTitle)
            ) {
                ChecklistRelativeTrick(relativeTricks = model.trick)
            }

            ChecklistContainer(
                emoji = "\uD83C\uDFAF",
                title = stringResource(id = R.string.checkList_targetTitle)
            ) {
                ChecklistTargetView(targetList = model.target)
            }

            ChecklistContainer(
                emoji = "📷",
                title = stringResource(id = R.string.checkList_imageTitle)
            ) {
                ChecklistImage(model.images)
            }
        }
    }
}