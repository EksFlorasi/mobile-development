package com.example.eksflorasi.ui.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.eksflorasi.ui.theme.EksFlorasiTheme
import com.example.eksflorasi.ui.theme.center_radial_gradient
import com.example.eksflorasi.ui.theme.middle_radial_gradient
import com.example.eksflorasi.ui.theme.outer_radial_gradient

@Composable
fun Stats(modifier: Modifier) {
    Box(
        modifier = modifier.wrapContentSize(),
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = modifier.wrapContentSize(),
            verticalArrangement = Arrangement.SpaceEvenly
        ) {
            Row(
                modifier = modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                SmallStatBox(description = "Your points", quantity = "1000", modifier = Modifier, unit = " pts")
                SmallStatBox(description = "Streak", quantity = "3", modifier = Modifier, unit = " days")
            }
            Spacer(modifier = Modifier.height(16.dp))
            Row() {
                LargeStatBox(description = "Your Rank", quantity = "7", modifier = Modifier, unit = " th")
            }
        }
    }

}

@Composable
fun SmallStatBox(
    description: String,
    quantity: String,
    unit: String,
    modifier: Modifier,
) {
    val center = Offset(250f, 400f)
    val brush = Brush.radialGradient(
        colors = listOf(
            center_radial_gradient,
            center_radial_gradient,
            middle_radial_gradient,
            outer_radial_gradient,
            outer_radial_gradient
        ),
        center = center,
        radius = 600f
    )

    Box(
        modifier = modifier
            .background(
                brush = brush,
                shape = RoundedCornerShape(16.dp)
            )
            .padding(4.dp),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                modifier = modifier.padding(top = 8.dp),
                text = description,
                color = MaterialTheme.colorScheme.onPrimary,
                style = MaterialTheme.typography.labelLarge
            )

            Box(
                modifier = modifier
                    .padding(8.dp)
                    .background(
                        color = MaterialTheme.colorScheme.secondaryContainer,
                        shape = RoundedCornerShape(16.dp)
                    ),
                contentAlignment = Alignment.Center
            ) {
                Row(
                    modifier = modifier
                        .padding(vertical = 4.dp)
                        .padding(horizontal = 40.dp)
                ) {
                    Text(
                        text = quantity,
                        color = MaterialTheme.colorScheme.primary,
                        style = MaterialTheme.typography.bodyMedium,
                        fontWeight = FontWeight.Medium,
                    )
                    Text(
                        text = unit,
                        color = MaterialTheme.colorScheme.primary,
                        style = MaterialTheme.typography.labelLarge
                    )
                }
            }
        }
    }
}

@Composable
fun LargeStatBox(
    description: String,
    quantity: String,
    unit: String,
    modifier: Modifier,
) {
    val center = Offset(560f, 980f)
    val brush = Brush.radialGradient(
        colors = listOf(
            center_radial_gradient,
            center_radial_gradient,
            center_radial_gradient,
            center_radial_gradient,
            middle_radial_gradient,
            outer_radial_gradient,
            outer_radial_gradient,
            outer_radial_gradient,
            outer_radial_gradient,
            outer_radial_gradient
        ),
        center = center,
        radius = 2000f
    )

    Box(
        modifier = modifier
            .background(
                brush = brush,
                shape = RoundedCornerShape(16.dp)
            )
            .fillMaxWidth()
            .height(100.dp)
            .padding(4.dp),
        contentAlignment = Alignment.Center
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Text(
                modifier = modifier.padding(top = 8.dp),
                text = description,
                color = MaterialTheme.colorScheme.onPrimary,
                style = MaterialTheme.typography.labelLarge
            )

            Box(
                modifier = modifier
                    .padding(8.dp)
                    .background(
                        color = MaterialTheme.colorScheme.secondaryContainer,
                        shape = RoundedCornerShape(16.dp)
                    ),
                contentAlignment = Alignment.Center
            ) {
                Row(
                    modifier = modifier
                        .padding(vertical = 4.dp)
                        .padding(horizontal = 20.dp)
                ) {
                    Text(
                        text = quantity,
                        color = MaterialTheme.colorScheme.primary,
                        style = MaterialTheme.typography.bodyMedium,
                        fontWeight = FontWeight.Medium
                    )
                    Text(
                        text = unit,
                        color = MaterialTheme.colorScheme.primary,
                        style = MaterialTheme.typography.labelLarge
                    )
                }
            }
        }
    }
}

@Preview(
    showBackground = true
)
@Composable
fun StatsPreview() {
    EksFlorasiTheme {
        Stats(Modifier)
    }
}