package com.example.courseapplication.data.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "courses")
data class CourseEntity(
    @PrimaryKey
    @ColumnInfo(name = "id")
    val id: Int,

    @ColumnInfo(name = "title")
    val title: String,

    @ColumnInfo(name = "description")
    val description: String,

    @ColumnInfo(name = "price")
    val price: String,

    @ColumnInfo(name = "rate")
    val rate: String,

    @ColumnInfo(name = "start_date")
    val startDate: String,

    @ColumnInfo(name = "has_like")
    val hasLike: Boolean,

    @ColumnInfo(name = "publish_date")
    val publishDate: String
)