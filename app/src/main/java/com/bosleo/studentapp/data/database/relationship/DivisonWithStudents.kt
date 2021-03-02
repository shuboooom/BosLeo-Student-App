package com.bosleo.studentapp.data.database.relationship

import androidx.room.Embedded
import androidx.room.Relation
import com.bosleo.studentapp.data.pojo.Divison
import com.bosleo.studentapp.data.pojo.Student

data class DivisonWithStudents (
        @Embedded val divison: Divison,
        @Relation(parentColumn = "division_id",entityColumn = "clasId")
        val students : List<Student>
)