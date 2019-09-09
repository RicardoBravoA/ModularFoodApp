package com.rba.model.model

data class DefaultErrorModel(
    var message: String
) {
    constructor() : this("Ocurrió un error...")
}