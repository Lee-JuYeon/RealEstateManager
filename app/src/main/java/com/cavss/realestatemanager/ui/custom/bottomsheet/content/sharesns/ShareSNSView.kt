package com.cavss.realestatemanager.ui.custom.bottomsheet.content.sharesns

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.cavss.realestatemanager.R

@Composable
fun ShareSNSView() {
    val sellectedLanguage = remember { mutableStateOf(ShareSNSLangType.KOREAN) }

    val shareAppList = ShareSNSItemModel.LIST.list
    Column(
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.Start,
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Text(
            text = stringResource(id = R.string.share_where_title),
            color = Color.Black,
            fontSize = 35.sp,
            fontWeight = FontWeight.ExtraBold,
            modifier = Modifier
                .padding(
                    bottom = 20.dp
                )
        )

        LazyRow(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth(),
            content = {
                items(shareAppList){ model ->
                    Image(
                        painter = painterResource(id = model.appImage),
                        
                        contentDescription = "앱 이미지",
                        modifier = Modifier
                            .padding(horizontal = 2.dp)
                            .size(60.dp, 60.dp)
                            .clip(CircleShape)
                            .border(
                                1.dp,
                                Color.White,
                                CircleShape
                            )
                            .background(
                                when (model.appType) {
                                    ShareSNSType.KAKAOTALK -> colorResource(id = R.color.colour_kakaotalk)
                                    ShareSNSType.WHATSAPP -> colorResource(id = R.color.colour_whatsapp)
                                    ShareSNSType.LINE -> colorResource(id = R.color.colour_line)
                                    ShareSNSType.TELEGRAM -> colorResource(id = R.color.colour_telegram)
                                    ShareSNSType.FACEBOOK -> Color.White
                                    ShareSNSType.INSTAGRAM -> Color.White
                                }
                            )
                            .padding(all = 10.dp)
                            .clickable {
                                when (model.appType) {
                                    ShareSNSType.KAKAOTALK -> {
                                    }
                                    ShareSNSType.WHATSAPP -> {
                                    }
                                    ShareSNSType.LINE -> {
                                    }
                                    ShareSNSType.TELEGRAM -> {
                                    }
                                    ShareSNSType.FACEBOOK -> {
                                    }
                                    ShareSNSType.INSTAGRAM -> {
                                    }
                                }
                            }
                    )
                }
            }
        )

        Text(
            text = stringResource(id = R.string.share_sellect_language),
            color = Color.Black,
            fontSize = 35.sp,
            fontWeight = FontWeight.ExtraBold,
            modifier = Modifier
                .padding(
                    top = 20.dp,
                    bottom = 10.dp
                )
        )

        LazyRow(
            content = {
                val languageList = listOf(
                    ShareSNSLangType.KOREAN,
                    ShareSNSLangType.ENGlISH,
                    ShareSNSLangType.ESPANOL
                )

                items(languageList){ language ->
                    Text(
                        text = language.rawValue,
                        color = Color.Black,
                        fontSize = 25.sp,
                        fontWeight = FontWeight.SemiBold,
                        modifier = Modifier
                            .padding(
                                vertical = 3.dp,
                                horizontal = 8.dp
                            )
                            .clip(
                                RoundedCornerShape(10.dp)
                            )
                            .border(
                                1.dp,
                                if (sellectedLanguage.value == language){
                                    Color.Black
                                }else{
                                    Color.White
                                },
                                RoundedCornerShape(10.dp)
                            )
                            .background(Color.White)
                            .padding(
                                vertical = 3.dp,
                                horizontal = 8.dp
                            )
                            .clickable {
                                sellectedLanguage.value = language
                            }
                    )
                }
            }
        )
    }
}