package com.tunc.coroutinenetworklayer.base

import com.tunc.coroutinenetworklayer.data.exception.ErrorModel


abstract class Result<T> constructor(
    private val mvpView: AppCallback,
    private val showLoading: Boolean = false
) : ServiceCallBack<T> {
    init {
        if (showLoading) mvpView.showLoading()
    }

    override fun onSuccess(response: T?) {
        mvpView.hideLoading()
    }

    override fun onError(errorModel: ErrorModel) {
        mvpView.showMessage(errorModel.message ?: "Bir sorun meydana geldi")
        mvpView.hideLoading()
    }
}