package com.example.voenkach3.navigation

sealed class Screen(val route: String) {
    data object Start: Screen("start")
    data object Login : Screen("login")
    data object Registration : Screen("registration")
    data object Main : Screen("main")
}