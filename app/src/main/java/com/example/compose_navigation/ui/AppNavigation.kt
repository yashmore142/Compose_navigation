package com.example.compose_navigation.ui

import androidx.compose.runtime.Composable
import androidx.navigation.NavArgument
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.compose_navigation.LoginScreen
import com.example.compose_navigation.MainScreen
import com.example.compose_navigation.RegistrationScreen

@Composable
fun AppNavigation() {

    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "login") {
        composable(route = "registration/{email}", arguments = listOf(
            navArgument("email"){
                type = NavType.StringType
            }
        )) {

            RegistrationScreen(navController,it.arguments!!.getString("email").toString())
        }
        composable(route = "login") {
            LoginScreen(navController)
        }
        composable(route = "main") {
            MainScreen(navController)
        }
    }
}