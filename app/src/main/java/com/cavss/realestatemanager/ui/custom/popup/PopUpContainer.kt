package com.cavss.realestatemanager.ui.custom.popup

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Popup
import androidx.compose.ui.window.isPopupLayout

@Composable
fun PopUpContainer(
    popupVM : PopUpVM
) {
    val isShowing = remember { mutableStateOf(false) }
    if (isShowing.value == false){
        when(popupVM.getPopUpType.value) {
            PopUpType.ADVIEW_REQUEST -> {

            }
            PopUpType.ADVIEW_IMAGE -> {

            }
            PopUpType.ADVIEW_VIDEO -> {

            }
            PopUpType.TOPBAR_NOTIFY -> {

            }
            PopUpType.TOPBAR_CONTACT -> {

            }
            PopUpType.CHECKLIST_ITEM_IMAGE -> {
함
            }
            PopUpType.NONE -> {
                Log.e("mException","${popupVM.getPopUpType.value} : none")
                Popup(alignment = Alignment.Center) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Start,
                        modifier = Modifier
                    ) {
                        Text(
                            text = "test iamge",
                            color = Color.Black,
                            fontSize = 40.sp,
                            modifier = Modifier
                                .size(
                                    200.dp, 300.dp
                                )
                                .background(Color.Green)
                                .border(
                                    1.dp,
                                    Color.Black,
                                    RectangleShape
                                )
                                .clickable {
                                    isShowing.value = !isShowing.value
                                }
                        )
                    }
                }
            }
        }
    }
}