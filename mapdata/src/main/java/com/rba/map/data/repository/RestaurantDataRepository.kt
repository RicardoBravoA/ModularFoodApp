package com.rba.map.data.repository

import com.rba.util.domain.callback.BaseCallback
import com.rba.map.data.service.RestaurantServiceDataStore
import com.rba.map.domain.repository.RestaurantRepository
import com.rba.model.model.ErrorModel
import com.rba.model.model.RestaurantModel

class RestaurantDataRepository : RestaurantRepository {
    override suspend fun getRestaurantList(
        latitude: String,
        longitude: String,
        baseCallback: BaseCallback<List<RestaurantModel>, ErrorModel>
    ) {
        val restaurantDataStore = RestaurantServiceDataStore()
        return restaurantDataStore.getRestaurantList(latitude, longitude, baseCallback)
    }

}