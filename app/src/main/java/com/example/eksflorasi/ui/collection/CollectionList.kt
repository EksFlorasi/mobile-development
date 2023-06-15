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

data class CollectionItemData(val name: String, val type: String)

val dummyCollectionItems = listOf(
    CollectionItemData("Item 1", "flora"),
    CollectionItemData("Item 2", "fauna"),
    CollectionItemData("Item 3", "flora"),
    CollectionItemData("Item 4", "fauna"),
    CollectionItemData("Item 5", "flora"),
    CollectionItemData("Item 6", "fauna"),
    CollectionItemData("Item 7", "flora"),
    CollectionItemData("Item 8", "fauna"),
    CollectionItemData("Item 9", "flora"),
    CollectionItemData("Item 10", "fauna"),
    CollectionItemData("Item 1", "flora"),
    CollectionItemData("Item 2", "fauna"),
    CollectionItemData("Item 3", "flora"),
    CollectionItemData("Item 4", "fauna"),
    CollectionItemData("Item 5", "flora"),
    CollectionItemData("Item 6", "fauna"),
    CollectionItemData("Item 7", "flora"),
    CollectionItemData("Item 8", "fauna"),
    CollectionItemData("Item 9", "flora"),
    CollectionItemData("Item 10", "fauna"),
    // Add more items as needed
)

@Composable
fun CollectionList(modifier: Modifier, collections: List<CollectionItemData>) {
    LazyVerticalGrid(
        modifier = modifier,
        columns = GridCells.Fixed(3),
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(collections){ collection ->
            CollectionItem(
                modifier = modifier, name = collection.name, type = collection.type
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





