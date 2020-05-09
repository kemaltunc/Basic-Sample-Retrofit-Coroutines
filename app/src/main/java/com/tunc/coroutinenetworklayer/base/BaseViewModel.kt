package com.tunc.coroutinenetworklayer.base

import androidx.lifecycle.ViewModel
import com.tunc.coroutinenetworklayer.data.exception.ApiErrorHandle
import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext

open class BaseViewModel : ViewModel() {

    lateinit var appCallback: AppCallback


    private val parentJob = Job()

    private val coroutineContext: CoroutineContext
        get() = parentJob + Dispatchers.Main

    private val scope = CoroutineScope(coroutineContext)

    val apiRequest = BaseService(scope, ApiErrorHandle())


    fun cancelRequest() = coroutineContext.cancel()

    override fun onCleared() {
        super.onCleared()
        scope.coroutineContext.cancelChildren()
        cancelRequest()
    }


    fun setView(appCallback: AppCallback) {
        this.appCallback = appCallback

    }


}