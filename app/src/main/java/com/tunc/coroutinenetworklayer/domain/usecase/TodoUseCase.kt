package com.tunc.coroutinenetworklayer.domain.usecase

import com.tunc.coroutinenetworklayer.data.repository.TodoRepositoryImp
import com.tunc.coroutinenetworklayer.domain.entity.TodoEntity
import com.tunc.coroutinenetworklayer.domain.mappers.toTodo

class TodoUseCase() {
    private var todoRepository: TodoRepositoryImp = TodoRepositoryImp()

    suspend fun getTodo(): List<TodoEntity> {
        val test = todoRepository.getTodo()

        return test.map {
            it.toTodo()
        }
    }
}