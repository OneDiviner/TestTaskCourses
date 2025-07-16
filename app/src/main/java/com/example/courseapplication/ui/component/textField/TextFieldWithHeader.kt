package com.example.courseapplication.ui.component.textField

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun TextFieldWithHeader(
    modifier: Modifier = Modifier,
    header: String,
    supportingText: String? = null,
    textField: @Composable () -> Unit,
) {
    Column(
        modifier = modifier.fillMaxWidth().wrapContentSize(),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Text(
            modifier = Modifier,
            text = header,
            style = MaterialTheme.typography.titleMedium,
            color = MaterialTheme.colorScheme.onBackground
        )
        Column {
            textField()
            AnimatedVisibility(
                visible = supportingText != null
            ) {
                Text(
                    modifier = Modifier,
                    text = supportingText ?: "",
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.error
                )
            }
        }
    }
}