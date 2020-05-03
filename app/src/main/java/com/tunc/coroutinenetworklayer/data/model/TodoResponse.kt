package com.tunc.coroutinenetworklayer.data.model

import com.squareup.moshi.Json

data class TodoResponse(
    var userId: Int,
    var id: Int,
    var title: String,
    @Json(name = "completed") var isCompleted: Boolean
)