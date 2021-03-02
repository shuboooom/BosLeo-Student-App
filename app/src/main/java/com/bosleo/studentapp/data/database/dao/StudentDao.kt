package com.bosleo.studentapp.data.database.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.bosleo.studentapp.data.database.relationship.DivisonWithStudents
import com.bosleo.studentapp.data.pojo.Divison
import com.bosleo.studentapp.data.pojo.Student

@Dao
interface StudentDao{

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    @Transaction suspend fun insertAllDivision(student: List<Divison>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    @Transaction suspend fun insertAllStudents(student: List<Student>)

    @Query("select * From divison")
    fun fetchDivison() : LiveData<List<DivisonWithStudents>>

    @Query("select * From student left join divison on (divison.division_id  = student.clasId ) where isSelected = 1")
    fun  fetchOnlySelected() : LiveData<List<Student>>

    @Query("update student set isSelected =:value where id =:student_id")
    suspend fun checkUnCheck(student_id : String,value : String)

    @Query("update student set isSelected = 0")
    suspend fun uncheckAll()

}