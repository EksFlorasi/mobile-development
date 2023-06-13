package com.example.eksflorasi.ui.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@Composable
fun HomeSection(
    title: String,
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit
){
    Column(modifier) {
        SectionText(title, modifier)
        content()
    }
}

@Composable
fun SectionText(
    title: String,
    modifier: Modifier = Modifier
) {
    Text(
        text = title,
        style = MaterialTheme.typography.titleMedium,
        color = MaterialTheme.colorScheme.onPrimaryContainer,
        modifier = modifier
            .padding(top = 16.dp).padding(bottom = 8.dp)
    )
}