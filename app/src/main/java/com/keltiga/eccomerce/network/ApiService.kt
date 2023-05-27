package com.keltiga.eccomerce.network

import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface ApiService {
    @FormUrlEncoded
    @POST("users")
    fun registerUser(
        @Field("email") username: String,
        @Field("password") password: String
    ): Call<ApiResponse>
}