package com.example.courseapplication.data.network

import com.example.courseapplication.data.network.model.CoursesResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Url

interface ApiService {
    @GET
    suspend fun getCourses(@Url fileUrl: String): Response<CoursesResponse>
}