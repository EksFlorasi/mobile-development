package com.example.eksflorasi.ui.collection

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.eksflorasi.ui.theme.EksFlorasiTheme
import com.example.eksflorasi.R
private val AppBarHeight = 56.dp
private val BottomBarHeight = 72.dp

@Composable
fun CollectionContent(modifier: Modifier) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(top = AppBarHeight, bottom = BottomBarHeight)
    ) {
        ContentPager(modifier = modifier)
    }
}


@Preview(
    showBackground = true,
    device = Devices.PIXEL_3A
)
@Composable
fun CollectionContentPreview() {
    EksFlorasiTheme {
        CollectionContent(modifier = Modifier)
    }
}
