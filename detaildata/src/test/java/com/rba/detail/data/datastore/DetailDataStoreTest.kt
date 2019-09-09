package com.rba.detail.data.datastore

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
class DetailDataStoreTest : BaseDetailTest() {

    private var detailDataStore: DetailDataStore? = null

    @Before
    fun setUp() {
        detailDataStore = Mockito.mock(DetailDataStore::class.java)
    }

    @Test
    fun detailTestSuccessful() = runBlocking {
        BDDMockito.given(detailDataStore?.getDetail(id)).willReturn(
            generateResultTypeSuccess(detailModel)
        )
        detailDataStore?.getDetail(id)
        Mockito.verify(detailDataStore)?.getDetail(id)
        Assert.assertNotNull(detailModel)
    }

    @Test
    fun detailTestError() = runBlocking {
        BDDMockito.given(detailDataStore?.getDetail(id)).willReturn(
            generateResultTypeError(errorModel)
        )
        detailDataStore?.getDetail(id)
        Mockito.verify(detailDataStore)?.getDetail(id)
        Assert.assertNotNull(errorModel)
    }

}