package com.rba.model.mapper

import com.rba.model.entity.response.GeoCodeResponse
import com.rba.model.entity.response.RestaurantResponse
import com.rba.model.model.RestaurantModel

object RestaurantMapper {

    fun transform(restaurantResponse: RestaurantResponse): RestaurantModel {
        val restaurantModel = RestaurantModel()
        restaurantModel.id = restaurantResponse.id
        restaurantModel.apikey = restaurantResponse.apikey
        restaurantModel.name = restaurantResponse.name
        restaurantModel.url = restaurantResponse.url
        restaurantModel.latitude = restaurantResponse.latitude
        restaurantModel.longitude = restaurantResponse.longitude
        restaurantModel.cuisines = restaurantResponse.cuisines
        restaurantModel.popularity = restaurantResponse.popularity
        restaurantModel.thumb = restaurantResponse.thumb
        return restaurantModel
    }

    fun transform(geoCodeResponse: GeoCodeResponse): List<RestaurantModel> {

        val nearByRestaurantModelList: List<GeoCodeResponse.NearbyRestaurantsBean>? = geoCodeResponse.nearbyRestaurants
        val restaurantModelList = arrayListOf<RestaurantModel>()

        nearByRestaurantModelList?.forEach {
            val restaurant: GeoCodeResponse.NearbyRestaurantsBean.RestaurantBean? = it.restaurant

            val restaurantResponse = RestaurantResponse()
            restaurantResponse.id = restaurant?.id
            restaurantResponse.apikey = restaurant?.apikey
            restaurantResponse.name = restaurant?.name
            restaurantResponse.url = restaurant?.url
            restaurantResponse.latitude = restaurant?.location?.latitude
            restaurantResponse.longitude = restaurant?.location?.longitude
            restaurantResponse.cuisines = restaurant?.cuisines
            restaurantResponse.popularity = restaurant?.userRating?.aggregateRating
            restaurantResponse.thumb = restaurant?.thumb

            restaurantModelList.add(transform(restaurantResponse))
        }

        return restaurantModelList
    }

}