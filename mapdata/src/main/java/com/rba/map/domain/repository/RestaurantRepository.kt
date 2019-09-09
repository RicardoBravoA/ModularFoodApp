package com.rba.map.domain.repository

import com.rba.util.domain.ResultType
import com.rba.model.model.ErrorModel
import com.rba.model.model.RestaurantModel

interface RestaurantRepository {

    suspend fun getRestaurantList(
        latitude: String,
        longitude: String
    ): ResultType<List<RestaurantModel>, ErrorModel>

}