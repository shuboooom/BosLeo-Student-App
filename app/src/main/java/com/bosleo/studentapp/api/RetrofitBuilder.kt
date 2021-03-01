package com.bosleo.studentapp.api


import biz.ctunes.callingtunes.Constants
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitBuilder {


    private val interceptor = HttpLoggingInterceptor().apply {
//        level = if(BuildConfig.Debug) {
//            HttpLoggingInterceptor.Level.BODY
//        } else{
//            //don't log for production apps!
//            HttpLoggingInterceptor.Level.NONE
//        }
        level = HttpLoggingInterceptor.Level.BODY
    }

    fun getRetrofit(baseURL : String = Constants.baseUrl): Retrofit {

        val builder = OkHttpClient().newBuilder()
                .addInterceptor(interceptor)

        val client = builder.build()

        val gson = GsonBuilder()
            .setLenient()
            .create()

        return Retrofit.Builder()
                .client(client)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .baseUrl(baseURL)
                .build()
    }
}