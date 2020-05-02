package com.tunc.coroutinenetworklayer.data.repository

import com.tunc.coroutinenetworklayer.data.api.RetrofitFactory
import com.tunc.coroutinenetworklayer.data.api.RetrofitService

class TodoRepository {
    private var service = RetrofitFactory.makeRetrofitService().create(RetrofitService::class.java)

    suspend fun getTodos() = service.getTodos()

}