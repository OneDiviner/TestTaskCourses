package com.example.courseapplication.ui.component.card

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.example.courseapplication.R
import com.example.courseapplication.data.network.model.Course
import com.example.courseapplication.ui.theme.ClassmatesGradient
import com.example.courseapplication.ui.theme.Glass
import com.example.courseapplication.ui.theme.White
import dev.chrisbanes.haze.HazeDefaults
import dev.chrisbanes.haze.HazeState
import dev.chrisbanes.haze.hazeEffect
import dev.chrisbanes.haze.hazeSource
import dev.chrisbanes.haze.rememberHazeState
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.Locale
import kotlin.text.format

@RequiresApi(Build.VERSION_CODES.O)
internal fun convertIsoDateToHumanReadable(isoDate: String): String {
    return try {
        val date = LocalDate.parse(isoDate)
        val outputFormatter = DateTimeFormatter.ofPattern("dd MMMM yyyy", Locale.forLanguageTag("ru"))
        date.format(outputFormatter)
    } catch (e: Exception) {
        isoDate
    }
}

@Composable
fun FavoriteButton(
    modifier: Modifier = Modifier,
    hasLike: Boolean,
    hazeState: HazeState,
    onClick: () -> Unit
) {
    Button(
        modifier = modifier
            .clip(RoundedCornerShape(12.dp))
            .hazeEffect(
                state = hazeState, style = HazeDefaults.style(
                    backgroundColor = Glass,
                    blurRadius = 12.dp
                )
            )
            .size(28.dp),
        onClick = {
            onClick()
        },
        colors = ButtonDefaults.buttonColors(
            contentColor = White,
            containerColor = Glass
        ),
        contentPadding = PaddingValues(0.dp)
    ) {
        if (hasLike)
            Icon(
                modifier = Modifier.size(16.dp),
                painter = painterResource(R.drawable.bookmark_fill),
                contentDescription = "favorite_button_liked",
                tint = MaterialTheme.colorScheme.primary
            )
        else {
            Icon(
                modifier = Modifier.size(16.dp),
                painter = painterResource(R.drawable.bookmark),
                contentDescription = "favorite_button_not_liked"
            )
        }
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun CourseCard(
    modifier: Modifier = Modifier,
    course: Course,
    onFavoriteButtonClick: () -> Unit = {},
    onClick: () -> Unit
)  {
    val hazeState = rememberHazeState()

    Card(
        modifier = modifier
            .fillMaxWidth()
            .aspectRatio(1.5f),
        onClick = onClick,
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surfaceContainer
        ),
        shape = RoundedCornerShape(16.dp)
    ) {
        Box(
            modifier = Modifier.fillMaxWidth()
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .aspectRatio(3.2f)
                    .hazeSource(state = hazeState)
                    .background(
                        brush = Brush.linearGradient(ClassmatesGradient),
                        shape = RoundedCornerShape(12.dp)
                    )
            ) {

            }
            FavoriteButton(
                modifier = Modifier
                    .align(Alignment.TopEnd)
                    .padding(8.dp),
                hasLike = course.hasLike,
                hazeState = hazeState,
                onClick = onFavoriteButtonClick
            )
            Row(
                modifier = Modifier
                    .align(Alignment.BottomStart)
                    .padding(8.dp),
                horizontalArrangement = Arrangement.spacedBy(4.dp)
            ) {
                Box(
                    modifier = Modifier
                        .clip(RoundedCornerShape(12.dp))
                        .hazeEffect(
                            state = hazeState, style = HazeDefaults.style(
                                backgroundColor = Glass,
                                blurRadius = 12.dp
                            )
                        ),
                    contentAlignment = Alignment.Center
                ) {
                    Row(
                        modifier = Modifier.padding(horizontal = 6.dp, vertical = 4.dp)
                    ) {
                        Icon(
                            modifier = Modifier.size(12.dp),
                            painter = painterResource(R.drawable.star_fill),
                            contentDescription = null,
                            tint = MaterialTheme.colorScheme.primary
                        )
                        Text(
                            text = course.rate,
                            style = MaterialTheme.typography.displaySmall
                        )
                    }
                }
                Box(
                    modifier = Modifier
                        .clip(RoundedCornerShape(12.dp))
                        .hazeEffect(
                            state = hazeState, style = HazeDefaults.style(
                                backgroundColor = Glass,
                                blurRadius = 12.dp
                            )
                        ),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        modifier = Modifier.padding(horizontal = 6.dp, vertical = 4.dp),
                        text = convertIsoDateToHumanReadable(course.publishDate),
                        style = MaterialTheme.typography.displaySmall
                    )
                }
            }
        }
        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            Text(
                text = course.title,
                style = MaterialTheme.typography.titleMedium
            )
            Text(
                text = course.description,
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onBackground.copy(0.7f),
                maxLines = 2,
                overflow = TextOverflow.Ellipsis
            )
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "${course.price} ₽",
                    style = MaterialTheme.typography.titleMedium
                )
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "Подробнее",
                        style = MaterialTheme.typography.labelSmall,
                        color = MaterialTheme.colorScheme.primary
                    )
                    Icon(
                        modifier = Modifier.size(16.dp),
                        painter = painterResource(R.drawable.arrow_right_short_fill),
                        contentDescription = null,
                        tint = MaterialTheme.colorScheme.primary
                    )
                }
            }
        }
    }
}