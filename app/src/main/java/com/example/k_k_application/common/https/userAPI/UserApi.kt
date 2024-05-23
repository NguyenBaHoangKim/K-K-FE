package com.example.k_k_application.common.https.userAPI

import com.example.k_k_application.model.User
import com.example.k_k_application.model.UserRes
import com.example.k_k_application.model.UserStr
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface UserApi {
    @GET("/user/{id}")
    fun getUsersById(@Path("id") id: Long): Call<User>;
    @GET("/user")
    fun getAllUser(): Call<List<User>>;
    @GET("/user/str")
    fun getUserStr(): Call<List<UserStr>>;
}