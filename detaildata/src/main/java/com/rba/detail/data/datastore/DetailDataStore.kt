package com.rba.detail.data.datastore

import com.rba.model.model.DetailModel
import com.rba.model.model.ErrorModel
import com.rba.util.domain.ResultType

interface DetailDataStore {

    suspend fun getDetail(
        id: String
    ): ResultType<DetailModel, ErrorModel>

}