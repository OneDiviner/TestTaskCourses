package com.example.courseapplication.ui.screen.main.home

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.courseapplication.R
import com.example.courseapplication.ui.component.card.CourseCard
import com.example.courseapplication.ui.component.textField.SearchTextField
import com.example.courseapplication.ui.theme.White

@RequiresApi(Build.VERSION_CODES.S)
@Composable
fun HomeScreen(
    viewModel: HomeViewModel = hiltViewModel(),
    paddingValues: PaddingValues? = null,
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(paddingValues ?: PaddingValues(0.dp)),
        contentAlignment = Alignment.TopCenter,
    ) {
        LazyColumn(
            modifier = Modifier.padding(top = 16.dp, start = 16.dp, end = 16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            item {
                Row(
                    modifier = Modifier.fillMaxSize(),
                    horizontalArrangement = Arrangement.spacedBy(8.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    SearchTextField(
                        modifier = Modifier.weight(1f),
                        value = "",
                        onValueChange = {}
                    )

                    Button (
                        modifier = Modifier.size(56.dp),
                        onClick = {},
                        colors = ButtonDefaults.buttonColors(
                            contentColor = White,
                            containerColor = MaterialTheme.colorScheme.surfaceContainer
                        ),
                        contentPadding = PaddingValues(0.dp)
                    ) {
                        Icon(
                            modifier = Modifier.size(24.dp),
                            painter = painterResource(R.drawable.funnel),
                            contentDescription = "filter_button"
                        )
                    }
                }
            }
            item {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                ) {
                    Row(
                        modifier = Modifier
                            .align(Alignment.CenterEnd)
                            .clickable {
                                viewModel.onSortButtonClick()
                            },
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = "По дате добавления",
                            textAlign = TextAlign.End,
                            style = MaterialTheme.typography.labelLarge,
                            color = MaterialTheme.colorScheme.primary
                        )
                        Icon(
                            modifier = Modifier.size(16.dp),
                            painter = painterResource(R.drawable.arrow_down_up),
                            contentDescription = null,
                            tint = MaterialTheme.colorScheme.primary
                        )
                    }
                }
            }
            items(viewModel.coursesList) { course ->
                CourseCard(
                    modifier = Modifier,
                    course = course,
                    onFavoriteButtonClick = {viewModel.toggleFavoriteStatus(course.id)},
                    onClick = {}
                )
                if (course == viewModel.coursesList.last()) {
                    Spacer(modifier = Modifier.size(16.dp))
                }
            }
        }
    }
}