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
                name = "Bat",
                latin = "Chiroptera",
                description = "Bats are mammals of the order Chiroptera. With their forelimbs adapted as wings, they are the only mammals capable of true and sustained flight. Bats are more agile in flight than most birds, flying with their very long spread-out digits covered with a thin membrane or patagium. The smallest bat, and arguably the smallest extant mammal, is Kitti\\'s hog-nosed bat, which is 29–34 millimetres in length, 150 mm across the wings and 2–2.6 g in mass. The largest bats are the flying foxes, with the giant golden-crowned flying fox (Acerodon jubatus) reaching a weight of 1.6 kg and having a wingspan of 1.7 m.",
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
