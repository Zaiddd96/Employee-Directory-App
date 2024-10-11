package com.example.androidassignment1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

import com.example.androidassignment1.ui.theme.AndroidAssignment1Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AndroidAssignment1Theme {
                MyApp()
            }
        }
    }
}

@Composable
fun MyApp() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "MainScreen") {
        composable("MainScreen") {
            MainScreen { name, age, salary ->
                navController.navigate("DetailScreen/$name/$age/$salary")
            }
        }
        composable("DetailScreen/{name}/{age}/{salary}") { backStackEntry ->
            val name = backStackEntry.arguments?.getString("name")
            val age = backStackEntry.arguments?.getString("age")?.toIntOrNull()
            val salary = backStackEntry.arguments?.getString("salary")?.toIntOrNull()
            DetailScreen(name = name ?: "Unknown", age = age, salary = salary){
                navController.navigate("MainScreen")
            }
        }
    }
}





