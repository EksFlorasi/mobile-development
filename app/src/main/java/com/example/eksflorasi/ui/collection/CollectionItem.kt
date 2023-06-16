package com.example.eksflorasi.ui.collection

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberImagePainter
import com.example.eksflorasi.R
import com.example.eksflorasi.model.Collection
import com.example.eksflorasi.ui.theme.fauna_outline
import com.example.eksflorasi.ui.theme.flora_outline

@Composable
fun CollectionItem(
    modifier: Modifier,
    collection: Collection
) {
    val backgroundColor =
        if (collection.type == "flora") MaterialTheme.colorScheme.secondaryContainer else MaterialTheme.colorScheme.tertiaryContainer
    val textColor =
        if (collection.type == "flora") MaterialTheme.colorScheme.onSecondaryContainer else MaterialTheme.colorScheme.onTertiaryContainer

    Box(
        modifier = Modifier
            .background(
                color = backgroundColor,
                shape = RoundedCornerShape(16.dp)
            )
            .padding(16.dp),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            CollectionPhoto(collection)
            Text(
                modifier = modifier.paddingFromBaseline(top = 20.dp, bottom = 4.dp),
                text = collection.name,
                textAlign = TextAlign.Center,
                color = textColor,
                style = MaterialTheme.typography.labelLarge,
                fontWeight = FontWeight.Medium,
                letterSpacing = 0.1.sp,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
        }
    }
}

@Composable
fun CollectionPhoto(collection: Collection) {
    val outlineSize = 4.dp
    val imageSize = 72.dp

    Box(
        modifier = Modifier
            .size(imageSize)
            .clip(CircleShape)
            .background(
                color = Color.Transparent,
                shape = CircleShape
            )
            .border(
                width = outlineSize,
                color = if (collection.type == "flora")
                    flora_outline
                else fauna_outline,
                shape = CircleShape
            ),
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = rememberImagePainter(data = collection.photoUrl),
            contentDescription = null,
            modifier = Modifier.size(imageSize),
            contentScale = ContentScale.Crop
        )
    }
}