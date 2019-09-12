package com.rba.model.mapper

import com.rba.model.entity.response.RestaurantDetailResponse
import com.rba.model.model.DetailModel

object DetailMapper {

    fun transform(restaurantDetailResponse: RestaurantDetailResponse): DetailModel {

        val detailModel = DetailModel()
        detailModel.id = restaurantDetailResponse.id
        detailModel.apikey = restaurantDetailResponse.apikey
        detailModel.name = restaurantDetailResponse.name
        detailModel.url = restaurantDetailResponse.url
        detailModel.latitude = restaurantDetailResponse.location?.latitude
        detailModel.longitude = restaurantDetailResponse.location?.longitude
        detailModel.cuisines = restaurantDetailResponse.cuisines
        detailModel.popularity = restaurantDetailResponse.userRating?.aggregateRating
        detailModel.thumb = restaurantDetailResponse.thumb
        detailModel.timings = restaurantDetailResponse.timings
        detailModel.phoneNumbers = restaurantDetailResponse.phoneNumbers
        detailModel.address = restaurantDetailResponse.location?.address
        return detailModel
    }

}