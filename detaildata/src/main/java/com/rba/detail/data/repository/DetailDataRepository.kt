package com.rba.detail.data.repository

import com.rba.detail.data.service.DetailServiceDataStore
import com.rba.detail.domain.repository.DetailRepository
import com.rba.model.model.DetailModel
import com.rba.model.model.ErrorModel
import com.rba.util.domain.callback.BaseCallback

class DetailDataRepository : DetailRepository {
    override suspend fun getDetail(
        id: String,
        baseCallback: BaseCallback<DetailModel, ErrorModel>
    ) {
        val detailDataStore = DetailServiceDataStore()
        return detailDataStore.getDetail(id, baseCallback)
    }

}