package com.tunc.coroutinenetworklayer.data.repository

import com.tunc.coroutinenetworklayer.data.api.RetrofitFactory
import com.tunc.coroutinenetworklayer.data.api.RetrofitService
import com.tunc.coroutinenetworklayer.data.mappers.toTodo
import com.tunc.coroutinenetworklayer.data.model.TodoResponse
import com.tunc.coroutinenetworklayer.domain.entity.TodoEntity
import com.tunc.coroutinenetworklayer.domain.repository.TodoRepository

class TodoRepositoryImp : TodoRepository {
    private var service = RetrofitFactory.makeRetrofitService().create(RetrofitService::class.java)

    override suspend fun getTodo(): List<TodoEntity> {

        val response = service.getTodos()

        return response.map {
            it.toTodo()
        }

    }
}

