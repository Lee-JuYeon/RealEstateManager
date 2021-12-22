package com.cavss.realestatemanager.ui.view.main.notify

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldColors
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.cavss.realestatemanager.R
import com.cavss.realestatemanager.vm.NotifyVM

@Composable
fun NotifyView(
    setHeight : Dp,
    setNotifyVM : NotifyVM
) {
    LazyColumn(
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.Start,
        modifier = Modifier
            .fillMaxWidth()
            .height(setHeight)
            .padding(
                top = 20.dp,
                start = 20.dp,
                end = 20.dp
            )
    ) {
        item {
            val textState = remember { mutableStateOf(TextFieldValue()) }
            val cornerRadius = 20.dp
            Column(
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.Start,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(
                        horizontal = 10.dp,
                        vertical = 10.dp
                    )
            ) {
                Text(
                    text = stringResource(id = R.string.notify_ask),
                    color = Color.Black,
                    fontSize = 45.sp,
                    fontWeight = FontWeight.ExtraBold,
                    textAlign = TextAlign.Start,
                    modifier = Modifier
                )

                TextField(
                    value = textState.value,
                    onValueChange = {
                        textState.value = it
                    },
                    label = {
                            Text(
                                text = stringResource(id = R.string.notify_hint),
                                color = Color.Black.copy(0.5f)
                            )
                    },
                    textStyle = TextStyle(
                        color = Color.Black,
                        fontWeight = FontWeight.Bold,
                        fontSize = 20.sp
                    ),
                    colors = TextFieldDefaults.textFieldColors(
                        backgroundColor = colorResource(id = R.color.thickYellow),
                        cursorColor = Color.Transparent,
                        focusedIndicatorColor = Color.Transparent
                    ),
                    modifier = Modifier
                        .padding(
                            top = 30.dp
                        )
                        .fillMaxWidth()
                        .clip(
                            RoundedCornerShape(
                                topEnd = cornerRadius,
                                topStart = cornerRadius
                            )
                        )
                        .border(
                            1.dp,
                            colorResource(id = R.color.green),
                            RoundedCornerShape(
                                topEnd = cornerRadius,
                                topStart = cornerRadius
                            )
                        )
                )

                Text(
                    text = stringResource(id = R.string.notify_send),
                    color = Color.White,
                    fontSize = 30.sp,
                    fontWeight = FontWeight.ExtraBold,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(
                            RoundedCornerShape(
                                bottomStart = cornerRadius,
                                bottomEnd = cornerRadius
                            )
                        )
                        .background(colorResource(id = R.color.carrot))
                        .border(
                            1.dp,
                            colorResource(id = R.color.green),
                            RoundedCornerShape(
                                bottomStart = cornerRadius,
                                bottomEnd = cornerRadius
                            )
                        )
                        .padding(
                            vertical = 10.dp
                        )
                        .clickable {
                            textState.value.text
                        }
                )
            }
        }

        item {
            Text(
                text = stringResource(id = R.string.notify_notification_title),
                color = Color.Black,
                fontSize = 45.sp,
                fontWeight = FontWeight.ExtraBold,
                textAlign = TextAlign.Start,
                modifier = Modifier
                    .padding(
                        top = 40.dp,
                        bottom = 20.dp
                    )
            )
        }
        items(setNotifyVM.getNotifyList.value ?: listOf()){ item ->
            NotifyItemView(setModel = item)
        }
    }
}