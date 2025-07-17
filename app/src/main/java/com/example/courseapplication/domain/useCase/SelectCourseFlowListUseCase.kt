package com.example.courseapplication.domain.useCase

import com.example.courseapplication.data.local.entity.CourseEntity
import com.example.courseapplication.data.local.repository.ICourseDaoRepository
import com.example.courseapplication.data.network.model.Course
import com.example.courseapplication.domain.mapper.toCourseList
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class SelectCourseFlowListUseCase @Inject constructor(
    private val repository: ICourseDaoRepository
) {
    operator fun invoke() : Flow<List<Course>> {
        return repository.getAllCourses().map { list ->
            list.toCourseList()
        }
    }
}