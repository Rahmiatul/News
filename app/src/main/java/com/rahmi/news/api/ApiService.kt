package com.rahmi.news.api

import com.rahmi.news.models.LoginRequest
import com.rahmi.news.models.LoginResponse
import com.rahmi.news.models.RegisterRequest
import com.rahmi.news.models.RegisterResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiService {
    @POST("API_BASIC/register.php")
    fun register(@Body request: RegisterRequest): Call<RegisterResponse>

    @POST("API_BASIC/login.php")
    fun login(@Body request: LoginRequest): Call<LoginResponse>
}