package com.tunc.coroutinenetworklayer.domain.repository

import com.tunc.coroutinenetworklayer.domain.entity.TodoEntity

interface TodoRepository {
    suspend fun getTodo(): List<TodoEntity>
}