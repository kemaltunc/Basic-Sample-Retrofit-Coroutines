package com.tunc.coroutinenetworklayer.data.repository

import com.tunc.coroutinenetworklayer.data.api.RetrofitFactory
import com.tunc.coroutinenetworklayer.data.api.RetrofitService
import com.tunc.coroutinenetworklayer.domain.repository.TodoRepository

class TodoRepositoryImp : TodoRepository {
    private var service = RetrofitFactory.makeRetrofitService().create(RetrofitService::class.java)

    override suspend fun getTodo() = service.getTodos()
}

