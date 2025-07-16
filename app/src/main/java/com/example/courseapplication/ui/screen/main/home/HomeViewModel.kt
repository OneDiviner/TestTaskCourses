package com.example.courseapplication.ui.screen.main.home

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.courseapplication.data.network.model.Course
import com.example.courseapplication.domain.FetchCoursesListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val fetchCoursesListUseCase: FetchCoursesListUseCase
) : ViewModel() {

    var coursesList by mutableStateOf<List<Course>>(emptyList())
        private set

    init {
        init()
    }

    private fun init() {
        viewModelScope.launch {
            coursesList = fetchCoursesListUseCase()
        }
    }
}