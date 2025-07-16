package com.example.courseapplication.data.network.repository

import com.example.courseapplication.data.network.ApiService
import com.example.courseapplication.data.network.model.CoursesResponse
import javax.inject.Inject

class CourseRepository @Inject constructor(
    private val apiService: ApiService
) : ICourseRepository  {
    private val fileUrl = "https://drive.usercontent.google.com/u/0/uc?id=15arTK7XT2b7Yv4BJsmDctA4Hg-BbS8-q&export=download"

    override suspend fun getCourses(): Result<CoursesResponse> {
        return try {
            val response = apiService.getCourses(fileUrl = fileUrl)
            Result.success(response.body() ?: throw Exception("Empty response body"))
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}