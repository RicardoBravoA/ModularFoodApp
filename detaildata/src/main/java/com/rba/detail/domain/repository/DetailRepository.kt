package com.rba.detail.domain.repository

import com.rba.model.model.DetailModel
import com.rba.model.model.ErrorModel
import com.rba.util.domain.ResultType

interface DetailRepository {

    suspend fun getDetail(
        id: String
    ): ResultType<DetailModel, ErrorModel>

}