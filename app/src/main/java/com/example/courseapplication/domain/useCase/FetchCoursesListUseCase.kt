package com.example.courseapplication.domain.useCase

import com.example.courseapplication.data.network.model.Course
import com.example.courseapplication.data.network.repository.ICourseRepository
import javax.inject.Inject

class FetchCoursesListUseCase @Inject constructor(
    private val repository: ICourseRepository
) {
    suspend operator fun invoke() : List<Course> {
        val result = repository.getCourses()
        result.onSuccess {
            return it.courses
        }
        return emptyList()
    }
}