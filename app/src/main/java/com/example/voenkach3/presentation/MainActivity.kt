package com.example.voenkach3.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.voenkach3.navigation.Screen
import com.example.voenkach3.presentation.login_module.LoginModule
import com.example.voenkach3.presentation.main_module.components.MainModule
import com.example.voenkach3.presentation.registration_module.RegistrationModule
import com.example.voenkach3.presentation.start_module.StartModule
import com.example.voenkach3.presentation.ui.theme.VoenKach3Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            VoenKach3Theme {
                val navController = rememberNavController()
                NavHost(navController= navController, startDestination = Screen.Start.route)
                {
                    composable(route= Screen.Start.route){
                        StartModule(navController=navController)
                    }
                    composable(route=Screen.Login.route){
                        LoginModule(navController=navController)
                    }
                    composable(route=Screen.Registration.route){
                        RegistrationModule(navController=navController)
                    }
                    composable(route=Screen.Main.route){
                        MainModule(navController = navController)
                    }
                }
            }
        }
    }
}