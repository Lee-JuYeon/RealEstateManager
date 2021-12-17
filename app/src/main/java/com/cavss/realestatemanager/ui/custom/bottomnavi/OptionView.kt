package com.cavss.realestatemanager.ui.custom.bottomnavi

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.cavss.realestatemanager.R

@Composable
fun OptionView(
    height : Dp
){

    LazyRow(
        horizontalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxWidth()
            .height(height),
        content ={
            items(OptionModel.OPTION_LIST.list){ item ->
                Text(
                    text = stringResource(id = item.inNative),
                    color = Color.White,
                    fontSize = 18.sp,
                    modifier = Modifier
                        .padding(
                            vertical = 5.dp,
                            horizontal = 10.dp
                        )
                        .clip(RoundedCornerShape(10.dp))
                        .background(colorResource(id = R.color.opacityGreen))
                        .border(
                            1.dp,
                            Color.White,
                            RoundedCornerShape(10.dp)
                        )
                        .padding(
                            vertical = 5.dp,
                            horizontal = 10.dp
                        )
                        .clickable {

                        },
                )
            }
        })
}