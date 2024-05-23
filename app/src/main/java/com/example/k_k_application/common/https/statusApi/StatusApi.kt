package com.example.k_k_application.common.https.statusApi

import com.example.k_k_application.model.Status
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface StatusApi {
    @GET("/status")
    fun getStatus(): Call<List<Status>>

    @GET("/status/{albumId}")
    fun getStatusById(@Path("albumId") albumId: Long): Call<List<Status>>
}