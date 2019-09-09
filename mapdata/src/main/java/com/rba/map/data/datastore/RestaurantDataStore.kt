package com.rba.map.data.datastore

import com.rba.model.model.ErrorModel
import com.rba.model.model.RestaurantModel
import com.rba.util.domain.callback.BaseCallback

interface RestaurantDataStore {

    suspend fun getRestaurantList(
        latitude: String,
        longitude: String,
        baseCallback: BaseCallback<List<RestaurantModel>, ErrorModel>
    )

}