package com.cavss.realestatemanager

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import com.cavss.realestatemanager.ui.theme.RealEstateManagerTheme
import com.cavss.realestatemanager.ui.custom.bottomsheet.BottomSheetView
import com.cavss.realestatemanager.ui.custom.popup.PopUpContainer
import com.cavss.realestatemanager.ui.custom.popup.PopUpVM
import com.cavss.realestatemanager.ui.view.checklist.CheckListView
import com.cavss.realestatemanager.ui.view.main.MainView
import com.cavss.realestatemanager.vm.CheckListVM
import com.cavss.realestatemanager.vm.MainVM

class MainActivity : ComponentActivity() {

    private val checkListVM by viewModels<CheckListVM>()
    private val mainVM by viewModels<MainVM>()
    private val popupVM by viewModels<PopUpVM>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RealEstateManagerTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier
                        .fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                    ) {
                        MainView(
                            mainVM = mainVM,
                            popupVM = popupVM,
                            checkListVM = checkListVM
                        )
                        BottomSheetView(mainVM)
                        PopUpContainer(popupVM = popupVM)
                    }
                }
            }
        }
    }
}
