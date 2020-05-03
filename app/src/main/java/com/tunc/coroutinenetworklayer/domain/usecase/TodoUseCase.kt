package com.tunc.coroutinenetworklayer.domain.usecase

import com.tunc.coroutinenetworklayer.data.repository.TodoRepositoryImp

class TodoUseCase() {
    private var todoRepository: TodoRepositoryImp = TodoRepositoryImp()

    suspend fun getTodo() = todoRepository.getTodo()
}