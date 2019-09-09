package com.rba.map.data.service

import com.rba.map.data.api.ApiManager
import com.rba.map.data.datastore.RestaurantDataStore
import com.rba.map.data.util.RetrofitErrorUtil
import com.rba.model.entity.response.GeoCodeResponse
import com.rba.model.mapper.ErrorMapper
import com.rba.model.mapper.RestaurantMapper
import com.rba.model.model.ErrorModel
import com.rba.model.model.RestaurantModel
import com.rba.util.domain.callback.BaseCallback
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RestaurantServiceDataStore : RestaurantDataStore {

    override suspend fun getRestaurantList(
        latitude: String,
        longitude: String,
        baseCallback: BaseCallback<List<RestaurantModel>, ErrorModel>
    ) {

        val call = ApiManager.apiManager().restaurantList(latitude, longitude)
        call.enqueue(object : Callback<GeoCodeResponse> {
            override fun onResponse(call: Call<GeoCodeResponse>, response: Response<GeoCodeResponse>) {
                if (response.isSuccessful) {
                    val movieResponse = response.body()
                    movieResponse?.let {
                        baseCallback.onSuccess(RestaurantMapper.transform(movieResponse))
                    }

                } else {
                    val error = RetrofitErrorUtil.parseError(response)!!
                    baseCallback.onError(ErrorMapper.transform(error))
                }
            }

            override fun onFailure(call: Call<GeoCodeResponse>, t: Throwable) {
                baseCallback.onFailure(t)
            }
        })

    }
}