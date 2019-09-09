package com.rba.map

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.rba.util.data.ErrorUtil
import com.rba.food.util.ScopedViewModel
import com.rba.model.model.ErrorModel
import com.rba.model.model.RestaurantModel
import com.rba.util.domain.callback.BaseCallback
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainViewModel(private val restaurantUseCase: com.rba.map.domain.usecase.RestaurantUseCase) : ScopedViewModel() {

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

    fun getData(latitude: String, longitude: String) {
        GlobalScope.launch(Dispatchers.Main) {
            restaurantUseCase.getRestaurantList(
                latitude,
                longitude,
                object : BaseCallback<List<RestaurantModel>, ErrorModel> {
                    override fun onSuccess(t: List<RestaurantModel>) {
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

    fun onClickRestaurant(restaurantModel: RestaurantModel) {
        mutableModel.value = UiViewModel.Navigation(restaurantModel)
    }

    sealed class UiViewModel {
        class ShowData(val list: List<RestaurantModel>) : UiViewModel()
        class ShowError(val errorModel: ErrorModel) : UiViewModel()
        class ShowFailure(val defaultErrorModel: com.rba.model.model.DefaultErrorModel) : UiViewModel()
        class Navigation(val restaurantModel: RestaurantModel) : UiViewModel()
        object Refresh : UiViewModel()
    }

    override fun onCleared() {
        destroyScope()
        super.onCleared()
    }

}