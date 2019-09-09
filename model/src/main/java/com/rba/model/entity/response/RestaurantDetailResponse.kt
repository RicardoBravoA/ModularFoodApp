package com.rba.model.entity.response

import com.google.gson.annotations.SerializedName

class RestaurantDetailResponse {
    var id: String? = null
    var apikey: String? = null
    var name: String? = null
    var url: String? = null
    var location: LocationBean? = null
    var cuisines: String? = null
    var timings: String? = null
    var thumb: String? = null
    @SerializedName("photo_count")
    var photoCount: Int? = null
    @SerializedName("user_rating")
    var userRating: UserRatingBean? = null
    //var photos: List<PhotosBean>? = null
    var popularity: PopularityBean? = null
    var link: String? = null
    @SerializedName("phone_numbers")
    var phoneNumbers: String? = null

    class PopularityBean {
        var popularity: String? = null
    }

    class UserRatingBean {
        @SerializedName("aggregate_rating")
        var aggregateRating: String? = null
    }

    class PhotosBean {
        var photo: List<PhotosBean>? = null

        class PhotoBean {
            var id: String? = null
            var url: String? = null
        }
    }

    class LocationBean {
        var address: String? = null
        var locality: String? = null
        var city: String? = null
        @SerializedName("city_id")
        var cityId: Int = 0
        var latitude: String? = null
        var longitude: String? = null
        var zipcode: String? = null
        @SerializedName("country_id")
        var countryId: Int = 0
        @SerializedName("locality_verbose")
        var localityVerbose: String? = null
    }
}