package com.example.eksflorasi.ui.leaderboard

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
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.AlignmentLine
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.eksflorasi.R
import com.example.eksflorasi.model.UserRank
import com.example.eksflorasi.ui.theme.*

val dummyUserRankList = listOf(
    UserRank("John Doe", "100", "https://example.com/avatar1.png", R.drawable.avatar_example),
    UserRank("Jane Smith", "80", "https://example.com/avatar2.png", R.drawable.avatar_example),
    UserRank("Mike Johnson", "75", "https://example.com/avatar3.png", R.drawable.avatar_example),
)

val rankList = listOf(1, 0, 2)
val colorList = listOf(outline_rank_one, outline_rank_two, outline_rank_three)

@Composable
fun TopThreeLeaderboard(topUsers: List<UserRank>) {
    val center = Offset(530f, 0f)
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
        modifier = Modifier
            .fillMaxWidth()
            .height(260.dp)
            .clip(RoundedCornerShape(16.dp))
            .background(
                brush = brush,
                shape = RoundedCornerShape(16.dp)
            ),
    ) {
        Row(
            modifier = Modifier.fillMaxHeight()
        ) {
            for (index in rankList) {
                val modifier = if (index == 0) Modifier.align(Alignment.Top)
                else Modifier.align(Alignment.Bottom)
                TopRank(
                    modifier = modifier
                        .weight(1f)
                        .padding(vertical = 16.dp),
                    outlineColor = colorList[index],
                    resouriceId = topUsers[index].resourceId,
                    name = topUsers[index].name,
                    points = topUsers[index].points,
                    rank = (index + 1).toString()
                )
            }
        }
    }
}

@Composable
fun TopRank(
    modifier: Modifier,
    outlineColor: Color,
    resouriceId: Int,
    name: String,
    points: String,
    rank: String
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TopCircle(
            modifier = Modifier,
            outlineColor = outlineColor,
            resouriceId = resouriceId,
            rank = rank
        )
        UserPoints(name = name, points = points)
    }
}

@Composable
fun TopCircle(modifier: Modifier, outlineColor: Color, resouriceId: Int, rank: String) {
    val outlineSize = 4.dp
    val imageSize = 115.dp
    val numberSize = 32.dp

    Box(
        modifier = modifier
            .size(numberSize)
            .clip(CircleShape)
            .background(
                color = outlineColor,
                shape = CircleShape
            ),
        contentAlignment = Alignment.Center
    ) {
        Text(
            modifier = Modifier.align(Alignment.Center),
            text = rank,
            style = MaterialTheme.typography.headlineSmall,
            color = Color.White,
            fontWeight = FontWeight.Bold
        )
    }

    Box(
        contentAlignment = Alignment.Center
    ) {
        Box(
            modifier = Modifier
                .size(imageSize)
                .clip(CircleShape)
                .background(
                    color = Color.White,
                    shape = CircleShape
                )
                .border(
                    width = outlineSize,
                    color = outlineColor,
                    shape = CircleShape
                ),
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = painterResource(resouriceId),
                contentDescription = null,
                modifier = Modifier.size(imageSize),
                contentScale = ContentScale.Crop
            )
        }
    }
}

@Composable
fun UserPoints(name: String, points: String) {
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = name,
            style = MaterialTheme.typography.titleSmall,
            color = MaterialTheme.colorScheme.onPrimary
        )
        Row() {
            Text(
                text = points,
                style = MaterialTheme.typography.labelMedium,
                color = MaterialTheme.colorScheme.onPrimary,
            )
            Text(
                text = " pts",
                style = MaterialTheme.typography.labelMedium,
                color = MaterialTheme.colorScheme.primary,
                fontWeight = FontWeight.Bold
            )
        }
    }
}

@Preview(
    showBackground = true
)
@Composable
fun TopThreeLeaderboardPreview() {
    EksFlorasiTheme() {
        TopThreeLeaderboard(topUsers = dummyUserRankList)
    }
}