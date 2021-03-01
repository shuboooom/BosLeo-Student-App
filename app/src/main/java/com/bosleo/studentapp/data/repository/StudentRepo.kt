package com.bosleo.studentapp.data.repository

import androidx.lifecycle.LiveData
import com.bosleo.studentapp.api.ApiService
import com.bosleo.studentapp.api.RetrofitBuilder
import com.bosleo.studentapp.data.database.StudentDao
import com.bosleo.studentapp.data.pojo.Divison
import com.bosleo.studentapp.data.pojo.Student
import javax.inject.Inject

class StudentRepo @Inject constructor(private val studentDao: StudentDao) {

    suspend fun getClassData()
    {
        try {
            val apiService: ApiService = RetrofitBuilder.getRetrofit().create(ApiService::class.java)
            val res = apiService.getClassData()
            if(res.isSuccessful)
            {
                res.body()?.let {

                    divisions ->
                    val students = mutableListOf<Student>()
                    divisions.forEach {
                        students.addAll(it.students)
                    }

                    insertAllDivision(divisions)
                    insertAllStudents(students)
                }
            }
        }
        catch (e : Exception)
        {
            e.printStackTrace()
            //return null
        }

        //return null
    }

    fun getAllStudents(): LiveData<List<Student>> {
        return studentDao.fetch()
    }

    fun getSelectedStudents(): LiveData<List<Student>> {
        return studentDao.fetchOnlySelected()
    }

    private suspend fun insertAllDivision(divisons : List<Divison>) {
        return studentDao.insertAllDivision(divisons)
    }

    private suspend fun insertAllStudents(students : List<Student>) {
        return studentDao.insertAllStudents(students)
    }

    suspend fun checkUncheck(student_id : String,value : Boolean) {
        return studentDao.checkUnCheck(student_id,if(value){"1"}else{"0"})
    }

    suspend fun uncheckAll() {
        return studentDao.uncheckAll()
    }

}