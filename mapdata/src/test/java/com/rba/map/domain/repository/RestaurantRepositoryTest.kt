package com.rba.map.domain.repository

import com.rba.map.base.BaseRestaurantTest
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.BDDMockito
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class RestaurantRepositoryTest : BaseRestaurantTest() {

    private var restaurantRepository: RestaurantRepository? = null

    @Before
    fun setUp() {
        restaurantRepository = Mockito.mock(RestaurantRepository::class.java)
    }

    @Test
    fun restaurantTestSuccess() = runBlocking {
        BDDMockito.given(restaurantRepository?.getRestaurantList(latitude, longitude)).willReturn(
            generateResultTypeSuccess(list)
        )
        restaurantRepository?.getRestaurantList(latitude, longitude)
        Mockito.verify(restaurantRepository)?.getRestaurantList(latitude, longitude)
        Assert.assertNotNull(list)
    }

    @Test
    fun restaurantTestError() = runBlocking {
        BDDMockito.given(restaurantRepository?.getRestaurantList(latitude, longitude)).willReturn(
            generateResultTypeError(errorModel)
        )
        restaurantRepository?.getRestaurantList(latitude, longitude)
        Mockito.verify(restaurantRepository)?.getRestaurantList(latitude, longitude)
        Assert.assertNotNull(errorModel)
    }

}