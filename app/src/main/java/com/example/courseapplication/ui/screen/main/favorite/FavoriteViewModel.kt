package com.example.courseapplication.ui.screen.main.favorite

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.courseapplication.data.local.entity.CourseEntity
import com.example.courseapplication.data.network.model.Course
import com.example.courseapplication.domain.useCase.SelectCourseFlowListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FavoriteViewModel @Inject constructor(
    private val selectCourseFlowListUseCase: SelectCourseFlowListUseCase
) : ViewModel() {

    private val _courseFlow = MutableStateFlow<List<Course>>(emptyList())
    val courseFlow: StateFlow<List<Course>> = _courseFlow.asStateFlow()

    init {
        init()
    }

    private fun init() {
        viewModelScope.launch {
            selectCourseFlowListUseCase().collect {
                _courseFlow.value = it
            }
        }
    }

}