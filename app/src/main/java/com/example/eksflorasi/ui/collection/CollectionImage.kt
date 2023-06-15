package com.example.eksflorasi.ui.collection

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Eco
import androidx.compose.material.icons.filled.Pets
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.eksflorasi.R
import com.example.eksflorasi.ui.theme.fauna_outline
import com.example.eksflorasi.ui.theme.flora_outline

@Composable
fun CollectionImage(modifier: Modifier, imageRes: Int, type: String) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(172.dp)
    ) {
        ImageBox(modifier = modifier, imageRes = imageRes, type = type)
        TypeLabel(modifier = modifier.align(Alignment.BottomStart), type = type)
    }
}

@Composable
fun ImageBox(modifier: Modifier, imageRes: Int, type: String) {
    Box(
        modifier = modifier
            .fillMaxSize()
    ) {
        var backgroundColor: Color? = null

        if (type == "fauna") {
            backgroundColor = fauna_outline
        } else {
            backgroundColor = flora_outline
        }

        Box(
            modifier = modifier
                .fillMaxWidth(0.99f)
                .height(164.dp)
                .clip(RoundedCornerShape(16.dp))
                .background(
                    color = backgroundColor ?: MaterialTheme.colorScheme.tertiary,
                    shape = RoundedCornerShape(16.dp)
                )
                .align(Alignment.BottomCenter)
        ) {

        }
        Box(
            modifier = modifier
                .fillMaxWidth()
                .height(168.dp)
                .clip(RoundedCornerShape(16.dp))
                .background(
                    color = Color.Blue,
                    shape = RoundedCornerShape(16.dp)
                )
                .align(Alignment.TopCenter)
        ) {
            Image(
                painter = painterResource(id = imageRes),
                contentDescription = null,
                contentScale = ContentScale.FillBounds,
                modifier = modifier.fillMaxSize()
            )
        }
    }
}

@Composable
fun TypeLabel(modifier: Modifier, type: String) {
    var labelBackgroundColor: Color? = null
    var labelContentColor: Color? = null

    if (type == "fauna") {
        labelBackgroundColor = MaterialTheme.colorScheme.tertiaryContainer
        labelContentColor = MaterialTheme.colorScheme.tertiary
    }

    Box(
        modifier = modifier
            .padding(16.dp)
            .width(85.dp)
            .height(28.dp)
            .clip(RoundedCornerShape(16.dp))
            .background(
                color = labelBackgroundColor ?: MaterialTheme.colorScheme.tertiary,
                shape = RoundedCornerShape(16.dp)
            )
    ) {
        Row(
            modifier = Modifier.fillMaxSize(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            if (type == "fauna") {
                Icon(
                    imageVector = Icons.Filled.Pets,
                    contentDescription = "Fauna",
                    modifier = Modifier.size(18.dp),
                    tint = labelContentColor ?: MaterialTheme.colorScheme.tertiary,
                )

            } else {
                Icon(
                    imageVector = Icons.Filled.Eco,
                    contentDescription = "Flora",
                    modifier = Modifier.size(18.dp),
                    tint = labelContentColor ?: MaterialTheme.colorScheme.tertiary,
                )
            }
            Spacer(Modifier.width(4.dp))
            Text(
                text = "Fauna",
                color = labelContentColor ?: MaterialTheme.colorScheme.tertiary,
                style = MaterialTheme.typography.bodyMedium,
                textAlign = TextAlign.Center,
            )
        }
    }
}

@Preview
@Composable
fun PreviewCollectionImage() {
    CollectionImage(modifier = Modifier, imageRes = R.drawable.collection_example, type = "fauna")
}