package com.bosleo.studentapp.data.pojo

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Student(
    val clasId: String,
    @PrimaryKey val id: String,
    val name: String,
    val roll_number: Int
)