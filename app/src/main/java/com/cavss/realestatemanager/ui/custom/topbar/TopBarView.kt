package com.cavss.realestatemanager.ui.custom.topbar

import android.content.Context
import android.util.Log
import android.view.WindowManager
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.cavss.realestatemanager.ui.custom.popup.PopUpType
import com.cavss.realestatemanager.ui.custom.popup.PopUpVM
import com.cavss.realestatemanager.vm.MainVM

@Composable
fun TopBarView(
    height : Dp,
    topbarVM : TopBarVM,
    popupVM : PopUpVM,
    backgroundColour : Color
) {

    val lifeCycleOwner = LocalLifecycleOwner.current

    Column(
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.Start,
        modifier = Modifier
            .background(backgroundColour.copy(0.1f))
    ) {
        LazyRow(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start,
            modifier = Modifier
                .height(height),
            content = {
                topbarVM.getTopBarList.observe(lifeCycleOwner){ list ->
                    items(list){ model ->
                        Text(
                            text = stringResource(id = model.itemTitle),
                            color = Color.Black,
                            fontWeight = FontWeight.ExtraBold,
                            fontSize = 25.sp,
                            modifier = Modifier
                                .fillMaxHeight()
                                .padding(
                                    horizontal = 10.dp,
                                    vertical = 5.dp
                                )
                                .clickable {
                                    when (model.itemType) {
                                        TopBarType.NOTIFY -> {
                                            Log.e("mException","topbar PopUpType.CHECKLIST_ITEM_IMAGE")
                                            popupVM.setPopUpType(PopUpType.CHECKLIST_ITEM_IMAGE)
                                        }
                                        TopBarType.CONTACTUS -> {
                                            popupVM.setPopUpType(PopUpType.TOPBAR_CONTACT)
                                        }
                                    }
                                }
                        )
                    }
                }
            }
        )
        Canvas(
            modifier = Modifier
                .fillMaxWidth()
                .height(1.dp),
            onDraw = {
                drawLine(
                    color = Color.Black,
                    start = Offset(x = 0f, y = 1f),
                    end = Offset(x = 900729f, y = 1f),
                    strokeWidth = 1f
                )
            }
        )
    }
}