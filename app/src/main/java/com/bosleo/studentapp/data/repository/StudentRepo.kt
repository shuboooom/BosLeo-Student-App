package com.bosleo.studentapp.data.repository

import androidx.lifecycle.LiveData
import com.bosleo.studentapp.api.ApiService
import com.bosleo.studentapp.api.RetrofitBuilder
import com.bosleo.studentapp.data.database.StudentDao
import com.bosleo.studentapp.data.pojo.ApiResponse
import com.bosleo.studentapp.data.pojo.Student
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
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

    fun getAllStudents(): LiveData<MutableList<Student>> {
        return studentDao.fetch()
    }

}