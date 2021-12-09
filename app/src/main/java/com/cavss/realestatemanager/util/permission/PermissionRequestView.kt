package com.cavss.realestatemanager.util.permission

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.cavss.realestatemanager.R
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.PermissionState
import com.google.accompanist.permissions.rememberMultiplePermissionsState

enum class PermisstionRequestType {
    YES,
    NO
}

@OptIn(ExperimentalPermissionsApi::class)
@Composable
fun PermissionRequestView(
    permissionList : List<String>,
    requestNowView : @Composable (Modifier) -> Unit,
    requestLaterView : @Composable (Modifier) -> Unit,
    canNotUseView : @Composable () -> Unit,
    grantedView : @Composable () -> Unit,
    deniedView : @Composable (deniedPermissionList : String) -> Unit
) {
    val permissionsState = rememberMultiplePermissionsState(permissions = permissionList)
    when {
        // 권한이 이미 승낙 되어있는 상태
        permissionsState.allPermissionsGranted -> grantedView()

        // 승낙이 안되어 있는 권한 요청
        permissionsState.shouldShowRationale || !permissionsState.permissionRequested -> {
            //rememberSaveable = 값을 일시적으로 저장할 수 있는 메소드.
            var doNotShowRationale by rememberSaveable { mutableStateOf(false) }
            when(true){
                // 사용 불가능한 상태
                doNotShowRationale -> { canNotUseView() }

                // 권한 요청
                else -> {
                    requestNowView(
                        Modifier
                            .clickable {
                                permissionsState.launchMultiplePermissionRequest()
                            }
                    )
                    requestLaterView(
                        Modifier
                            .clickable {
                                doNotShowRationale = true
                            }
                    )
                }
            }
        }

        // 권한이 거절 되어있는 상태 (알 수 없는 이유)
        else -> {
            deniedView(deniedPermissionList = getPermissionsText(permissionsState.revokedPermissions))
        }
    }


}

@OptIn(ExperimentalPermissionsApi::class)
private fun getPermissionsText(permissions: List<PermissionState>): String {
    val revokedPermissionsSize = permissions.size
    if (revokedPermissionsSize == 0) return ""

    val textToShow = StringBuilder().apply {
        append("The ")
    }

    for (i in permissions.indices) {
        textToShow.append(permissions[i].permission)
        when {
            revokedPermissionsSize > 1 && i == revokedPermissionsSize - 2 -> {
                textToShow.append(", and ")
            }
            i == revokedPermissionsSize - 1 -> {
                textToShow.append(" ")
            }
            else -> {
                textToShow.append(", ")
            }
        }
    }
    textToShow.append(if (revokedPermissionsSize == 1) "permission is" else "permissions are")
    return textToShow.toString()
}


/*

//rememberSaveable = 값을 일시적으로 저장할 수 있는 메소드.
    var doNotShowRationale by rememberSaveable { mutableStateOf(false) }
    val permissionsState = rememberMultiplePermissionsState(permissions = permissionList)
    when {
        permissionsState.allPermissionsGranted ->  whenGrated()
        permissionsState.shouldShowRationale || !permissionsState.permissionRequested -> {
            when(true){
                doNotShowRationale -> {
                    whenCanNotUse()
                }
                else -> {
                    revokedPermissionsText.value = getPermissionsText(
                        permissionsState.revokedPermissions
                    )
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center,
                        modifier = modifier,
                        content = {
                            Text(
                                text = stringResource(id = R.string.permission_request_permission),
                                fontSize = 37.sp,
                                modifier = Modifier
                                    .padding(10.dp),
                                color = Color.White
                            )
                            Text(
                                text = stringResource(id = R.string.permission_request_yes),
                                fontSize = 35.sp,
                                color = Color.Green,
                                modifier = Modifier
                                    .padding(
                                        start = 10.dp,
                                        end = 10.dp,
                                        top = 25.dp,
                                        bottom = 5.dp
                                    )
                                    .clip(RoundedCornerShape(10.dp))
                                    .border(
                                        1.dp,
                                        Color.Green,
                                        RoundedCornerShape(10.dp)
                                    )
                                    .clickable {
                                        permissionsState.launchMultiplePermissionRequest()
                                    }
                                    .padding(
                                        start = 10.dp,
                                        end = 10.dp,
                                        top = 5.dp,
                                        bottom = 5.dp
                                    )
                            )

                            Text(
                                text = stringResource(id = R.string.permission_request_no),
                                fontSize = 35.sp,
                                color = Color.Red,
                                modifier = Modifier
                                    .padding(
                                        start = 10.dp,
                                        end = 10.dp,
                                        top = 25.dp,
                                        bottom = 5.dp
                                    )
                                    .clip(RoundedCornerShape(10.dp))
                                    .border(
                                        1.dp,
                                        Color.Red,
                                        RoundedCornerShape(10.dp)
                                    )
                                    .clickable {
//                                        doNotShowRationale = true
                                    }
                                    .padding(
                                        start = 10.dp,
                                        end = 10.dp,
                                        top = 5.dp,
                                        bottom = 5.dp
                                    )
                            )
                        }
                    )
                }
            }
        }

        else -> {
            revokedPermissionsText.value = getPermissionsText(permissionsState.revokedPermissions)
            whenDenied()
        }
    }

@OptIn(ExperimentalPermissionsApi::class)
@Composable
private fun Sample(
    multiplePermissionsState: MultiplePermissionsState,
    navigateToSettingsScreen: () -> Unit
) {
    // Track if the user doesn't want to see the rationale any more.
    var doNotShowRationale by rememberSaveable { mutableStateOf(false) }

    when {
        // If all permissions are granted, then show screen with the feature enabled
        multiplePermissionsState.allPermissionsGranted -> {
            Text("Camera and Read storage permissions Granted! Thank you!")
        }
        // If the user denied any permission but a rationale should be shown, or the user sees
        // the permissions for the first time, explain why the feature is needed by the app and
        // allow the user decide if they don't want to see the rationale any more.
        multiplePermissionsState.shouldShowRationale ||
                !multiplePermissionsState.permissionRequested ->
        {
            if (doNotShowRationale) {
                Text("Feature not available")
            } else {
                Column {
                    val revokedPermissionsText = getPermissionsText(
                        multiplePermissionsState.revokedPermissions
                    )
                    Text(
                        "$revokedPermissionsText important. " +
                                "Please grant all of them for the app to function properly."
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Row {
                        Button(
                            onClick = {
                                multiplePermissionsState.launchMultiplePermissionRequest()
                            }
                        ) {
                            Text("Request permissions")
                        }
                        Spacer(Modifier.width(8.dp))
                        Button(onClick = { doNotShowRationale = true }) {
                            Text("Don't show rationale again")
                        }
                    }
                }
            }
        }
        // If the criteria above hasn't been met, the user denied some permission. Let's present
        // the user with a FAQ in case they want to know more and send them to the Settings screen
        // to enable them the future there if they want to.
        else -> {
            Column {
                val revokedPermissionsText = getPermissionsText(
                    multiplePermissionsState.revokedPermissions
                )
                Text(
                    "$revokedPermissionsText denied. See this FAQ with " +
                            "information about why we need this permission. Please, grant us " +
                            "access on the Settings screen."
                )
                Spacer(modifier = Modifier.height(8.dp))
                Button(onClick = navigateToSettingsScreen) {
                    Text("Open Settings")
                }
            }
        }
    }
}

@OptIn(ExperimentalPermissionsApi::class)
private fun getPermissionsText(permissions: List<PermissionState>): String {
    val revokedPermissionsSize = permissions.size
    if (revokedPermissionsSize == 0) return ""

    val textToShow = StringBuilder().apply {
        append("The ")
    }

    for (i in permissions.indices) {
        textToShow.append(permissions[i].permission)
        when {
            revokedPermissionsSize > 1 && i == revokedPermissionsSize - 2 -> {
                textToShow.append(", and ")
            }
            i == revokedPermissionsSize - 1 -> {
                textToShow.append(" ")
            }
            else -> {
                textToShow.append(", ")
            }
        }
    }
    textToShow.append(if (revokedPermissionsSize == 1) "permission is" else "permissions are")
    return textToShow.toString()
}
 */
