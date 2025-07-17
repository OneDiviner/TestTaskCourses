package com.example.courseapplication.ui.screen.main.favorite

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.courseapplication.data.network.model.Course
import com.example.courseapplication.ui.component.card.CourseCard

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun FavoriteScreen(
    viewModel: FavoriteViewModel = hiltViewModel(),
    paddingValues: PaddingValues? = null,
) {

    val coursesList by viewModel.courseFlow.collectAsState()

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(paddingValues ?: PaddingValues(0.dp))
            .padding(all = 16.dp),
        contentAlignment = Alignment.TopStart,
    ) {
        LazyColumn(
            modifier = Modifier,
            verticalArrangement = Arrangement.spacedBy(28.dp)
        ) {
            item {
                Text(
                    text = "Избранное",
                    style = MaterialTheme.typography.titleLarge
                )
            }
            if (coursesList.isEmpty()) {
                item {
                    Text(
                        modifier = Modifier.fillMaxWidth(),
                        text = "У вас нет сохраненных курсов",
                        textAlign = TextAlign.Center,
                        style = MaterialTheme.typography.titleMedium
                    )
                }
            } else {
                items(coursesList) { course ->
                    CourseCard(
                        modifier = Modifier,
                        course = course,
                        onFavoriteButtonClick = {},
                        onClick = {}
                    )
                    if (course == coursesList.last()) {
                        Spacer(modifier = Modifier.size(16.dp))
                    }
                }
            }
        }
    }
}