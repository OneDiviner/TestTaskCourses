package com.example.courseapplication.domain.mapper

import com.example.courseapplication.data.local.entity.CourseEntity
import com.example.courseapplication.data.network.model.Course
import com.example.courseapplication.domain.mapper.CourseMapper.toCourse
import com.example.courseapplication.domain.mapper.CourseMapper.toEntity

object CourseMapper {
    fun Course.toEntity() : CourseEntity {
        return CourseEntity(
            id = id,
            title = title,
            description = description,
            price = price,
            rate = rate,
            startDate = startDate,
            publishDate = publishDate,
            hasLike = hasLike
        )
    }

    fun CourseEntity.toCourse() : Course {
        return Course(
            id = id,
            title = title,
            description = description,
            price = price,
            rate = rate,
            startDate = startDate,
            publishDate = publishDate,
            hasLike = hasLike
        )
    }
}

fun List<Course>.toEntityList() : List<CourseEntity> {
    return map { course ->
        course.toEntity()
    }
}

fun List<CourseEntity>.toCourseList() : List<Course> {
    return map { course ->
        course.toCourse()
    }
}