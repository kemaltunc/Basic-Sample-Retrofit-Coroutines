package com.tunc.coroutinenetworklayer.base

interface AppCallback {
    fun showLoading()
    fun hideLoading()
    fun showMessage(message: String)
}