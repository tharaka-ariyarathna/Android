package com.tharaka.demo.api

import com.tharaka.demo.model.User
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path

interface UserApiService{
    @GET("users")
    fun getUsers(): Call<List<User>>

    @GET("users/{id}")
    fun getUser(@Path("id") id:String):Call<User>

    companion object {
        val API_URL ="https://jsonplaceholder.typicode.com/"
        fun create():UserApiService{
            var retrofit = Retrofit.Builder()
                .baseUrl(API_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            return retrofit.create(UserApiService::class.java)
        }
    }
}
