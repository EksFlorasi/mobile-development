package com.example.eksflorasi.ui.leaderboard

import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import com.example.eksflorasi.R
import com.example.eksflorasi.ui.collection.CollectionContent
import com.example.eksflorasi.ui.collection.CollectionScreen
import com.example.eksflorasi.ui.home.TopNavigation
import com.example.eksflorasi.ui.navigation.BottomNavigation
import com.example.eksflorasi.ui.theme.EksFlorasiTheme

@Composable
fun LeaderboardScreen() {
    LeaderboardContent()
}

@Preview(
    showBackground = true,
    showSystemUi = true,
    device = Devices.PIXEL_3A
)
@Composable
fun LeaderboardScreenPreview() {
    EksFlorasiTheme {
        LeaderboardScreen()
    }
}
