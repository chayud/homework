package com.example.homeworknaja.impl

import com.example.homeworknaja.model.BaseApiResponse
import com.example.homeworknaja.model.ResultWrapper
import com.example.homeworknaja.model.SimpleModel
import com.example.homeworknaja.model.callApiPortal
import com.example.homeworknaja.networking.service.SimpleApiService
import com.example.homeworknaja.repo.SimpleRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

class SimpleRepositoryImpl(
    private  val simpleApiService: SimpleApiService,
    private val coroutineContext: CoroutineDispatcher = Dispatchers.IO
): SimpleRepository {
    override suspend fun getSimpleList(): ResultWrapper<BaseApiResponse<MutableList<SimpleModel>>> =
        callApiPortal(coroutineContext) {
            simpleApiService.getSimpleList()
        }
}