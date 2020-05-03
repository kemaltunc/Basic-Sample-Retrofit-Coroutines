package com.tunc.coroutinenetworklayer.ui

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.tunc.coroutinenetworklayer.base.BaseViewModel
import com.tunc.coroutinenetworklayer.base.ServiceCallBack
import com.tunc.coroutinenetworklayer.data.exception.ErrorModel
import com.tunc.coroutinenetworklayer.data.model.TodoModel
import com.tunc.coroutinenetworklayer.data.repository.TodoRepository

class MainActivityVM : BaseViewModel() {
    private var todoRepository: TodoRepository = TodoRepository()

    val todoLiveData = MutableLiveData<MutableList<TodoModel>>()

    fun getTodo() {
        service.apiCall(call = suspend { todoRepository.getTodos() },
            callback = object : ServiceCallBack<List<TodoModel>> {
                override fun onSuccess(response: List<TodoModel>?) {
                    todoLiveData.postValue(response?.toMutableList())
                }

                override fun onError(errorModel: ErrorModel?) {

                }

            }
        )
    }

}