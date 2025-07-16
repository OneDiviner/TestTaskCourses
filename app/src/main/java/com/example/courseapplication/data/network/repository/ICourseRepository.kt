package com.example.courseapplication.data.network.repository

import com.example.courseapplication.data.network.model.CoursesResponse

interface ICourseRepository {
    suspend fun getCourses() : Result<CoursesResponse>
}