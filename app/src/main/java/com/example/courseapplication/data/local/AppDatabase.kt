package com.example.courseapplication.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.courseapplication.data.local.dao.CourseDao
import com.example.courseapplication.data.local.entity.CourseEntity

@Database(entities = [CourseEntity::class], version = 1, exportSchema = true)
abstract class AppDatabase : RoomDatabase() {
    abstract fun courseDao(): CourseDao
}