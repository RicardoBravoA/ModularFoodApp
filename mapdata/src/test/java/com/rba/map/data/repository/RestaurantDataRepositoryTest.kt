package com.rba.map.data.repository

import com.rba.map.base.BaseRestaurantTest
import com.rba.map.data.service.RestaurantServiceDataStore
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.BDDMockito
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class RestaurantDataRepositoryTest : BaseRestaurantTest() {

    private var restaurantDataRepository: RestaurantDataRepository? = null
    private var restaurantServiceDataStore: RestaurantServiceDataStore? = null

    @Before
    fun setUp() {
        restaurantDataRepository = Mockito.mock(RestaurantDataRepository::class.java)
        restaurantServiceDataStore = Mockito.mock(RestaurantServiceDataStore::class.java)
    }

    @Test
    fun restaurantTestSuccessful() = runBlocking {
        BDDMockito.given(restaurantServiceDataStore?.getRestaurantList(latitude, longitude)).willReturn(
            generateResultTypeSuccess(list)
        )
        BDDMockito.given(restaurantDataRepository?.getRestaurantList(latitude, longitude)).willReturn(
            generateResultTypeSuccess(list)
        )
        restaurantServiceDataStore?.getRestaurantList(latitude, longitude)
        Mockito.verify(restaurantServiceDataStore)?.getRestaurantList(latitude, longitude)

        restaurantDataRepository?.getRestaurantList(latitude, longitude)
        Mockito.verify(restaurantDataRepository)?.getRestaurantList(latitude, longitude)

        Assert.assertNotNull(latitude)
    }

    @Test
    fun restaurantTestError() = runBlocking {
        BDDMockito.given(restaurantServiceDataStore?.getRestaurantList(latitude, longitude)).willReturn(
            generateResultTypeError(errorModel)
        )
        BDDMockito.given(restaurantDataRepository?.getRestaurantList(latitude, longitude)).willReturn(
            generateResultTypeSuccess(list)
        )
        restaurantServiceDataStore?.getRestaurantList(latitude, longitude)
        Mockito.verify(restaurantServiceDataStore)?.getRestaurantList(latitude, longitude)

        restaurantDataRepository?.getRestaurantList(latitude, longitude)
        Mockito.verify(restaurantDataRepository)?.getRestaurantList(latitude, longitude)

        Assert.assertNotNull(latitude)
    }

}