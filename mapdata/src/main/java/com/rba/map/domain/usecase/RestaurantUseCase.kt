package com.rba.map.domain.usecase

import com.rba.map.domain.repository.RestaurantRepository
import com.rba.model.model.ErrorModel
import com.rba.model.model.RestaurantModel
import com.rba.util.domain.callback.BaseCallback

class RestaurantUseCase(private val restaurantRepository: RestaurantRepository) {

    suspend fun getRestaurantList(
        latitude: String,
        longitude: String,
        baseCallback: BaseCallback<List<RestaurantModel>, ErrorModel>
    ) {
        return restaurantRepository.getRestaurantList(latitude, longitude, baseCallback)
    }

}