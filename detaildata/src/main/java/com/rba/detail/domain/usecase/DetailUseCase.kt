package com.rba.detail.domain.usecase

import com.rba.detail.domain.repository.DetailRepository
import com.rba.model.model.DetailModel
import com.rba.model.model.ErrorModel
import com.rba.util.domain.ResultType

class DetailUseCase(private val detailRepository: DetailRepository) {

    suspend fun getDetail(
        id: String
    ): ResultType<DetailModel, ErrorModel> {
        return detailRepository.getDetail(id)
    }

}