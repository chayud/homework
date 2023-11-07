package com.example.homeworknaja.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.homeworknaja.impl.SimpleRepositoryImpl
import com.example.homeworknaja.model.ResultWrapper
import com.example.homeworknaja.model.SimpleModel
import com.example.homeworknaja.networking.PortalService
import com.example.homeworknaja.networking.service.SimpleApiService
import com.example.homeworknaja.ui.base.BaseViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

class MainActivityViewModel : BaseViewModel<MainActivityNavigator>(), CoroutineScope
{
    override fun tag(): String = MainActivityViewModel::class.java.simpleName


    private val job: Job by lazy { SupervisorJob() }
    override val coroutineContext: CoroutineContext
        get() = Dispatchers.Main + job

    private val navigator: MainActivityNavigator? by lazy { getNavigator()?.get() }

    private var simpleRepositoryImpl: SimpleRepositoryImpl


    init {
        val youtubeApiService = PortalService.createPortal(SimpleApiService::class.java)
        simpleRepositoryImpl = SimpleRepositoryImpl(youtubeApiService)
    }



    fun getSimpleList() {
        launch {
            navigator?.showLoading()
            when (val result = simpleRepositoryImpl.getSimpleList()) {
                is ResultWrapper.Success -> {
                    navigator?.hideLoading()
                    val data = result.value
                    if (!data.success) {
                        navigator?.getSimpleListFailed(Exception("Error failed"))
                        return@launch
                    }
                    val datalist = data.data
                    datalist?.let { dataYoutubeList ->
                        navigator?.getSimpleListSuccess(dataYoutubeList)
                    } ?: run {
                        navigator?.getSimpleListFailed(Exception("Data null"))
                    }
                }

                is ResultWrapper.GenericError -> {
                    navigator?.hideLoading()
                    val exception = result.exception ?: Exception("ERRR")
                    navigator?.getSimpleListFailed(exception)
                }

                is ResultWrapper.NetworkError -> {
                    navigator?.hideLoading()
                    val exception = result.exception ?: Exception("ERRR")
                    navigator?.getSimpleListFailed(exception)
                }
            }
        }
    }
}