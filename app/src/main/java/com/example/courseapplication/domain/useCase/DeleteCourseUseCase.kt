package com.example.courseapplication.domain.useCase

import com.example.courseapplication.data.local.repository.ICourseDaoRepository
import com.example.courseapplication.data.network.model.Course
import com.example.courseapplication.data.network.repository.ICourseRepository
import com.example.courseapplication.domain.mapper.CourseMapper.toEntity
import javax.inject.Inject

class DeleteCourseUseCase @Inject constructor(
    private val repository: ICourseDaoRepository
) {
    suspend operator fun invoke(course: Course) { repository.deleteCourse(course.toEntity()) }

}