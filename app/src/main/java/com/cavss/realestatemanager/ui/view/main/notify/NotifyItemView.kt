package com.cavss.realestatemanager.ui.view.main.notify

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.cavss.realestatemanager.R

@Composable
fun NotifyItemView(
    setModel : NotifyModel
) {
    val isExpandable = remember { mutableStateOf(false) }

    Column(
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.Start,
        modifier = Modifier
            .padding(all = 5.dp)
            .fillMaxWidth()
            .animateContentSize(
                animationSpec = tween(
                    durationMillis = 200,
                    easing = LinearEasing
                )
            )
            .border(
                1.dp,
                Color.Black,
                RoundedCornerShape(10.dp)
            )
            .padding(all = 10.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Text(
                text = setModel.notifyTitle,
                color = Color.Black,
                fontWeight = FontWeight.Bold,
                fontSize = 25.sp,
                modifier = Modifier
            )

            Image(
                painterResource(id = if (isExpandable.value) R.drawable.image_down else R.drawable.image_up),
                contentDescription = "확장버튼",
                modifier = Modifier
                    .clickable {
                        isExpandable.value = !isExpandable.value
                    }
                    .size(
                        width = 30.dp,
                        height = 30.dp
                    )
            )
        }

        if (isExpandable.value){
            Text(
                text = setModel.notifyDescription,
                textAlign = TextAlign.Start,
                color = Color.Black,
                fontSize = 20.sp,
                fontWeight = FontWeight.SemiBold,
                modifier = Modifier
                    .padding(
                        top = 10.dp,
                        start = 10.dp,
                        end = 10.dp
                    )
            )
            Text(
                text = setModel.notifyUpdateDate,
                textAlign = TextAlign.End,
                color = Color.Black,
                fontSize = 18.sp,
                fontWeight = FontWeight.SemiBold,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(
                        horizontal = 10.dp
                    )
            )
        }
    }
}