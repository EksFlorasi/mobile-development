package com.example.eksflorasi.ui.navigation

import androidx.compose.foundation.layout.Box
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material.icons.outlined.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.compose.runtime.getValue
import androidx.navigation.compose.rememberNavController

@Composable
fun BottomNavigation(
    navController: NavHostController,
    modifier: Modifier
) {
    val selectedNavItem = remember { mutableStateOf("Home") }
    Box() {
        NavigationBar(modifier = modifier) {
            val navBackStackEntry by navController.currentBackStackEntryAsState()
            val currentRoute = navBackStackEntry?.destination?.route

            val navigationItems = listOf(
                BottomNavItem(
                    title = "Home",
                    iconFocused = Icons.Filled.Home,
                    iconUnfocused = Icons.Outlined.Home,
                    screen = Screen.Dashboard
                ),
                BottomNavItem(
                    title = "Collection",
                    iconFocused = Icons.Filled.Forest,
                    iconUnfocused = Icons.Outlined.Forest,
                    screen = Screen.Collection
                ),
                BottomNavItem(
                    title = "Camera",
                    iconFocused = Icons.Filled.CameraAlt,
                    iconUnfocused = Icons.Outlined.CameraAlt,
                    screen = Screen.Camera
                ),
                BottomNavItem(
                    title = "Rank",
                    iconFocused = Icons.Filled.Leaderboard,
                    iconUnfocused = Icons.Outlined.Leaderboard,
                    screen = Screen.Leaderboard
                ),
                BottomNavItem(
                    title = "Profile",
                    iconFocused = Icons.Filled.AccountCircle,
                    iconUnfocused = Icons.Outlined.AccountCircle,
                    screen = Screen.Profile
                )
            )

            navigationItems.map { navItem ->
                NavigationBarItem(
                    icon = {
                        Icon(
                            imageVector = if (navItem.title == selectedNavItem.value) navItem.iconFocused else navItem.iconUnfocused,
                            contentDescription = navItem.title,
                            tint = MaterialTheme.colorScheme.primary
                        )
                    },
                    label = {
                        if (navItem.title == selectedNavItem.value) {
                            Text(
                                text = navItem.title,
                                style = MaterialTheme.typography.labelMedium,
                                color = MaterialTheme.colorScheme.primary,
                                textAlign = TextAlign.Center,
                                softWrap = false,
                                overflow = TextOverflow.Visible
                            )
                        }
                    },
                    selected = currentRoute == navItem.screen.route,
                    onClick = {
                        selectedNavItem.value = navItem.title
                        navController.navigate(navItem.screen.route) {
                            popUpTo(navController.graph.findStartDestination().id) {
                                saveState = true
                            }
                            restoreState = true
                            launchSingleTop = true
                        }
                    },
                )
            }
        }
    }
}