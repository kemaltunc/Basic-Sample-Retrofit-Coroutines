package com.tunc.coroutinenetworklayer.base

import androidx.lifecycle.ViewModel
import com.tunc.coroutinenetworklayer.data.exception.ApiErrorHandle
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.cancel
import kotlin.coroutines.CoroutineContext

open class BaseViewModel : ViewModel() {
    private val parentJob = Job()

    private val coroutineContext: CoroutineContext
        get() = parentJob + Dispatchers.Default

    private val scope = CoroutineScope(coroutineContext)
    val service = BaseService(scope, ApiErrorHandle())

    fun cancelRequest() = coroutineContext.cancel()


}