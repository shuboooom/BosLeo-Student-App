package com.bosleo.studentapp.api

import com.bosleo.studentapp.data.pojo.ApiResponse
import retrofit2.Response
import retrofit2.http.*

interface ApiService {

    @GET("class")
    suspend fun getClassData(): Response<ApiResponse>
}