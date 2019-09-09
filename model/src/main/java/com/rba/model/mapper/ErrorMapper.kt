package com.rba.model.mapper

import com.rba.model.entity.response.ErrorResponse
import com.rba.model.model.ErrorModel

object ErrorMapper {

    fun transform(errorResponse: ErrorResponse): ErrorModel {

        val errorModel = ErrorModel()
        errorModel.code = errorResponse.code
        errorModel.message = errorResponse.message
        errorModel.status = errorResponse.status

        return errorModel
    }

}