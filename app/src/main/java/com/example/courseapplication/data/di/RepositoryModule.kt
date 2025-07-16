package com.example.courseapplication.data.di

import com.example.courseapplication.data.network.repository.CourseRepository
import com.example.courseapplication.data.network.repository.ICourseRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Binds
    @Singleton
    abstract fun bindCourseRepository(repository: CourseRepository) : ICourseRepository
}