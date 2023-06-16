package com.example.eksflorasi.ui.navigation

sealed class Screen(val route: String){
    object Login : Screen("login")
    object Register : Screen("register")
    object Dashboard : Screen("dashboard")
    object Collection : Screen("collection")
    object CollectionDetail : Screen("collectionDetail")
    object Profile : Screen("profile")
    object Leaderboard : Screen("leaderboard")
    object Camera : Screen("Camera")
}
