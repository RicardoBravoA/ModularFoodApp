package com.rba.map.data.repository

import com.rba.map.data.service.RestaurantServiceDataStore
import com.rba.map.domain.repository.RestaurantRepository
import com.rba.util.domain.ResultType
import com.rba.model.model.ErrorModel
import com.rba.model.model.RestaurantModel

class RestaurantDataRepository : RestaurantRepository {
    override suspend fun getRestaurantList(
        latitude: String,
        longitude: String
    ): ResultType<List<RestaurantModel>, ErrorModel> {
        val restaurantServiceDataStore = RestaurantServiceDataStore()
        return restaurantServiceDataStore.getRestaurantList(latitude, longitude)
    }

}