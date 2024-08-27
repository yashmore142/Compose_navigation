package com.example.compose_navigation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.compose_navigation.ui.AppNavigation
import com.example.compose_navigation.ui.animation_bottom_bar.MainBottomScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
          //  AppNavigation()
            MainBottomScreen()
        }
    }
}



@Composable
fun MainScreen(navController: NavController) {
    Text(text = "Main Screen",
        modifier = Modifier.clickable {
            navController.navigate("login")
        }, style = MaterialTheme.typography.headlineMedium
    )
}

@Composable
fun LoginScreen(navController: NavController) {
    Text(text = "Login Screen", modifier = Modifier.clickable {
        navController.navigate("registration/yash123")
    }, style = MaterialTheme.typography.headlineMedium)
}

@Composable
fun RegistrationScreen(navController: NavController,email: String) {
    Text(text = "Registration Screen $email", modifier = Modifier.clickable {
        navController.navigate("main")
    }, style = MaterialTheme.typography.headlineMedium)
}


