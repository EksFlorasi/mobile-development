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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.eksflorasi.R
import com.example.eksflorasi.ui.theme.EksFlorasiTheme
import com.example.eksflorasi.ui.theme.fauna_outline
import com.example.eksflorasi.ui.theme.flora_outline

@Composable
fun CollectionItem(
    modifier: Modifier,
    name: String,
    type: String
) {
    val backgroundColor =
        if (type == "flora") MaterialTheme.colorScheme.secondaryContainer else MaterialTheme.colorScheme.tertiaryContainer
    val textColor =
        if (type == "flora") MaterialTheme.colorScheme.onSecondaryContainer else MaterialTheme.colorScheme.onTertiaryContainer

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
            CollectionPhoto(type = type)
            Text(
                modifier = modifier.paddingFromBaseline(top = 20.dp, bottom = 4.dp),
                text = name,
                textAlign = TextAlign.Center,
                color = textColor,
                style = MaterialTheme.typography.labelLarge,
                fontWeight = FontWeight.Medium,
                letterSpacing = 0.1.sp
            )
        }
    }
}

@Composable
fun CollectionPhoto(type: String) {
    val outlineSize = 4.dp
    val imageSize = 72.dp
    val imageResId = R.drawable.flor_hi

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
                color = if (type == "flora")
                    flora_outline
                else fauna_outline,
                shape = CircleShape
            ),
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(id = imageResId),
            contentDescription = null,
            modifier = Modifier.size(imageSize),
            contentScale = ContentScale.Crop
        )
    }
}

@Preview(
    showBackground = true
)
@Composable
fun CollectionItemPreview() {
    EksFlorasiTheme {
        CollectionItem(modifier = Modifier, name = "Flor", type = "fauna")
    }
}

//val outlineColor = Color.Red
//val outlineSize = 4.dp
//val imageSize = 100.dp
//
//Box(
//modifier = Modifier
//.size(200.dp)
//.background(Color.LightGray)
//.padding(16.dp),
//contentAlignment = Alignment.Center
//) {
//    Box(
//        modifier = Modifier
//            .size(imageSize)
//            .clip(CircleShape)
//            .background(
//                color = outlineColor,
//                shape = CircleShape
//            )
//            .border(
//                width = outlineSize,
//                color = outlineColor,
//                shape = CircleShape
//            ),
//        contentAlignment = Alignment.Center
//    ) {
//        Image(
//            painter = rememberImagePainter(imageUrl),
//            contentDescription = null,
//            modifier = Modifier.size(imageSize),
//            contentScale = ContentScale.Crop
//        )
//    }
//}