package com.cavss.realestatemanager.ui.custom.bottomnavi

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.cavss.realestatemanager.R
import com.cavss.realestatemanager.model.BottomNaviModel
import com.cavss.realestatemanager.model.TabLayoutModel
import com.cavss.realestatemanager.model.type.CheckListType
import com.cavss.realestatemanager.ui.custom.tablayout.TabLayoutView
import com.cavss.realestatemanager.ui.view.bottomnaviscreen.checklist.CheckListView
import com.cavss.realestatemanager.vm.CheckListVM
import com.cavss.realestatemanager.vm.MainVM


@Composable
fun BottomNaviFragmentsView(
    setNaviController : NavHostController,
    setStartDestination : String,
    setCompposables : (NavGraphBuilder) -> Unit
) {
    NavHost(
        navController = setNaviController,
        startDestination = setStartDestination
    ) {
        setCompposables(this)
    }
}
/*
 composable(route = BottomNaviModel.CHECKLIST.type.rawValue) {
            TabLayoutView(
                setTabLayoutModelList = TabLayoutModel.RENT_TYPE_LIST.list,
                setHeight = setHeight,
                setExtraLayout = {
                    Text(
                        text = stringResource(id = R.string.checkList_title),
                        color = Color.Black,
                        fontSize = 40.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier
                            .padding(
                                vertical = 5.dp,
                                horizontal = 20.dp
                            )
                    )
                },
                setTabLayoutLayoutList = listOf(
                    CheckListView(
                        setMainVM = setMainVM,
                        setCheckListVM = setCheckListVM,
                        setHeight = setHeight,
                        setType = CheckListType.JEONSE
                    ),
                    Text(
                        text = "asdfasdf",
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(setHeight)
                            .background(Color.Red),
                        fontSize = 50.sp,
                        color = Color.Black
                    ),
                    Text(
                        text = "what the fuck",
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(setHeight)
                            .background(Color.Green),
                        fontSize = 50.sp,
                        color = Color.Black
                    )
                )
            )
        }
        composable(route = BottomNaviModel.NOTIFY.type.rawValue) {
            CheckListView(
                setMainVM = setMainVM,
                setCheckListVM = setCheckListVM,
                setHeight = setHeight,
                setType = CheckListType.JEONSE
            )
        }
 */

/*


@Composable
fun BottomNavigationView (
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = BottomNaviModel.CHECKLIST.type,
        modifier = Modifier
            .fillMaxWidth()
            .height(200.dp)
    ) {
        composable(route = BottomNaviModel.CHECKLIST.type ) {
            CheckListView(
                mainVM = ,
                checkListVM = ,
                heightBlock =
            )
        }
        composable(route = BottomNaviModel.NOTIFY.type ) {
            ProfileScreen()
        }
    }
}

@Composable
fun BottomNavigationBarView(
    navController : NavHostController
){

    val bottomNaviItemList = BottomNaviModel.BOTTOM_NAVI_LIST.list
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination

    BottomNavigation {
        bottomNaviItemList.forEach { model ->
            AddItem(
                model = model,
                currentDestination = currentDestination,
                navController = navController
            )
        }
    }
}

 val bottomNaviItemList = BottomNaviModel.BOTTOM_NAVI_LIST.list
    val clicked = remember { mutableStateOf(BottomNaviModel.CHECKLIST) }

    LazyRow(
        modifier= Modifier
            .background(Color.White)
            .padding(5.dp)
            .border(
                width = 5.dp,
                color = Color.Black,
                shape = RoundedCornerShape(corner = CornerSize(50.dp))
            )
            .size(
                width = size["width"]!!,
                height = size["height"]!!
            ),
        horizontalArrangement = Arrangement.SpaceAround,
        verticalAlignment = Alignment.CenterVertically
    ){
        items(bottomNaviItemList) { item->
            BottomNaviItemView(
                setModel = item,
                setColour = Color.Blue,
                isSelected = item.type == currentScreenID,
                onClick = {
                    onItemSelected(clicked.value)
                }
            )
        }
    }

 */