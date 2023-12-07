package com.example.appv3.main

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.appv3.components.ComposeSwipeablePagesTheme
import com.example.appv3.screens.LoginScreen
import com.example.appv3.screens.RegisterScreen

@Composable

fun Nav() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "Register" ){
        composable(route = "Register"){
            RegisterScreen(navController)
        }

        composable(route = "login"){
            LoginScreen(navController)
        }
        composable(route = "duck"){
            ComposeSwipeablePagesTheme(navController)
        }

    }
}