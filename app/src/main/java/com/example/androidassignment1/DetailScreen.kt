package com.example.androidassignment1

import android.annotation.SuppressLint
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun DetailScreen(name:String, age:Int?, salary:Int?, back:()->Unit){
    // Title
    Scaffold(
        topBar = {
            TopAppBar(title = {
                Row {
                    Icon(
                        imageVector = Icons.Default.ArrowBack,
                        modifier = Modifier.clickable { back() },
                        contentDescription = null
                    )
                    Text(
                        text = "Employee Details",
                        fontSize = 26.sp
                    )
                }
            })
        }
    ) {
        Column(modifier = Modifier
            .fillMaxSize()
            .padding(8.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(text = name, fontWeight = FontWeight.SemiBold, fontSize = 20.sp)
            Text(text = age.toString(), fontWeight = FontWeight.SemiBold, fontSize = 20.sp)
            Text(text = salary.toString(), fontWeight = FontWeight.SemiBold, fontSize = 20.sp)
        }
    }
    }

