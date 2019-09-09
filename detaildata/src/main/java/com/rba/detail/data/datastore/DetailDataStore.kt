package com.rba.detail.data.datastore

import com.rba.model.model.DetailModel
import com.rba.model.model.ErrorModel
import com.rba.util.domain.callback.BaseCallback

interface DetailDataStore {

    suspend fun getDetail(
        id: String,
        baseCallback: BaseCallback<DetailModel, ErrorModel>
    )

}