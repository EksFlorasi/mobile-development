package com.example.eksflorasi.ui.home

import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import com.example.eksflorasi.R
import com.example.eksflorasi.ui.theme.EksFlorasiTheme
import com.example.eksflorasi.ui.navigation.*

@Composable
fun DashboardScreen() {
    Scaffold(
        topBar = {
            TopNavigation(
                title = stringResource(id = R.string.dashboard_title),
                modifier = Modifier
            )
        },
        content = {
            HomeContent(Modifier)
        },
        bottomBar = {
            BottomNavigation(modifier = Modifier)
        }
    )
}

@Preview(
    showBackground = true,
    showSystemUi = true,
    device = Devices.PIXEL_3A
)
@Composable
fun DashboardScreenPreview() {
    EksFlorasiTheme {
        DashboardScreen()
    }
}
