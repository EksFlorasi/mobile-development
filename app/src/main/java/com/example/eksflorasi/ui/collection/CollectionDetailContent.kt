package com.example.eksflorasi.ui.collection

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.eksflorasi.R
import com.example.eksflorasi.ui.theme.EksFlorasiTheme

private val AppBarHeight = 80.dp
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
    val state = rememberScrollState()
    LaunchedEffect(Unit) { state.animateScrollTo(10) }

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(horizontal = AppBarMargin)
            .padding(top = AppBarHeight)
            .verticalScroll(state),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly
    ) {
        CollectionImage(modifier = modifier, imageRes = imageRes, type = type)
        CollectionDescription(modifier = modifier, name = name, latin = latin, description = description)
        CollectionFact(modifier = Modifier, type = "fauna", funFact = "Bats are the only mammals that actually fly, flapping their wings to propel them in flight.")
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
            name = "Bat",
            latin = "Chiroptera",
            description = "Bats are mammals of the order Chiroptera. With their forelimbs adapted as wings, they are the only mammals capable of true and sustained flight. Bats are more agile in flight than most birds, flying with their very long spread-out digits covered with a thin membrane or patagium. The smallest bat, and arguably the smallest extant mammal, is Kitti\\'s hog-nosed bat, which is 29–34 millimetres in length, 150 mm across the wings and 2–2.6 g in mass. The largest bats are the flying foxes, with the giant golden-crowned flying fox (Acerodon jubatus) reaching a weight of 1.6 kg and having a wingspan of 1.7 m.','Bats are the only mammals that actually fly, flapping their wings to propel them in flight.",
            imageRes = R.drawable.collection_example,
            type = "fauna"
        )
    }
}
