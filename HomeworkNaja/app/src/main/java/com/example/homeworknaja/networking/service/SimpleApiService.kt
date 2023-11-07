package com.example.homeworknaja.networking.service

import com.example.homeworknaja.model.BaseApiResponse
import com.example.homeworknaja.model.SimpleModel
import retrofit2.http.GET

interface SimpleApiService {
    @GET("/youtubelist")
    suspend fun getSimpleList(): BaseApiResponse<MutableList<SimpleModel>>
}