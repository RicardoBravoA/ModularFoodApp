package com.rba.detail.base

import com.rba.model.model.DetailModel
import com.rba.model.model.ErrorModel
import com.rba.util.domain.ResultType
import org.junit.runner.RunWith
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
abstract class BaseDetailTest {

    val detailModel = Mockito.mock(DetailModel::class.java)
    val errorModel = Mockito.mock(ErrorModel::class.java)
    val id = "0"

    fun generateResultTypeSuccess(detailModel: DetailModel): ResultType<DetailModel, ErrorModel> =
        ResultType.Success(detailModel)

    fun generateResultTypeError(errorModel: ErrorModel): ResultType<DetailModel, ErrorModel> =
        ResultType.Error(errorModel)
}