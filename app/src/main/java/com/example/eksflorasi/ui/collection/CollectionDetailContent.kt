package com.example.eksflorasi.ui.collection

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.eksflorasi.R
import com.example.eksflorasi.ui.theme.EksFlorasiTheme

private val AppBarHeight = 56.dp
private val AppBarMargin = 16.dp

@Composable
fun CollectionDetailContent(
    modifier: Modifier,
    name: String,
    latin: String,
    description: String,
    imageRes: Int,
    type: String
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(horizontal = AppBarMargin, vertical = AppBarHeight),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly
    ) {
        CollectionImage(modifier = modifier, imageRes = imageRes, type = type)
        CollectionDescription(modifier = modifier, name = name, latin = latin, description = description)
        CollectionFact(modifier = Modifier, type = "fauna", funFact = "This is fauna")
    }
}

@Preview(
    showBackground = true,
    device = Devices.PIXEL_3A
)
@Composable
fun CollectionDetailContentPreview() {
    EksFlorasiTheme {
        CollectionDetailContent(
            modifier = Modifier,
            name = "Cat",
            latin = "Felis Navidad",
            description = "AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA",
            imageRes = R.drawable.collection_example,
            type = "fauna"
        )
    }
}
