package com.rba.map

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.rba.food.util.ScopedViewModel
import com.rba.util.domain.ResultType
import com.rba.model.model.ErrorModel
import com.rba.model.model.RestaurantModel
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
            when (val result = restaurantUseCase.getRestaurantList(latitude, longitude)) {
                is ResultType.Success -> mutableModel.value = UiViewModel.ShowData(result.value)
                is ResultType.Error -> mutableModel.value = UiViewModel.ShowError(result.value)
            }
        }

    }

    fun onClickRestaurant(restaurantModel: RestaurantModel) {
        mutableModel.value = UiViewModel.Navigation(restaurantModel)
    }

    sealed class UiViewModel {
        class ShowData(val list: List<RestaurantModel>) : UiViewModel()
        class ShowError(val errorModel: ErrorModel) : UiViewModel()
        class Navigation(val restaurantModel: RestaurantModel) : UiViewModel()
        object Refresh : UiViewModel()
    }

    override fun onCleared() {
        destroyScope()
        super.onCleared()
    }

}