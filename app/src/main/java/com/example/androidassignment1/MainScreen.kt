package com.example.androidassignment1

import android.annotation.SuppressLint
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.androidassignment1.model.Employee
import com.example.androidassignment1.utils.RetrofitInstance
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun MainScreen(param: (String, Int, Int) -> Unit) {
    val coroutineScope = rememberCoroutineScope()
    var employees by remember { mutableStateOf<List<Employee>>(emptyList()) }
    var errorMessage by remember { mutableStateOf("") }
    LaunchedEffect(Unit) {
        coroutineScope.launch(Dispatchers.IO) { 
            try {
                val response = RetrofitInstance.api.getDetails()
                employees = response.employees
            }catch (e: Exception){
                errorMessage = "Error fetching data: ${e.message}"
            }
        }
    }
    Scaffold(
        topBar = {
            TopAppBar(title = { Text(text = "Employees", fontSize = 26.sp) })
        }
    ) {
        Column(modifier = Modifier
            .fillMaxSize()
            .padding(8.dp)) {

            if (errorMessage.isNotEmpty()) {
                Text(text = errorMessage, color = Color.Red)
            } else {
                LazyColumn {
                    items(employees) { employee ->
                        EmployeeDetails(employee = employee){
                            param(employee.name, employee.age, employee.salary)
                        }
                    }
                }
            }
        }
    }

}

@Composable
fun EmployeeDetails(employee: Employee, toDetailScreen:()->Unit ){
    Column(modifier = Modifier
        .fillMaxWidth(1f)
        .padding(16.dp)
        .clickable(onClick = { toDetailScreen() })) {
        Text(text = employee.name, fontSize = 20.sp)
        Text(text = employee.age.toString(), fontSize = 20.sp)
        Text(text = employee.salary.toString(), fontSize = 20.sp)
    }
    HorizontalDivider(thickness = 1.dp, color = Color.Gray)
}


