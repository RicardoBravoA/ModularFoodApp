package com.rba.detail.domain.usecase

import com.rba.detail.domain.repository.DetailRepository
import com.rba.model.model.DetailModel
import com.rba.model.model.ErrorModel
import com.rba.util.domain.callback.BaseCallback

class DetailUseCase(private val detailRepository: DetailRepository) {

    suspend fun getDetail(
        id: String,
        baseCallback: BaseCallback<DetailModel, ErrorModel>
    ) {
        return detailRepository.getDetail(id, baseCallback)
    }

}