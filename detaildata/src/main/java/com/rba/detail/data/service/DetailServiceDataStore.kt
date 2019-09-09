package com.rba.detail.data.service

import com.rba.detail.data.api.ApiManager
import com.rba.detail.data.datastore.DetailDataStore
import com.rba.detail.data.util.RetrofitErrorUtil
import com.rba.model.mapper.DetailMapper
import com.rba.model.mapper.ErrorMapper
import com.rba.model.model.DetailModel
import com.rba.model.model.ErrorModel
import com.rba.util.data.ErrorUtil
import com.rba.util.domain.ResultType

class DetailServiceDataStore : DetailDataStore {

    override suspend fun getDetail(
        id: String
    ): ResultType<DetailModel, ErrorModel> {

        return try {
            val response = ApiManager.apiManager().restaurantDetail(id).await()
            if (response.isSuccessful) {
                val detailResponse = response.body()
                ResultType.Success(DetailMapper.transform(detailResponse!!))
            } else {
                val error = RetrofitErrorUtil.parseError(response)!!
                ResultType.Error(ErrorMapper.transform(error))
            }
        } catch (t: Throwable) {
            ResultType.Error(ErrorUtil.errorHandler(t))
        }

    }
}