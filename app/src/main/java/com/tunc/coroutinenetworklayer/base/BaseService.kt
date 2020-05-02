package com.tunc.coroutinenetworklayer.base

import com.tunc.coroutinenetworklayer.data.exception.ApiErrorHandle
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import retrofit2.HttpException


class BaseService(private val scope: CoroutineScope, private val apiErrorHandle: ApiErrorHandle) {

    fun <T : Any> apiCall(
        call: suspend () -> List<T>,
        callback: ServiceCallBack<List<T>>
    ) {

        scope.launch {
            try {
                val response = call.invoke()
                callback.onSuccess(response)
            } catch (e: HttpException) {
                callback.onError(apiErrorHandle.traceErrorException(e))
            } catch (e: Throwable) {
                callback.onError(apiErrorHandle.traceErrorException(e))
            }
        }

    }
}