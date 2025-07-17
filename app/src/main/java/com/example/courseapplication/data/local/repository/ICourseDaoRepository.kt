package com.example.courseapplication.data.local.repository

import com.example.courseapplication.data.local.entity.CourseEntity
import kotlinx.coroutines.flow.Flow

interface ICourseDaoRepository {
    fun getAllCourses(): Flow<List<CourseEntity>>

    suspend fun insertCourse(course: CourseEntity)

    suspend fun deleteCourse(course: CourseEntity)

}