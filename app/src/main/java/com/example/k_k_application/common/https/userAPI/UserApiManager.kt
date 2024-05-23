package com.example.k_k_application.common.https.userAPI

import android.util.Log
import com.example.k_k_application.common.https.CustomApi
import com.example.k_k_application.model.User
import com.example.k_k_application.model.UserRes
import com.example.k_k_application.model.UserStr
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UserApiManager {
    private val userApi: UserApi = CustomApi.client()
    fun getUserById(id: Long,onSuccess: (User) -> Unit, onFailure: (error: String) -> Unit){
        userApi.getUsersById(id).enqueue(object : Callback<User> {
            override fun onResponse(
                call: Call<User>,
                response: Response<User>
            ) {
                print(response.body())
                val responseBody = response.body() ?: return
                onSuccess(responseBody)
            }

            override fun onFailure(call: Call<User>, t: Throwable) {
                onFailure(t.message!!)
                Log.d("MainActivity", "onFailure: " + t.message)
            }
        })
    }
    fun getAllUser(onSuccess: (List<User>) -> Unit, onFailure: (error: String) -> Unit){
        userApi.getAllUser().enqueue(object : Callback<List<User>> {
            override fun onResponse(
                call: Call<List<User>>,
                response: Response<List<User>>
            ) {
                print(response.body())
                val responseBody = response.body() ?: return
                onSuccess(responseBody)
            }

            override fun onFailure(call: Call<List<User>>, t: Throwable) {
                onFailure(t.message!!)
                Log.d("MainActivity", "onFailure: " + t.message)
            }
        })
    }
    fun getUserStr(onSuccess: (List<UserStr>) -> Unit, onFailure: (error: String) -> Unit){
        userApi.getUserStr().enqueue(object : Callback<List<UserStr>> {
            override fun onResponse(
                call: Call<List<UserStr>>,
                response: Response<List<UserStr>>
            ) {
                print(response.body())
                val responseBody = response.body() ?: return
                onSuccess(responseBody)
            }

            override fun onFailure(call: Call<List<UserStr>>, t: Throwable) {
                onFailure(t.message!!)
                Log.d("MainActivity", "onFailure: " + t.message)
            }
        })
    }
}