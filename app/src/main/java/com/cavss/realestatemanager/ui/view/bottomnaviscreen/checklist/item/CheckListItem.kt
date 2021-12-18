package com.cavss.realestatemanager.ui.view.bottomnaviscreen.checklist.item

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.*
import androidx.compose.material.Divider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.cavss.realestatemanager.R
import com.cavss.realestatemanager.model.CheckListModel
import com.cavss.realestatemanager.ui.view.bottomnaviscreen.checklist.item.contents.*
import com.cavss.realestatemanager.vm.CheckListVM
import com.cavss.realestatemanager.vm.MainVM

@Composable
fun CheckListItem(
    model : CheckListModel,
    index : Int,
    checkListVM : CheckListVM,
    mainVM : MainVM
){
    val isExpandable = remember { mutableStateOf(false) }
    Column(
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.Start,
        modifier = Modifier
            .padding(vertical = 5.dp)
            .fillMaxWidth()
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
            ChecklistContentContainer(
                emoji = "✍🏻",
                title = stringResource(id = R.string.checkList_needToCheckTitle)
            ) {
                ChecklistContentViewNeedToCheck(relativeTricks = model.trick)
            }

            ChecklistContentContainer(
                emoji = "\uD83E\uDD14",
                title = stringResource(id = R.string.checkList_doubtSituationTitle)
            ) {
                ChecklistContentViewDoubtSituation(doubtSituation = model.doubtSituation)
            }

            ChecklistContentContainer(
                emoji = "📷",
                title = stringResource(id = R.string.checkList_imageTitle)
            ) {
                ChecklistContentViewImage(model.images, mainVM)
            }
        }
        Divider(
            color = Color.Black.copy(0.1f),
            modifier = Modifier
                .width(LocalConfiguration.current.screenWidthDp.dp - 20.dp)
        )
    }
}