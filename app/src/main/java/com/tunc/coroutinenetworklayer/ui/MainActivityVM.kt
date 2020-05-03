package com.tunc.coroutinenetworklayer.ui

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.tunc.coroutinenetworklayer.base.BaseViewModel
import com.tunc.coroutinenetworklayer.base.ServiceCallBack
import com.tunc.coroutinenetworklayer.data.exception.ErrorModel
import com.tunc.coroutinenetworklayer.domain.entity.TodoEntity
import com.tunc.coroutinenetworklayer.domain.usecase.TodoUseCase

class MainActivityVM : BaseViewModel() {
    private var useCase: TodoUseCase = TodoUseCase()

    val todoLiveData = MutableLiveData<MutableList<TodoEntity>>()

    fun getTodo() {
        service.apiCall(
            call = suspend { useCase.getTodo() },
            callback = object : ServiceCallBack<List<TodoEntity>> {
                override fun onSuccess(response: List<TodoEntity>?) {
                    todoLiveData.postValue(response?.toMutableList())
                }

                override fun onError(errorModel: ErrorModel?) {
                    Log.d("networkError", errorModel?.message)
                }

            })

    }

}