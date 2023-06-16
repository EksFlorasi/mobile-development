package com.example.eksflorasi.ui.profile

import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import com.example.eksflorasi.R
import com.example.eksflorasi.ui.home.TopNavigation
import com.example.eksflorasi.ui.leaderboard.LeaderboardContent
import com.example.eksflorasi.ui.leaderboard.LeaderboardScreen
import com.example.eksflorasi.ui.navigation.BottomNavigation
import com.example.eksflorasi.ui.theme.EksFlorasiTheme

@Composable
fun ProfileScreen() {
    ProfileContent()
}

@Preview(
    showBackground = true,
    showSystemUi = true,
    device = Devices.PIXEL_3A
)
@Composable
fun ProfileScreenPreview() {
    EksFlorasiTheme {
        ProfileScreen()
    }
}
