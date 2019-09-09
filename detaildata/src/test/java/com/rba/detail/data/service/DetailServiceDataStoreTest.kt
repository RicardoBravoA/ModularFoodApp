package com.rba.detail.data.service

import com.rba.detail.base.BaseDetailTest
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.mockito.BDDMockito
import org.mockito.Mockito

class DetailServiceDataStoreTest : BaseDetailTest() {

    private var detailServiceDataStore: DetailServiceDataStore? = null

    @Before
    fun setUp() {
        detailServiceDataStore = Mockito.mock(DetailServiceDataStore::class.java)
    }

    @Test
    fun detailTestSuccessful() = runBlocking {
        BDDMockito.given(detailServiceDataStore?.getDetail(id)).willReturn(
            generateResultTypeSuccess(detailModel)
        )
        detailServiceDataStore?.getDetail(id)
        Mockito.verify(detailServiceDataStore)?.getDetail(id)
        Assert.assertNotNull(detailModel)
    }

    @Test
    fun detailTestError() = runBlocking {
        BDDMockito.given(detailServiceDataStore?.getDetail(id)).willReturn(
            generateResultTypeError(errorModel)
        )
        detailServiceDataStore?.getDetail(id)
        Mockito.verify(detailServiceDataStore)?.getDetail(id)
        Assert.assertNotNull(errorModel)
    }

}