package com.tunc.coroutinenetworklayer.base

import com.tunc.coroutinenetworklayer.data.exception.ApiErrorHandle
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
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
                result.onSuccess(response)
            } catch (e: HttpException) {
                result.onError(apiErrorHandle.traceErrorException(e))
            } catch (e: Throwable) {
                result.onError(apiErrorHandle.traceErrorException(e))
            }
        }
    }

}