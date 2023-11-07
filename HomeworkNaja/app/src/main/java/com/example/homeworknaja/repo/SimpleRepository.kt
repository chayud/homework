package com.example.homeworknaja.repo

import com.example.homeworknaja.model.BaseApiResponse
import com.example.homeworknaja.model.ResultWrapper
import com.example.homeworknaja.model.SimpleModel

interface SimpleRepository {
    suspend fun getSimpleList(): ResultWrapper<BaseApiResponse<MutableList<SimpleModel>>>
}