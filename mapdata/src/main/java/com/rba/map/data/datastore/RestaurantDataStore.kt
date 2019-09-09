package com.rba.map.data.datastore

import com.rba.util.domain.ResultType
import com.rba.model.model.ErrorModel
import com.rba.model.model.RestaurantModel

interface RestaurantDataStore {

    suspend fun getRestaurantList(
        latitude: String,
        longitude: String
    ): ResultType<List<RestaurantModel>, ErrorModel>

}