package com.asr.sedaya

import retrofit2.Call
import retrofit2.http.GET

interface ApiEndPoint {

    @GET("list_data.php")
    fun data(): Call<JenisModel>
}