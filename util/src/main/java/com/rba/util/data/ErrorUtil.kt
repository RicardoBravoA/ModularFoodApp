package com.rba.util.data

import com.rba.model.model.ErrorModel

object ErrorUtil {

    fun errorHandler(error: Throwable): ErrorModel {

        val errorException: RetrofitException =
            if (error is RetrofitException) {
                error
            } else {
                RetrofitException.retrofitException(error)
            }

        return when (errorException.kind) {
            RetrofitException.Kind.HTTP -> errorException.getErrorBodyAs(ErrorModel::class.java)!!
            RetrofitException.Kind.NETWORK -> ErrorModel()
            else -> ErrorModel(0, "", "Ocurrió un error")
        }

    }
}