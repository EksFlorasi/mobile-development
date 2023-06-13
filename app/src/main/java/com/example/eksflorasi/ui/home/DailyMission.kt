package com.example.eksflorasi.ui.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.eksflorasi.ui.theme.EksFlorasiTheme

@Composable
fun DailyMission(modifier: Modifier) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier
            .background(
                color = MaterialTheme.colorScheme.secondaryContainer,
                shape = RoundedCornerShape(16.dp)
            )
            .padding(vertical = 8.dp)
            .fillMaxWidth()
    ) {
        Column(
            modifier = Modifier.width(240.dp).wrapContentSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Collect 100 points per day to maintain your streak!",
                textAlign = TextAlign.Center,
                color = MaterialTheme.colorScheme.onSecondaryContainer,
                style = MaterialTheme.typography.bodyMedium,
            )

            PointsCollected()
        }
    }
}

@Composable
fun PointsCollected(){
    Row() {
        Text(
            text = "Points collected today: ",
            color = MaterialTheme.colorScheme.onSecondaryContainer,
            style = MaterialTheme.typography.bodySmall
        )

        Text(
            text = "10",
            color = MaterialTheme.colorScheme.primary,
            style = MaterialTheme.typography.bodyMedium,
            fontWeight = FontWeight.Medium
        )

        Text(
            text = "/100 ",
            color = MaterialTheme.colorScheme.onSecondaryContainer,
            style = MaterialTheme.typography.bodyMedium
        )

        Text(
            text = "pts",
            color = MaterialTheme.colorScheme.primary,
            style = MaterialTheme.typography.labelLarge
        )
    }
}

@Preview(
    showBackground = true
)
@Composable
fun DailyMissionPreview() {
    EksFlorasiTheme {
        DailyMission(Modifier)
    }
}