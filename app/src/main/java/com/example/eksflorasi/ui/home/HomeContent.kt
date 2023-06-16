package com.example.eksflorasi.ui.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.eksflorasi.R
import com.example.eksflorasi.ui.theme.EksFlorasiTheme

private val AppBarHeight = 60.dp
private val NavBarHeight = 100.dp
private val AppBarMargin = 16.dp

@Composable
fun HomeContent(modifier: Modifier) {
    val state = rememberScrollState()
    LaunchedEffect(Unit) { state.animateScrollTo(10) }
    Box(modifier = modifier.fillMaxSize().verticalScroll(state)) {
        Column(
            modifier
                .fillMaxSize()
                .padding(horizontal = AppBarMargin)
                .padding(top = AppBarHeight, bottom = NavBarHeight)
        ) {
            WelcomingMessage(name = "Bob")
            HomeSection(title = stringResource(R.string.daily_mission)) {
                DailyMission(modifier = modifier)
            }
            HomeSection(title = "Stats") {
                Stats(modifier = modifier)
            }
            HomeSection(title = "Flor's Tip of The Day") {
                DailyTips(modifier = modifier)
            }
        }
    }
}




@Composable
fun Tips() {

}

@Preview(
    showBackground = true,
    device = Devices.PIXEL_3A
)
@Composable
fun HomeContentPreview() {
    EksFlorasiTheme {
        HomeContent(modifier = Modifier)
    }
}


