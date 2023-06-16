package com.example.eksflorasi.ui.collection

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.eksflorasi.ui.theme.EksFlorasiTheme
import com.example.eksflorasi.model.Collection

val dummyCollectionItems = listOf(
    Collection("Bat", "https://storage.googleapis.com/flora-fauna-images/fauna/bat-thumbnail.png", "fauna"),
    Collection("Boar", "https://storage.googleapis.com/flora-fauna-images/fauna/boar-thumbnail.png", "fauna"),
    Collection("Cat", "https://storage.googleapis.com/flora-fauna-images/fauna/cat-thumbnail.png", "fauna"),
    Collection("Dog", "https://storage.googleapis.com/flora-fauna-images/fauna/dog-thumbnail.png", "fauna"),
    Collection("Hedgehog", "https://storage.googleapis.com/flora-fauna-images/fauna/hedgehog-thumbnail.png", "fauna"),
)

val dummyFloraItems = listOf(
    Collection("Astilbe", "https://storage.googleapis.com/flora-fauna-images/flora/astilbe-thumbnail.png", "flora"),
    Collection("Bellflower", "https://storage.googleapis.com/flora-fauna-images/flora/bellflower-thumbnail.png", "flora"),
    Collection("Black eyed susan", "https://storage.googleapis.com/flora-fauna-images/flora/black_eyed_susan-thumbnail.png", "flora"),
    Collection("Calendula", "https://storage.googleapis.com/flora-fauna-images/flora/calendula-thumbnail.png", "flora"),
    Collection("California Poppy", "https://storage.googleapis.com/flora-fauna-images/flora/california_poppy-thumbnail.png", "flora"),
)

@Composable
fun CollectionList(modifier: Modifier, collections: List<Collection>) {
    LazyVerticalGrid(
        modifier = modifier,
        columns = GridCells.Fixed(3),
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(collections){ collection ->
            CollectionItem(
                modifier = modifier, collection = collection
            )
        }
    }
}

@Preview(
    showBackground = true,
)
@Composable
fun CollectionListPreview() {
    EksFlorasiTheme {
        CollectionList(modifier = Modifier.fillMaxSize(), collections = dummyCollectionItems)
    }
}





