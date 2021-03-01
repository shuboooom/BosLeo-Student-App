package com.bosleo.studentapp.data.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.bosleo.studentapp.data.pojo.Student

@Dao
interface StudentDao{

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend  fun insert(student: Student) : Long

    @Query("select * From student ORDER BY id ASC")
    fun  fetch() : LiveData<MutableList<Student>>

}