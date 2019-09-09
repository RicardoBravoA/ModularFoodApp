package com.rba.detail.data.api

import com.rba.model.entity.response.RestaurantDetailResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface ApiInterface {

    @Headers("user-key: 91e09c0fd22df60f32cb7b33e68c3165")
    @GET("restaurant")
    fun restaurantDetail(
        @Query("res_id") id: String
    ): Call<RestaurantDetailResponse>

}