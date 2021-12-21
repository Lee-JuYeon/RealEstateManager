package com.cavss.realestatemanager.ui.custom.adview

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.cavss.realestatemanager.R
import com.cavss.realestatemanager.model.type.CustomAdViewType
import com.cavss.realestatemanager.util.internet.InternetManager

@Composable
fun CustomAdView(
    height : Dp,
    location : String?,
    typeCustom : CustomAdViewType
) {
    // 인터넷 연결 체크
    val internetManager = InternetManager(LocalContext.current)
    when(internetManager.value){
        true -> {
            when(typeCustom){
                CustomAdViewType.CONTACT -> {
                    Text(
                        text = stringResource(id = R.string.adview_requestAD),
                        fontWeight = FontWeight.ExtraBold,
                        color = Color.Black,
                        textAlign = TextAlign.Center,
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(height)
                            .border(
                                1.dp,
                                Color.Black
                            )
                            .clickable {

                            }
                    )
                }
                CustomAdViewType.IMAGE -> {
                    Text(
                        text = "이미지광고",
                        fontSize = 20.sp,
                        color = Color.Black,
                        textAlign = TextAlign.Center,
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(height)
                            .border(
                                1.dp,
                                Color.Black
                            )
                            .clickable {

                            }
                    )
                }
                CustomAdViewType.GIF -> {
                    Text(
                        text = "GIF광고",
                        fontSize = 20.sp,
                        color = Color.Black,
                        textAlign = TextAlign.Center,
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(height)
                            .border(
                                1.dp,
                                Color.Black
                            )
                            .clickable {

                            }
                    )
                }
            }
        }
        false -> {
            Text(
                text = stringResource(id = R.string.adview_requestAD),
                color = Color.Black,
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.ExtraBold,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(height)
                    .border(
                        1.dp,
                        Color.Black
                    )
            )
        }
    }
}