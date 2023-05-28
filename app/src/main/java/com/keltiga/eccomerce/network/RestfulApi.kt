package com.keltiga.eccomerce.network

import com.keltiga.eccomerce.model.ResponseNewsUpdateItem
import retrofit2.Call
import retrofit2.http.GET

interface RestfulApi {
    @GET("news_update")
    fun getNewsSliderItems(): Call<List<ResponseNewsUpdateItem>>
}