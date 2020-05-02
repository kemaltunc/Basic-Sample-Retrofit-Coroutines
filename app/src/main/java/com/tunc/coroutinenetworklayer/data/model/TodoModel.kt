package com.tunc.coroutinenetworklayer.data.model

data class TodoModel(
    var userId: Int,
    var id: Int,
    var title: String,
    var completed: Boolean
)