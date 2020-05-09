package com.tunc.coroutinenetworklayer.domain.repository

import com.tunc.coroutinenetworklayer.data.model.TodoResponse

interface TodoRepository {
    suspend fun getTodo(): List<TodoResponse>
}