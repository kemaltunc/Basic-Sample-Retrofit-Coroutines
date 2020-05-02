package com.tunc.coroutinenetworklayer.base

import com.tunc.coroutinenetworklayer.data.exception.ErrorModel

interface ServiceCallBack<T> {

    fun onSuccess(response: T?)
    fun onError(errorModel: ErrorModel?)
}