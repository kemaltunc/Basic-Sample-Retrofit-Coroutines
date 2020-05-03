package com.tunc.coroutinenetworklayer.data.mappers

import com.tunc.coroutinenetworklayer.data.model.TodoResponse
import com.tunc.coroutinenetworklayer.domain.entity.TodoEntity

fun TodoResponse.toTodo() = TodoEntity(
    userId, id, title, isCompleted
)