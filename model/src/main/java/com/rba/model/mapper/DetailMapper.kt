package com.rba.model.mapper

import com.rba.model.entity.response.DetailResponse
import com.rba.model.entity.response.RestaurantDetailResponse
import com.rba.model.model.DetailModel

object DetailMapper {

    fun transform(photoResponse: DetailResponse.PhotosResponse.PhotoResponse): DetailModel.PhotosModel.PhotoModel {
        val photoModel = DetailModel.PhotosModel.PhotoModel()
        photoModel.id = photoResponse.id
        photoModel.url = photoResponse.url
        return photoModel
    }

    /*
    fun transform(photosResponseList: List<DetailResponse.PhotosResponse>): List<DetailModel.PhotosModel> {
        val photosModelList = arrayListOf<DetailModel.PhotosModel>()

        photosResponseList.forEach {
            photosModelList.add(DetailMapper.transform(it))
        }

        return photosModelList
    }
    */

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


        /*
        val photosList: List<RestaurantDetailResponse.PhotosBean>? = restaurantDetailResponse.photos

        restaurantDetailResponse.photos?.forEach {
            val photosBean: List<RestaurantDetailResponse.PhotosBean>? = it.photo

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
        */

        return detailModel
    }

}