package com.bosleo.studentapp.data.pojo

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey

@Entity
data class Divison(

    @ColumnInfo(name = "division_name") var division: String = "",
    @PrimaryKey @ColumnInfo(name = "division_id") var id: String = "",
    @Ignore var students: List<Student> = ArrayList()
)