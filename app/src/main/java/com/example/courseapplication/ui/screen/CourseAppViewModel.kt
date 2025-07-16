package com.example.courseapplication.ui.screen

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CourseAppViewModel @Inject constructor(

) : ViewModel() {

    var courseAppState by mutableStateOf<CourseAppState>(CourseAppState.LogIn)
        private set

    fun onLogInButtonClick() {
        courseAppState = CourseAppState.Main
    }

}