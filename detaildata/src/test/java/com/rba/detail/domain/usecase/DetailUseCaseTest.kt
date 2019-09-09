package com.rba.detail.domain.usecase

import com.rba.detail.base.BaseDetailTest
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.BDDMockito
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class DetailUseCaseTest : BaseDetailTest() {

    private var detailUseCase: DetailUseCase? = null

    @Before
    fun setUp() {
        detailUseCase = Mockito.mock(DetailUseCase::class.java)
    }

    @Test
    fun detailTestSuccess() = runBlocking {
        BDDMockito.given(detailUseCase?.getDetail(id)).willReturn(
            generateResultTypeSuccess(detailModel)
        )
        detailUseCase?.getDetail(id)
        Mockito.verify(detailUseCase)?.getDetail(id)
        Assert.assertNotNull(detailModel)
    }

    @Test
    fun detailTestError() = runBlocking {
        BDDMockito.given(detailUseCase?.getDetail(id)).willReturn(
            generateResultTypeError(errorModel)
        )
        detailUseCase?.getDetail(id)
        Mockito.verify(detailUseCase)?.getDetail(id)
        Assert.assertNotNull(errorModel)
    }

}