package com.example.courseapplication.data.network.model

import com.google.gson.annotations.SerializedName

data class CoursesResponse(
    @SerializedName("courses")
    val courses: List<Course>
)

data class Course(
    @SerializedName("id")
    val id: Int,

    @SerializedName("title")
    val title: String,

    @SerializedName("text")
    val description: String,

    @SerializedName("price")
    val price: String,

    @SerializedName("rate")
    val rate: String,

    @SerializedName("startDate")
    val startDate: String,

    @SerializedName("hasLike")
    val hasLike: Boolean,

    @SerializedName("publishDate")
    val publishDate: String
)