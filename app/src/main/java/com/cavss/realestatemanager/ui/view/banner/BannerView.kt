package com.cavss.realestatemanager.ui.view.banner

import android.Manifest
import android.util.Log
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.Observer
import com.cavss.realestatemanager.R
import com.cavss.realestatemanager.ui.custom.adview.CustomAdView
import com.cavss.realestatemanager.ui.custom.adview.CustomAdViewType
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
            )
        },
        grantedView = {
            val internetManager = InternetManager(LocalContext.current)
            internetManager.observe(LocalLifecycleOwner.current){ isConnect ->
//                Log.e("mException", "is connection ? : ${isConnect}")
            }

            if (internetManager.value == true){
                Text(
                    text = "연결연결",
                    color = Color.Black,
                    fontWeight = FontWeight.ExtraBold,
                    fontSize = 25.sp,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(height)
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
                )
            }
//            if (internetManager.observeAsState().value != false){
//                CustomAdView(
//                    height = height,
//                    location = null,
//                    typeCustom = CustomAdViewType.IMAGE
//                )
//            }else{
//                Text(
//                    text = stringResource(id = R.string.adview_noInternet),
//                    color = Color.Black,
//                    fontWeight = FontWeight.ExtraBold,
//                    fontSize = 25.sp,
//                    textAlign = TextAlign.Center,
//                    modifier = Modifier
//                        .fillMaxWidth()
//                        .height(height)
//                )
//            }
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
            )
        }
    )
}