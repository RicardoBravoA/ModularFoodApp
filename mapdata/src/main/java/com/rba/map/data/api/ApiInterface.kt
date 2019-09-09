package com.rba.map.data.api

import com.rba.model.entity.response.GeoCodeResponse
import kotlinx.coroutines.Deferred
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface ApiInterface {

    @Headers("user-key: 91e09c0fd22df60f32cb7b33e68c3165")
    @GET("geocode")
    fun restaurantList(
        @Query("lat") latitude: String,
        @Query("lon") longitude: String
    ): Deferred<Response<GeoCodeResponse>>

}