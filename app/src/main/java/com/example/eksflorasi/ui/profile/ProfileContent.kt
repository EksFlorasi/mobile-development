package com.example.eksflorasi.ui.profile

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.eksflorasi.ui.leaderboard.*
import com.example.eksflorasi.ui.theme.EksFlorasiTheme

private val AppBarHeight = 64.dp
private val AppNavHeight = 70.dp
private val AppBarMargin = 16.dp

@Composable
fun ProfileContent() {
    Box(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(
                    horizontal = AppBarMargin,
                )
                .padding(top = AppBarHeight, bottom = AppNavHeight)
        ) {
            ProfileBanner()
            Spacer(modifier = Modifier.height(32.dp))
            ProfileBottomSection()
        }
    }
}

@Preview(
    showBackground = true
)
@Composable
fun ProfileContentPreview() {
    EksFlorasiTheme {
        ProfileContent()
    }
}