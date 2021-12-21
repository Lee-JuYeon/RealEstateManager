package com.cavss.realestatemanager.ui.custom.bottomnavi

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.cavss.realestatemanager.model.BottomNaviModel

@Composable
fun BottomNaviView(
    setNaviController : NavHostController,
    setHeight : Dp,
    setTopRadius : Dp
) {
    LazyRow(
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .height(setHeight)
            .border(
                3.dp,
                Color.Black,
                RoundedCornerShape(
                    topStart = setTopRadius,
                    topEnd = setTopRadius
                )
            )
            .clip(
                RoundedCornerShape(
                    topStart = setTopRadius,
                    topEnd = setTopRadius
                )
            )
            .padding(
                vertical = 5.dp
            ),
        content = {
            items(BottomNaviModel.BOTTOM_NAVI_LIST.list){ model ->
                BottomNaviItemView(
                    setModel = model,
                    setColour = Color.Black,
                    setNavController = setNaviController
                )
            }
        }
    )
}

/*


@Composable
fun BottomNaviFragmentsView(
    setNaviController : NavHostController,
    setMainVM : MainVM,
    setCheckListVM : CheckListVM
) {
    val height = LocalConfiguration.current.screenWidthDp.dp
    NavHost(
        navController = setNaviController,
        startDestination = BottomNaviModel.CHECKLIST.type.rawValue
    ) {
        composable(route = BottomNaviModel.CHECKLIST.type.rawValue) {
            CheckListView(
                mainVM = setMainVM,
                checkListVM = setCheckListVM,
                heightBlock = (height / 20) * 18
            )
        }
        composable(route = BottomNaviModel.NOTIFY.type.rawValue) {
            Text(
                text = "notify View",
                color = Color.Black,
                modifier = Modifier
                    .fillMaxWidth()
                    .height( (height / 20) * 18 )
                    .border(
                        1.dp,
                        Color.Black,
                        RectangleShape
                    )
            )
        }
    }
}

 */