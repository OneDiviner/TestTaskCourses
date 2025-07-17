package com.example.courseapplication.ui.screen.main.home

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.courseapplication.data.network.model.Course
import com.example.courseapplication.domain.CourseManager
import com.example.courseapplication.domain.mapper.CourseMapper.toEntity
import com.example.courseapplication.domain.useCase.DeleteCourseUseCase
import com.example.courseapplication.domain.useCase.FetchCoursesListUseCase
import com.example.courseapplication.domain.useCase.InsertCourseUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val insertCourseUseCase: InsertCourseUseCase,
    private val deleteCourseUseCase: DeleteCourseUseCase,
    private val courseManager: CourseManager
) : ViewModel() {

    var coursesList by mutableStateOf<List<Course>>(emptyList())
        private set

    init {
        init()
    }

    private fun init() {
        viewModelScope.launch {
            coursesList = courseManager.fetchAndInsertCourses()
        }
    }
    private fun sort() {
        coursesList = coursesList.sortedByDescending { it.publishDate }
    }

    fun onSortButtonClick() {
        sort()
    }

    fun toggleFavoriteStatus(courseId: Int) {
        viewModelScope.launch {
            val currentList = coursesList
            val courseIndex = currentList.indexOfFirst { it.id == courseId }

            if (courseIndex != -1) {
                val courseToUpdate = currentList[courseIndex]
                val updatedCourse = courseToUpdate.copy(hasLike = !courseToUpdate.hasLike)
                if (courseToUpdate.hasLike) {
                    deleteCourseUseCase(courseToUpdate)
                } else {
                    insertCourseUseCase(updatedCourse.toEntity())
                }
                val newList = currentList.toMutableList().apply {
                    this[courseIndex] = updatedCourse
                }.toList()

                coursesList = newList

            }
        }
    }
}