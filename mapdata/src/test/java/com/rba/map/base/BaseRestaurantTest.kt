package com.rba.map.base

import com.rba.model.model.ErrorModel
import com.rba.model.model.RestaurantModel
import com.rba.util.domain.ResultType
import org.junit.runner.RunWith
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
abstract class BaseRestaurantTest {

    private val restaurant = arrayListOf<RestaurantModel>()
    val list = Mockito.spy(restaurant)
    val errorModel = Mockito.mock(ErrorModel::class.java)
    val latitude = "0.0"
    val longitude = "0.0"

    fun generateResultTypeSuccess(list: List<RestaurantModel>): ResultType<List<RestaurantModel>, ErrorModel> =
        ResultType.Success(list)

    fun generateResultTypeError(errorModel: ErrorModel): ResultType<List<RestaurantModel>, ErrorModel> =
        ResultType.Error(errorModel)
}