package com.example.eksflorasi.ui.collection

import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import com.example.eksflorasi.R
import com.example.eksflorasi.ui.home.DashboardScreen
import com.example.eksflorasi.ui.home.HomeContent
import com.example.eksflorasi.ui.home.TopNavigation
import com.example.eksflorasi.ui.navigation.BottomNavigation
import com.example.eksflorasi.ui.theme.EksFlorasiTheme

@Composable
fun CollectionScreen() {
    Scaffold(
        topBar = {
            TopNavigation(
                title = stringResource(R.string.collection_headline),
                modifier = Modifier
            )
        },
        content = {
            CollectionContent(modifier = Modifier)
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
fun CollectionScreenPreview() {
    EksFlorasiTheme {
        CollectionScreen()
    }
}
