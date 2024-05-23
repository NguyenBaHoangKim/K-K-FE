package com.example.k_k_application.common.https.statusApi

import android.util.Log
import com.example.k_k_application.common.https.CustomApi
import com.example.k_k_application.common.https.userAPI.UserApi
import com.example.k_k_application.model.Status
import com.example.k_k_application.model.User
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class StatusApiManager {
    private val statusApi: StatusApi = CustomApi.client()

    fun getStatus(onSuccess: (List<Status>) -> Unit, onFailure: (error: String) -> Unit){
        statusApi.getStatus().enqueue(object : Callback<List<Status>> {
            override fun onResponse(
                call: Call<List<Status>>,
                response: Response<List<Status>>
            ) {
                print(response.body())
                val responseBody = response.body() ?: return
                onSuccess(responseBody)
            }

            override fun onFailure(call: Call<List<Status>>, t: Throwable) {
                onFailure(t.message!!)
                Log.d("MainActivity", "onFailure: " + t.message)
            }
        })
    }
    fun getStatusById(albumId: Long, onSuccess: (List<Status>) -> Unit, onFailure: (error: String) -> Unit){
        statusApi.getStatusById(albumId).enqueue(object : Callback<List<Status>> {
            override fun onResponse(
                call: Call<List<Status>>,
                response: Response<List<Status>>
            ) {
                print(response.body())
                val responseBody = response.body() ?: return
                onSuccess(responseBody)
            }

            override fun onFailure(call: Call<List<Status>>, t: Throwable) {
                onFailure(t.message!!)
                Log.d("MainActivity", "onFailure: " + t.message)
            }
        })
    }
}