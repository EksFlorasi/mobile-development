package com.example.eksflorasi.ui.home

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Help
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import com.example.eksflorasi.ui.theme.EksFlorasiTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopNavigation(title: String, modifier: Modifier){
    TopAppBar(
        title = { Text(
            text = title,
            color = MaterialTheme.colorScheme.onPrimaryContainer,
            style = MaterialTheme.typography.titleLarge,
            fontWeight = FontWeight.Medium
        ) },
        actions = {
            IconButton(onClick = {}) {
                Icon(Icons.Outlined.Help, contentDescription = "Help")
            }
        },
        modifier = modifier.fillMaxWidth()
    )
}

@Preview(
    showBackground = true
)
@Composable
fun TopNavigationPreview() {
    EksFlorasiTheme {
        TopNavigation("Preview", Modifier)
    }
}