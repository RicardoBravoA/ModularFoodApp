package com.rba.map.domain.repository

import com.rba.model.model.ErrorModel
import com.rba.model.model.RestaurantModel
import com.rba.util.domain.callback.BaseCallback

interface RestaurantRepository {

    suspend fun getRestaurantList(
        latitude: String,
        longitude: String,
        baseCallback: BaseCallback<List<RestaurantModel>, ErrorModel>
    )

}