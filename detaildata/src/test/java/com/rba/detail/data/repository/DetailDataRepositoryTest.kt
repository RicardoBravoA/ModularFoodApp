package com.rba.detail.data.repository

import com.rba.detail.base.BaseDetailTest
import com.rba.detail.data.service.DetailServiceDataStore
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.BDDMockito
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class DetailDataRepositoryTest : BaseDetailTest() {

    private var detailDataRepository: DetailDataRepository? = null
    private var detailServiceDataStore: DetailServiceDataStore? = null

    @Before
    fun setUp() {
        detailDataRepository = Mockito.mock(DetailDataRepository::class.java)
        detailServiceDataStore = Mockito.mock(DetailServiceDataStore::class.java)
    }

    @Test
    fun detailTestSuccessful() = runBlocking {
        BDDMockito.given(detailServiceDataStore?.getDetail(id)).willReturn(
            generateResultTypeSuccess(detailModel)
        )
        BDDMockito.given(detailDataRepository?.getDetail(id)).willReturn(
            generateResultTypeSuccess(detailModel)
        )
        detailServiceDataStore?.getDetail(id)
        Mockito.verify(detailServiceDataStore)?.getDetail(id)

        detailDataRepository?.getDetail(id)
        Mockito.verify(detailDataRepository)?.getDetail(id)
        Assert.assertNotNull(detailModel)
    }

    @Test
    fun detailTestError() = runBlocking {
        BDDMockito.given(detailServiceDataStore?.getDetail(id)).willReturn(
            generateResultTypeError(errorModel)
        )
        BDDMockito.given(detailDataRepository?.getDetail(id)).willReturn(
            generateResultTypeError(errorModel)
        )
        detailServiceDataStore?.getDetail(id)
        Mockito.verify(detailServiceDataStore)?.getDetail(id)

        detailDataRepository?.getDetail(id)
        Mockito.verify(detailDataRepository)?.getDetail(id)
        Assert.assertNotNull(errorModel)
    }

}