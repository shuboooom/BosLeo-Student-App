package com.bosleo.studentapp.data.pojo

import androidx.annotation.NonNull
import androidx.room.*

@Entity
data class Divison(

    @ColumnInfo(name = "division_name") var division: String = "",
    @PrimaryKey @ColumnInfo(name = "division_id") var id: String = "",
    @Ignore var students: List<Student> = ArrayList()
)