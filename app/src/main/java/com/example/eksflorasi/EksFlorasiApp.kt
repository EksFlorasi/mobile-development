package com.example.eksflorasi

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.eksflorasi.ui.collection.CollectionContent
import com.example.eksflorasi.ui.collection.CollectionScreen
import com.example.eksflorasi.ui.home.DashboardScreen
import com.example.eksflorasi.ui.home.TopNavigation
import com.example.eksflorasi.ui.leaderboard.LeaderboardScreen
import com.example.eksflorasi.ui.navigation.BottomNavigation
import com.example.eksflorasi.ui.navigation.Screen
import com.example.eksflorasi.ui.profile.ProfileScreen

@Composable
fun EksFlorasiApp(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
) {
    Scaffold(
        topBar = {
            TopNavigation(
                navController = navController,
                modifier = Modifier
            )
        },
        bottomBar = {
            BottomNavigation(navController, modifier = Modifier)
        },
        modifier = modifier
    ) {
        NavHost(
            navController = navController,
            startDestination = Screen.Dashboard.route,
        ) {
            composable(Screen.Dashboard.route) {
                DashboardScreen()
            }
            composable(Screen.Leaderboard.route) {
                LeaderboardScreen()
            }
            composable(Screen.Camera.route) {
                LeaderboardScreen()
            }
            composable(Screen.Collection.route) {
                CollectionScreen()
            }
            composable(Screen.Profile.route) {
                ProfileScreen()
            }
        }
    }
}