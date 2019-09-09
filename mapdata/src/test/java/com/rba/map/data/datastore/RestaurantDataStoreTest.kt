package com.rba.map.data.datastore

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
class RestaurantDataStoreTest : BaseRestaurantTest() {

    private var restaurantDataStore: RestaurantDataStore? = null

    @Before
    fun setUp() {
        restaurantDataStore = Mockito.mock(RestaurantDataStore::class.java)
    }

    @Test
    fun restaurantTestSuccessful() = runBlocking {
        BDDMockito.given(restaurantDataStore?.getRestaurantList(latitude, longitude)).willReturn(
            generateResultTypeSuccess(list)
        )
        restaurantDataStore?.getRestaurantList(latitude, longitude)
        Mockito.verify(restaurantDataStore)?.getRestaurantList(latitude, longitude)

        Assert.assertNotNull(latitude)
    }

    @Test
    fun restaurantTestError() = runBlocking {
        BDDMockito.given(restaurantDataStore?.getRestaurantList(latitude, longitude)).willReturn(
            generateResultTypeError(errorModel)
        )
        restaurantDataStore?.getRestaurantList(latitude, longitude)
        Mockito.verify(restaurantDataStore)?.getRestaurantList(latitude, longitude)

        Assert.assertNotNull(latitude)
    }

}