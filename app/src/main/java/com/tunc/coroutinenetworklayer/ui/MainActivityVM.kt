package com.tunc.coroutinenetworklayer.ui

import androidx.lifecycle.MutableLiveData
import com.tunc.coroutinenetworklayer.base.BaseViewModel
import com.tunc.coroutinenetworklayer.base.Result
import com.tunc.coroutinenetworklayer.domain.entity.TodoEntity
import com.tunc.coroutinenetworklayer.domain.usecase.TodoUseCase

class MainActivityVM : BaseViewModel() {
    private var useCase: TodoUseCase = TodoUseCase()

    val todoLiveData = MutableLiveData<MutableList<TodoEntity>>()

    fun getTodo() {
        apiRequest.execute(
            call = { useCase.getTodo() },
            result = object : Result<List<TodoEntity>>(appCallback) {
                override fun onSuccess(response: List<TodoEntity>?) {
                    super.onSuccess(response)
                    todoLiveData.postValue(response?.toMutableList())
                }
            })
    }


}
