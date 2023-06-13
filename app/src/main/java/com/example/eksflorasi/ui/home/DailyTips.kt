package com.example.eksflorasi.ui.home

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.eksflorasi.ui.theme.EksFlorasiTheme

fun DailyTips() {
}

@Composable
fun BubbleChat(message: String, isSender: Boolean) {
    val backgroundColor = if (isSender) {
        Color(0xFFDCF8C6)
    } else {
        Color(0xFFFFFFFF)
    }

    Surface(
        shape = RoundedCornerShape(16.dp),
        color = backgroundColor,
        modifier = Modifier.padding(8.dp)
    ) {
        Box(
            modifier = Modifier.padding(8.dp)
        ) {
            Column {
                Text(
                    text = message,
                    style = TextStyle(fontSize = 16.sp),
                    color = if (isSender) Color.Black else Color.Gray,
                    modifier = Modifier.padding(bottom = 4.dp)
                )
                Text(
                    text = "12:34 PM",
                    style = TextStyle(fontSize = 12.sp),
                    color = Color.Gray
                )
            }
        }
    }
}

@Preview(
    showBackground = true
)
@Composable
fun DailyTipsPreview() {
    EksFlorasiTheme {
        BubbleChat(message = "TEST", isSender = true)
    }
}