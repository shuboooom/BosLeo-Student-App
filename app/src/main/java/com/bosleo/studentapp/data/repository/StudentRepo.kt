package com.bosleo.studentapp.data.repository

import com.bosleo.studentapp.api.ApiService
import com.bosleo.studentapp.api.RetrofitBuilder
import com.bosleo.studentapp.data.pojo.ApiResponse
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent

@InstallIn(ActivityComponent::class)
class StudentRepo {

    suspend fun getClassData() : ApiResponse?
    {
        try {
            val apiService: ApiService = RetrofitBuilder.getRetrofit().create(ApiService::class.java)
            val res = apiService.getClassData()
            if(res.isSuccessful)
            {
                res.body()?.let {
                    return it
                }
            }
        }
        catch (e : Exception)
        {
            e.printStackTrace()
            return null
        }

        return null
    }

    fun getAllStudents()
    {

    }

}