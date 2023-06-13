package com.example.eksflorasi.ui.navigation

import androidx.compose.foundation.layout.Box
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material.icons.outlined.*
import androidx.compose.material.icons.rounded.Camera
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import com.example.eksflorasi.ui.theme.EksFlorasiTheme

@Composable
fun BottomNavigation(modifier: Modifier) {
    val selectedNavItem = remember { mutableStateOf("Home") }
    Box() {
        NavigationBar(modifier = modifier) {
            val navigationItems = listOf(
                BottomNavItem(
                    title = "Home",
                    iconFocused = Icons.Filled.Home,
                    iconUnfocused = Icons.Outlined.Home
                ),
                BottomNavItem(
                    title = "Collection",
                    iconFocused = Icons.Filled.Forest,
                    iconUnfocused = Icons.Outlined.Forest
                ),
                BottomNavItem(
                    title = "Camera",
                    iconFocused = Icons.Filled.CameraAlt,
                    iconUnfocused = Icons.Outlined.CameraAlt
                ),
                BottomNavItem(
                    title = "Rank",
                    iconFocused = Icons.Filled.Leaderboard,
                    iconUnfocused = Icons.Outlined.Leaderboard
                ),
                BottomNavItem(
                    title = "Profile",
                    iconFocused = Icons.Filled.AccountCircle,
                    iconUnfocused = Icons.Outlined.AccountCircle
                )
            )

            navigationItems.forEach { navItem ->
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
                    selected = navItem.title == selectedNavItem.value,
                    onClick = { selectedNavItem.value = navItem.title },
                )
            }
        }
    }
}

@Preview(
    showBackground = true,
)
@Composable
fun BottomNavigationPreview() {
    EksFlorasiTheme {
        BottomNavigation(Modifier)
    }
}
