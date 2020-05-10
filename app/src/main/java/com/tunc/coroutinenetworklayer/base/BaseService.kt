package com.tunc.coroutinenetworklayer.base

import com.tunc.coroutinenetworklayer.data.exception.ApiErrorHandle
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.HttpException


class BaseService(
    private val scope: CoroutineScope,
    private val apiErrorHandle: ApiErrorHandle
) {

    fun <T> execute(
        call: suspend () -> T,
        result: Result<T>
    ) {
        scope.launch {
            try {
                val response = call.invoke()
                withContext(Main) {
                    result.onSuccess(response)
                }
            } catch (e: HttpException) {
                withContext(Main) {
                    result.onError(apiErrorHandle.traceErrorException(e))
                }
            } catch (e: Throwable) {
                withContext(Main) {
                    result.onError(apiErrorHandle.traceErrorException(e))
                }
            }
        }
    }

}