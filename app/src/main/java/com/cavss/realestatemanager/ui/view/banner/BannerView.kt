package com.cavss.realestatemanager.ui.view.banner

import android.Manifest
import android.util.Log
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.cavss.realestatemanager.R
import com.cavss.realestatemanager.util.internet.InternetManager
import com.cavss.realestatemanager.util.permission.PermissionRequestView

@Composable
fun BannerView(height : Dp) {
    PermissionRequestView(
        permissionList = listOf(
            Manifest.permission.INTERNET,
            Manifest.permission.ACCESS_NETWORK_STATE
        ),
        requestNowView = { customModifier : Modifier ->
            Text(
                text = stringResource(id = R.string.permission_requestNow),
                color = Color.Black,
                fontWeight = FontWeight.ExtraBold,
                fontSize = 25.sp,
                textAlign = TextAlign.Center,
                modifier = customModifier
                    .fillMaxWidth()
                    .height(height)
                    .border(
                        1.dp,
                        Color.Black,
                        RectangleShape
                    )
            )
        },
        requestLaterView = { customModifier : Modifier ->
            Text(
                text = stringResource(id = R.string.permission_requestLater),
                color = Color.Black,
                fontWeight = FontWeight.ExtraBold,
                fontSize = 25.sp,
                textAlign = TextAlign.Center,
                modifier = customModifier
                    .fillMaxWidth()
                    .height(height)
                    .border(
                        1.dp,
                        Color.Black,
                        RectangleShape
                    )
            )
        },
        canNotUseView = {
            Text(
                text = stringResource(id = R.string.permission_unknownError),
                color = Color.Black,
                fontWeight = FontWeight.ExtraBold,
                fontSize = 25.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(height)
                    .border(
                        1.dp,
                        Color.Black,
                        RectangleShape
                    )
                    .clickable {
                        // 인터넷없음 광고문의 팝업뷰
                    }
            )
        },
        grantedView = {
            val isNetworking = remember { mutableStateOf(false) }
            val internetManager = InternetManager(LocalContext.current)
            internetManager.observe(LocalLifecycleOwner.current){ isConnect ->
                isNetworking.value = isConnect
            }

            if (isNetworking.value){
                Text(
                    text = "연결연결",
                    color = Color.Black,
                    fontWeight = FontWeight.ExtraBold,
                    fontSize = 25.sp,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(height)
                        .border(
                            1.dp,
                            Color.Black,
                            RectangleShape
                        )
                        .clickable {
                            // 광고문의 + 광고 팝업뷰 생성
                        }
                )
            }else{
                Text(
                    text = stringResource(id = R.string.adview_noInternet),
                    color = Color.Black,
                    fontWeight = FontWeight.ExtraBold,
                    fontSize = 25.sp,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(height)
                        .border(
                            1.dp,
                            Color.Black,
                            RectangleShape
                        )
                        .clickable {
                            // 인터넷없음 광고문의 팝업뷰
                        }
                )
            }
        },
        deniedView = { deniedReason : String ->
            Text(
                text = deniedReason,
                color = Color.Black,
                fontWeight = FontWeight.ExtraBold,
                fontSize = 25.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(height)
                    .border(
                        1.dp,
                        Color.Black,
                        RectangleShape
                    )
            )
        }
    )
}