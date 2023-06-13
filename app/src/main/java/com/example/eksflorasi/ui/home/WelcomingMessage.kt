package com.example.eksflorasi.ui.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import com.example.eksflorasi.R
import com.example.eksflorasi.ui.theme.EksFlorasiTheme

@Composable
fun WelcomingMessage(name: String) {
    Column {
        Row {
            Text(
                text = "Hi, ",
                style = MaterialTheme.typography.titleLarge,
                color = MaterialTheme.colorScheme.onPrimaryContainer
            )
            Text(
                text = name,
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.Medium,
                color = MaterialTheme.colorScheme.primary
            )
        }
        Text(
            text = stringResource(R.string.welcoming_message),
            style = MaterialTheme.typography.bodyLarge,
            color = MaterialTheme.colorScheme.onPrimaryContainer
        )
    }
}

@Preview(
    showBackground = true
)
@Composable
fun WelcomingMessagePreview() {
    EksFlorasiTheme {
        WelcomingMessage("Frans")
    }
}
