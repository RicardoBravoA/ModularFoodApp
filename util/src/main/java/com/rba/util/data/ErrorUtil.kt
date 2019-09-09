package com.rba.util.data

object ErrorUtil {

    fun errorHandler(error: Throwable): com.rba.model.model.DefaultErrorModel {

        val errorException: RetrofitException =
            if (error is RetrofitException) {
                error
            } else {
                RetrofitException.retrofitException(error)
            }

        return when (errorException.kind) {
            RetrofitException.Kind.HTTP -> errorException.getErrorBodyAs(com.rba.model.model.DefaultErrorModel::class.java)!!
            RetrofitException.Kind.NETWORK -> com.rba.model.model.DefaultErrorModel()
            else -> com.rba.model.model.DefaultErrorModel()
        }

    }
}