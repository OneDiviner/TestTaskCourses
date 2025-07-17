package com.example.courseapplication.domain.useCase

import com.example.courseapplication.data.local.entity.CourseEntity
import com.example.courseapplication.data.local.repository.ICourseDaoRepository
import javax.inject.Inject

class InsertCourseUseCase @Inject constructor(
    private val repository: ICourseDaoRepository
) {
    suspend operator fun invoke(course: CourseEntity) {
        repository.insertCourse(course)
    }
}