package com.rba.map.domain.usecase

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
class RestaurantUseCaseTest : BaseRestaurantTest() {

    private var restaurantUseCase: RestaurantUseCase? = null

    @Before
    fun setUp() {
        restaurantUseCase = Mockito.mock(RestaurantUseCase::class.java)
    }

    @Test
    fun restaurantTestSuccess() = runBlocking {
        BDDMockito.given(restaurantUseCase?.getRestaurantList(latitude, longitude)).willReturn(
            generateResultTypeSuccess(list)
        )
        restaurantUseCase?.getRestaurantList(latitude, longitude)
        Mockito.verify(restaurantUseCase)?.getRestaurantList(latitude, longitude)
        Assert.assertNotNull(list)
    }

    @Test
    fun restaurantTestError() = runBlocking {
        BDDMockito.given(restaurantUseCase?.getRestaurantList(latitude, longitude)).willReturn(
            generateResultTypeError(errorModel)
        )
        restaurantUseCase?.getRestaurantList(latitude, longitude)
        Mockito.verify(restaurantUseCase)?.getRestaurantList(latitude, longitude)
        Assert.assertNotNull(errorModel)
    }

}