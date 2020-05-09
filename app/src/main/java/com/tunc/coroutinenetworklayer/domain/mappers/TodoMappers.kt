package com.tunc.coroutinenetworklayer.domain.mappers

import com.tunc.coroutinenetworklayer.data.model.TodoResponse
import com.tunc.coroutinenetworklayer.domain.entity.TodoEntity

fun TodoResponse.toTodo() = TodoEntity(
    userId, id, title, isCompleted
)