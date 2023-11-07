package com.example.homeworknaja.ui.main

import com.example.homeworknaja.model.SimpleModel

interface MainActivityNavigator {

    fun showLoading()
    fun hideLoading()

    fun getSimpleList()
    fun getSimpleListSuccess(youtubeList : MutableList<SimpleModel>)
    fun getSimpleListFailed(exception : Exception)

}