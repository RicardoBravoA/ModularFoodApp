package com.rba.detail.domain.repository

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
class DetailRepositoryTest : BaseDetailTest() {

    private var detailRepository: DetailRepository? = null

    @Before
    fun setUp() {
        detailRepository = Mockito.mock(DetailRepository::class.java)
    }

    @Test
    fun detailTestSuccess() = runBlocking {
        BDDMockito.given(detailRepository?.getDetail(id)).willReturn(
            generateResultTypeSuccess(detailModel)
        )
        detailRepository?.getDetail(id)
        Mockito.verify(detailRepository)?.getDetail(id)
        Assert.assertNotNull(detailModel)
    }

    @Test
    fun detailTestError() = runBlocking {
        BDDMockito.given(detailRepository?.getDetail(id)).willReturn(
            generateResultTypeError(errorModel)
        )
        detailRepository?.getDetail(id)
        Mockito.verify(detailRepository)?.getDetail(id)
        Assert.assertNotNull(errorModel)
    }

}