package com.rba.map.domain.usecase

import com.rba.map.domain.repository.RestaurantRepository
import com.rba.util.domain.ResultType
import com.rba.model.model.ErrorModel
import com.rba.model.model.RestaurantModel

class RestaurantUseCase(private val restaurantRepository: RestaurantRepository) {

    suspend fun getRestaurantList(
        latitude: String,
        longitude: String
    ): ResultType<List<RestaurantModel>, ErrorModel> {
        return restaurantRepository.getRestaurantList(latitude, longitude)
    }

}