package com.rba.map.data.service

import com.rba.map.data.api.ApiManager
import com.rba.map.data.datastore.RestaurantDataStore
import com.rba.map.data.util.RetrofitErrorUtil
import com.rba.util.domain.ResultType
import com.rba.model.mapper.ErrorMapper
import com.rba.model.mapper.RestaurantMapper
import com.rba.model.model.ErrorModel
import com.rba.model.model.RestaurantModel
import com.rba.util.data.ErrorUtil

class RestaurantServiceDataStore : RestaurantDataStore {

    override suspend fun getRestaurantList(
        latitude: String,
        longitude: String
    ): ResultType<List<RestaurantModel>, ErrorModel> {

        return try {
            val response = ApiManager.apiManager().restaurantList(latitude, longitude).await()
            if (response.isSuccessful) {
                val movieResponse = response.body()
                ResultType.Success(RestaurantMapper.transform(movieResponse!!))
            } else {
                val error = RetrofitErrorUtil.parseError(response)!!
                ResultType.Error(ErrorMapper.transform(error))
            }
        } catch (t: Throwable) {
                ResultType.Error(ErrorUtil.errorHandler(t))
        }

    }
}