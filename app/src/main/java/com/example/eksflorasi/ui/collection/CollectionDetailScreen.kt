package com.example.eksflorasi.ui.collection

import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import com.example.eksflorasi.R
import com.example.eksflorasi.ui.navigation.TopBackNavigation
import com.example.eksflorasi.ui.theme.EksFlorasiTheme

@Composable
fun CollectionDetailScreen() {
    Scaffold(
        topBar = {
            TopBackNavigation(title = "Details")
        },
        content = {
            CollectionDetailContent(
                modifier = Modifier,
                name = "Cat",
                latin = "Felis Navidad",
                description = "AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA",
                imageRes = R.drawable.collection_example,
                type = "fauna"
            )
        }
    )
}

@Preview(
    showBackground = true,
    showSystemUi = true,
    device = Devices.PIXEL_3A
)
@Composable
fun CollectionDetailScreenPreview() {
    EksFlorasiTheme {
        CollectionDetailScreen()
    }
}
