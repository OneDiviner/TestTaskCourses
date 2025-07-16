package com.example.courseapplication.ui.screen

sealed class CourseAppState {
    data object LogIn: CourseAppState()
    data object Main: CourseAppState()
}