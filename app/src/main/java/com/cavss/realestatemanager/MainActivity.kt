package com.cavss.realestatemanager

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.cavss.realestatemanager.ui.theme.RealEstateManagerTheme
import com.cavss.realestatemanager.R

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RealEstateManagerTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Column(
                        verticalArrangement = Arrangement.Top,
                        horizontalAlignment = Alignment.Start,
                        modifier = Modifier.fillMaxSize()
                    ) {
                        LazyRow(
                            horizontalArrangement = Arrangement.Center,
                            modifier = Modifier
                                .fillMaxWidth(),
                            content ={
                            items(resources.getStringArray(R.array.rent_type_list)){ item ->
                                Text(
                                    text = item,
                                    modifier = Modifier
                                        .padding(
                                            vertical = 5.dp,
                                            horizontal = 10.dp
                                        )
                                        .border(
                                            1.dp,
                                            Color.White,
                                            RoundedCornerShape(10.dp)
                                        )
                                        .padding(
                                            vertical = 5.dp,
                                            horizontal = 10.dp
                                        )
                                        .clickable {

                                        },
                                    color = Color.White,
                                    fontSize = 20.sp
                                )
                            }
                        })


                    }
                }
            }
        }
    }
}

