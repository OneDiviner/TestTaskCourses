package com.example.courseapplication.data.local.repository

import com.example.courseapplication.data.local.dao.CourseDao
import com.example.courseapplication.data.local.entity.CourseEntity
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class CourseDaoRepository @Inject constructor(
    private val courseDao: CourseDao
) : ICourseDaoRepository {
    override fun getAllCourses(): Flow<List<CourseEntity>> {
        return courseDao.getAllCourses()
    }

    override suspend fun insertCourse(course: CourseEntity) {
        courseDao.insertCourse(course)
    }

    override suspend fun deleteCourse(course: CourseEntity) {
        courseDao.deleteCourse(course)
    }
}