package com.rba.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.rba.util.data.ErrorUtil
import com.rba.food.util.ScopedViewModel
import com.rba.model.model.DetailModel
import com.rba.model.model.ErrorModel
import com.rba.util.domain.callback.BaseCallback
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class DetailViewModel(private val detailUseCase: com.rba.detail.domain.usecase.DetailUseCase) : ScopedViewModel() {

    private val mutableModel = MutableLiveData<UiViewModel>()
    val model: LiveData<UiViewModel>
        get() {
            if (mutableModel.value == null) refresh()
            return mutableModel
        }

    init {
        initScope()
    }

    fun refresh() {
        mutableModel.value = UiViewModel.Refresh
    }

    fun getData(id: String) {
        GlobalScope.launch(Dispatchers.Main) {
            detailUseCase.getDetail(
                id,
                object : BaseCallback<DetailModel, ErrorModel> {
                    override fun onSuccess(t: DetailModel) {
                        mutableModel.value = UiViewModel.ShowData(t)
                    }

                    override fun onError(r: ErrorModel) {
                        mutableModel.value = UiViewModel.ShowError(r)
                    }

                    override fun onFailure(t: Throwable) {
                        mutableModel.value = UiViewModel.ShowFailure(
                            ErrorUtil.errorHandler(t)
                        )
                    }
                })
        }

    }

    sealed class UiViewModel {
        class ShowData(val detailModel: DetailModel) : UiViewModel()
        class ShowError(val errorModel: ErrorModel) : UiViewModel()
        class ShowFailure(val defaultErrorModel: com.rba.model.model.DefaultErrorModel) : UiViewModel()
        object Refresh : UiViewModel()
    }

    override fun onCleared() {
        destroyScope()
        super.onCleared()
    }

}