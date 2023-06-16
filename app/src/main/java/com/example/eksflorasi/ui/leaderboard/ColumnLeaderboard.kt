package com.example.eksflorasi.ui.leaderboard

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.eksflorasi.R
import com.example.eksflorasi.model.UserRank
import com.example.eksflorasi.ui.theme.EksFlorasiTheme

val dummyLeaderboardList = listOf(
    UserRank(
        name = "John",
        points = "100",
        avatarUrl = "https://example.com/avatar1.png",
        resourceId = 1
    ),
    UserRank(
        name = "Alice",
        points = "85",
        avatarUrl = "https://example.com/avatar2.png",
        resourceId = 2
    ),
    UserRank(
        name = "Bob",
        points = "70",
        avatarUrl = "https://example.com/avatar3.png",
        resourceId = 3,
        highlight = true
    ),
    UserRank(
        name = "Emily",
        points = "60",
        avatarUrl = "https://example.com/avatar4.png",
        resourceId = 4
    ),
    UserRank(
        name = "David",
        points = "50",
        avatarUrl = "https://example.com/avatar5.png",
        resourceId = 5
    ),
    UserRank(
        name = "Hendra",
        points = "40",
        avatarUrl = "https://example.com/avatar5.png",
        resourceId = 5
    ),
    UserRank(
        name = "Daniel",
        points = "30",
        avatarUrl = "https://example.com/avatar5.png",
        resourceId = 5
    ),
    UserRank(
        name = "James",
        points = "20",
        avatarUrl = "https://example.com/avatar5.png",
        resourceId = 5
    ),
    UserRank(
        name = "Jason",
        points = "10",
        avatarUrl = "https://example.com/avatar5.png",
        resourceId = 5
    )
)

@Composable
fun ColumnLeaderboard(modifier: Modifier, users: List<UserRank>) {
    var currentRank = 4;
    users.forEach { user ->
        user.rank = currentRank++
    }
    LazyColumn(modifier = modifier) {
        items(users) { user ->
            RankRow(modifier = Modifier.padding(vertical = 16.dp), user = user)
        }
    }
}

@Composable
fun RankRow(modifier: Modifier, user: UserRank) {
    val backgroundColor = if (user.highlight) MaterialTheme.colorScheme.secondaryContainer else Color.White
    Box(modifier = Modifier
        .clip(RoundedCornerShape(16.dp))
        .background(
        color = backgroundColor,
        shape = RoundedCornerShape(16.dp)
    )) {
        Row(modifier = modifier, verticalAlignment = Alignment.CenterVertically) {
            Text(
                modifier = Modifier.weight(1f),
                text = user.rank.toString(),
                textAlign = TextAlign.Center,
                color = MaterialTheme.colorScheme.primary,
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.SemiBold
            )
            Row(modifier = Modifier.weight(2f), verticalAlignment = Alignment.CenterVertically) {
                Image(
                    modifier = Modifier
                        .size(32.dp)
                        .clip(CircleShape)
                        .background(
                            color = Color.White,
                            shape = CircleShape
                        )
                        .border(
                            width = 2.dp,
                            color = MaterialTheme.colorScheme.primary,
                            shape = CircleShape
                        ),
                    painter = painterResource(id = R.drawable.avatar_example),
                    contentDescription = "avatar"
                )
                Text(
                    modifier = Modifier
                        .weight(1f)
                        .padding(horizontal = 8.dp),
                    text = user.name,
                    color = MaterialTheme.colorScheme.onPrimaryContainer,
                    style = MaterialTheme.typography.bodyLarge
                )
            }

            Row(modifier = Modifier.weight(1f), horizontalArrangement = Arrangement.Center) {
                Text(
                    text = user.points,
                    color = MaterialTheme.colorScheme.onPrimaryContainer,
                    style = MaterialTheme.typography.bodyLarge
                )
                Text(
                    text = " pts",
                    color = MaterialTheme.colorScheme.primary,
                    style = MaterialTheme.typography.bodyLarge,
                    fontWeight = FontWeight.SemiBold
                )
            }
        }
    }
}

@Preview(
    showBackground = true
)
@Composable
fun ColumnLeaderboardPreview() {
    EksFlorasiTheme() {
        ColumnLeaderboard(modifier = Modifier, users = dummyLeaderboardList)
    }
}