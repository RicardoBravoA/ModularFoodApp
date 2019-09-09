package com.rba.model.model

data class ErrorModel(
    var code: Int = 0,
    var status: String? = null,
    var message: String? = null
)