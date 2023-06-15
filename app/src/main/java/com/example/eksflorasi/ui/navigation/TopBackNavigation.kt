package com.example.eksflorasi.ui.navigation

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowBackIos
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.eksflorasi.ui.theme.EksFlorasiTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBackNavigation(
    title: String
) {
    TopAppBar(
        title = {
            Row() {
                Text(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(2f),
                    text = title,
                    textAlign = TextAlign.Center,
                    color = MaterialTheme.colorScheme.onPrimaryContainer,
                    style = MaterialTheme.typography.titleLarge,
                    fontWeight = FontWeight.Medium
                )
                Spacer(modifier = Modifier.weight(1f))
            }
        },
        navigationIcon = {
            IconButton(modifier = Modifier.width(100.dp), onClick = { }) {
                Row() {
                    Icon(
                        Icons.Filled.ArrowBackIos,
                        contentDescription = "Back",
                        tint = MaterialTheme.colorScheme.primary
                    )
                    Text(
                        text = "Back",
                        color = MaterialTheme.colorScheme.primary,
                        style = MaterialTheme.typography.titleMedium
                    )
                }
            }
        }
    )
}

@Preview
@Composable
fun TopBackNavigationPreview(
) {
    EksFlorasiTheme() {
        TopBackNavigation(title = "Test")
    }
}