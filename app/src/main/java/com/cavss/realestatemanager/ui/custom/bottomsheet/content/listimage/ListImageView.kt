package com.cavss.realestatemanager.ui.custom.bottomsheet.content.listimage

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.cavss.realestatemanager.R

@Composable
fun ListImageView(

) {
    val imageURL = listOf("1","2","3","4","5")
    Column(
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.Start,
        modifier = Modifier
    ) {
        Text(
            text = stringResource(id = R.string.checkList_watch_detail),
            color = Color.Black,
            fontSize = 30.sp,
            fontWeight = FontWeight.ExtraBold,
            modifier = Modifier
                .padding(
                    bottom = 15.dp
                )
        )
        LazyRow(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start,
            content = {
                items(imageURL){ image ->
                    Text(
                        text = image,
                        color = Color.Black,
                        fontSize = 30.sp,
                        fontWeight = FontWeight.ExtraBold,
                        modifier = Modifier
                            .padding(
                                1.dp
                            )
                            .size(
                                width = 300.dp,
                                height = 500.dp
                            )
                            .border(
                                1.dp,
                                Color.Black,
                                RectangleShape
                            )
                    )
                }
            }
        )
    }
}