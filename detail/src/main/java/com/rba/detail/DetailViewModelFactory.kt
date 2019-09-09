package com.rba.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class DetailViewModelFactory : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return if (modelClass.isAssignableFrom(DetailViewModel::class.java)) {
            val detailUseCase =
                com.rba.detail.domain.usecase.DetailUseCase(com.rba.detail.data.repository.DetailDataRepository())
            DetailViewModel(detailUseCase) as T
        } else {
            throw IllegalArgumentException("ViewModel Not Found")
        }
    }

}