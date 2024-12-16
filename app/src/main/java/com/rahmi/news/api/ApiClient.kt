package com.rahmi.news.api

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiClient {
    private const val BASE_URL = "http://192.168.76.234:8888/API_BASIC"

    private val client = OkHttpClient.Builder()
        .addInterceptor { chain ->
            val request = chain.request().newBuilder()
                .addHeader("Content-Type", "application/json")
                .build()

            // Melanjutkan request setelah menambahkan header
            chain.proceed(request)
        }
        .build()

    val apiService: ApiService by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(client) // Menggunakan client yang telah dibangun
            .addConverterFactory(GsonConverterFactory.create()) // Menambahkan converter Gson
            .build()
            .create(ApiService::class.java) // Membuat ApiService
    }
}
