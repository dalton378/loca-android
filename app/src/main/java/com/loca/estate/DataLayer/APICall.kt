package com.loca.estate.DataLayer

import retrofit2.Call
import retrofit2.http.GET
import com.loca.estate.Model.PostReturn

interface APICall {
    @GET("/posts/1")
    fun getPost(): Call<PostReturn>


}