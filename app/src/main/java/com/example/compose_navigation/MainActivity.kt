package com.example.compose_navigation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import com.example.compose_navigation.ui.AppNavigation
import com.example.compose_navigation.ui.animation_bottom_bar.MainBottomScreen
import com.example.compose_navigation.ui.onboarding.OnboardingUI

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
          //  AppNavigation()
          //  FinalDesign()
            OnboardingUI()
        }
    }
}
@Composable
@Preview
fun FinalDesign(){
    Box (Modifier.fillMaxSize()){
        AppNavigation()
        MainBottomScreen()
    }
}


@Composable
fun MainScreen(navController: NavController) {
    Box (Modifier.fillMaxSize().background(Color.White)){
        Text(text = "Main Screen",
            modifier = Modifier.clickable {
                navController.navigate("login")
            }, style = MaterialTheme.typography.headlineMedium
        )
    }

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


