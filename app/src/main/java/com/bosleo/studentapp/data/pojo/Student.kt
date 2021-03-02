package com.bosleo.studentapp.data.pojo

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Student(
    @PrimaryKey var id: String,
    var clasId: String = "",
    var name: String = "",
    var roll_number: Int = 0,
    var isSelected: Boolean = false,
)