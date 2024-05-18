package com.example.k_k_application.common.https

import android.content.Context
import com.example.common.utils.MyApp
import com.example.common.utils.MyApp.Companion.context
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class CustomApi{
    private val context: Context
        get() = MyApp.context!!
    val apiURL = "http://10.0.2.2:8080/"
    companion object {
        inline fun <reified T> client(): T {
            val client = OkHttpClient.Builder()
//                .addInterceptor(AuthInterceptor(context!!))
                .build()

            val customApi = CustomApi()

            val retrofitBuilder = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .baseUrl(customApi.apiURL)
                .build()

            return retrofitBuilder.create(T::class.java)
        }
    }
}