package com.example.courseapplication.ui.component.textField

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.courseapplication.R
import com.example.courseapplication.ui.theme.White

@Composable
fun SearchTextField(
    modifier: Modifier = Modifier,
    value: String,
    onValueChange: (String) -> Unit
) {
    TextField(
        modifier = modifier.height(56.dp),
        value = value,
        onValueChange = onValueChange,
        colors = TextFieldDefaults.colors(
            disabledContainerColor = MaterialTheme.colorScheme.primary,
            errorIndicatorColor = Color.Transparent,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            disabledIndicatorColor = Color.Transparent,
            unfocusedContainerColor = MaterialTheme.colorScheme.surfaceContainer
        ),
        placeholder = {
            Text(
                text = "Search courses...",
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onBackground.copy(alpha = 0.7f)
            )
        },
        shape = RoundedCornerShape(28.dp),
        leadingIcon = {
            Icon(
                modifier = Modifier.size(48.dp).padding(start = 4.dp),
                painter = painterResource(R.drawable.icon_search),
                contentDescription = "search_icon",
                tint = White
            )
        }
    )
}