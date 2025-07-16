package com.example.courseapplication.ui.screen

import androidx.compose.animation.AnimatedContent
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.courseapplication.ui.screen.logIn.LogInScreen
import com.example.courseapplication.ui.screen.main.Main

@Composable
fun CourseApp(
    viewModel: CourseAppViewModel = hiltViewModel(),
) {
    AnimatedContent(
        targetState = viewModel.courseAppState,
    ) {
        when(it) {
            CourseAppState.LogIn -> {
                LogInScreen() {
                    viewModel.onLogInButtonClick()
                }
            }
            CourseAppState.Main -> {
                Main()
            }
        }
    }
}