package com.rba.detail.data.service

import com.rba.detail.data.api.ApiManager
import com.rba.detail.data.datastore.DetailDataStore
import com.rba.detail.data.util.RetrofitErrorUtil
import com.rba.model.entity.response.RestaurantDetailResponse
import com.rba.util.domain.callback.BaseCallback
import com.rba.model.model.DetailModel
import com.rba.model.model.ErrorModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DetailServiceDataStore : DetailDataStore {

    override suspend fun getDetail(
        id: String,
        baseCallback: BaseCallback<DetailModel, ErrorModel>
    ) {

        val call = ApiManager.apiManager().restaurantDetail(id)
        call.enqueue(object : Callback<RestaurantDetailResponse> {
            override fun onResponse(
                call: Call<RestaurantDetailResponse>,
                response: Response<RestaurantDetailResponse>
            ) {
                if (response.isSuccessful) {
                    val detailResponse = response.body()
                    detailResponse?.let {
                        baseCallback.onSuccess(com.rba.model.mapper.DetailMapper.transform(detailResponse))
                    }

                } else {
                    val error = RetrofitErrorUtil.parseError(response)!!
                    baseCallback.onError(com.rba.model.mapper.ErrorMapper.transform(error))
                }
            }

            override fun onFailure(call: Call<RestaurantDetailResponse>, t: Throwable) {
                baseCallback.onFailure(t)
            }
        })

    }
}