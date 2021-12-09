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
import com.cavss.realestatemanager.ui.view.checklist.CheckListView
import com.cavss.realestatemanager.vm.CheckListVM
import com.cavss.realestatemanager.vm.MainVM

class MainActivity : ComponentActivity() {

    private val checkListVM by viewModels<CheckListVM>()
    private val mainVM by viewModels<MainVM>()

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
                        Column(
                            verticalArrangement = Arrangement.Top,
                            horizontalAlignment = Alignment.Start,
                            modifier = Modifier
                                .fillMaxSize()
                                .background(colorResource(id = R.color.background))
                        ) {
                            CheckListView(checkListVM)
                        }
                        BottomSheetView(mainVM)
                    }
                }
            }
        }
    }
}
