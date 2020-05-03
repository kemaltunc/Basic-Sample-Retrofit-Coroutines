package com.tunc.coroutinenetworklayer.domain.entity

data class TodoEntity(
    var userId: Int,
    var id: Int,
    var title: String,
    var completed: Boolean
)