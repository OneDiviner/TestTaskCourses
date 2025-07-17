package com.example.courseapplication.domain

import com.example.courseapplication.data.network.model.Course
import com.example.courseapplication.domain.mapper.CourseMapper.toEntity
import com.example.courseapplication.domain.useCase.FetchCoursesListUseCase
import com.example.courseapplication.domain.useCase.InsertCourseUseCase
import javax.inject.Inject

class CourseManager @Inject constructor(
    private val fetchCoursesListUseCase: FetchCoursesListUseCase,
    private val insertCourseUseCase: InsertCourseUseCase
) {
    suspend fun fetchAndInsertCourses() : List<Course> {
        val courses = fetchCoursesListUseCase()
        courses.forEach { course ->
            if (course.hasLike) {
                insertCourseUseCase(course.toEntity())
            }
        }
        return courses
    }
}