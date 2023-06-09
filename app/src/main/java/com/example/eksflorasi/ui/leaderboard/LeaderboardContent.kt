package com.example.eksflorasi.ui.leaderboard

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.eksflorasi.ui.theme.EksFlorasiTheme

private val AppBarHeight = 64.dp
private val AppNavHeight = 70.dp
private val AppBarMargin = 16.dp

@Composable
fun LeaderboardContent() {
    Box(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(
                    horizontal = AppBarMargin,
                )
                .padding(top = AppBarHeight, bottom = AppNavHeight)
        ) {
            TopThreeLeaderboard(topUsers = dummyUserRankList)
            ColumnLeaderboard(modifier = Modifier.weight(1f), users = dummyLeaderboardList)
        }
    }
}

@Preview(
    showBackground = true
)
@Composable
fun LeaderboardContentPreview() {
    EksFlorasiTheme {
        LeaderboardContent()
    }
}