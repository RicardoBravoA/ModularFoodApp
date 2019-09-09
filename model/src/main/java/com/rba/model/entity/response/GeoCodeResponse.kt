package com.rba.model.entity.response

import com.google.gson.annotations.SerializedName

class GeoCodeResponse {

    var location: LocationBean? = null
    var popularity: PopularityBean? = null
    var link: String? = null
    @SerializedName("nearby_restaurants")
    var nearbyRestaurants: List<NearbyRestaurantsBean>? = null

    class LocationBean {
        @SerializedName("entity_type")
        var entityType: String? = null
        @SerializedName("entity_id")
        var entityId: Int = 0
        var title: String? = null
        var latitude: String? = null
        var longitude: String? = null
        @SerializedName("city_id")
        var cityId: Int = 0
        @SerializedName("city_name")
        var cityName: String? = null
        @SerializedName("country_id")
        var countryId: Int = 0
        @SerializedName("country_name")
        var countryName: String? = null
    }

    class PopularityBean {
        var popularity: String? = null
    }

    class NearbyRestaurantsBean {
        var restaurant: RestaurantBean? = null

        class RestaurantBean {
            var id: String? = null
            var apikey: String? = null
            var name: String? = null
            var url: String? = null
            var location: LocationBeanX? = null
            var cuisines: String? = null
            var thumb: String? = null
            @SerializedName("user_rating")
            var userRating: UserRatingBean? = null

            class LocationBeanX {
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

            class UserRatingBean {
                @SerializedName("aggregate_rating")
                var aggregateRating: String? = null
            }
        }
    }
}