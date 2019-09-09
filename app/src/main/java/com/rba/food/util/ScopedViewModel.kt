package com.rba.food.util

import androidx.annotation.CallSuper
import androidx.lifecycle.ViewModel

abstract class ScopedViewModel : ViewModel(), Scope by Scope.Impl() {

    @CallSuper
    override fun onCleared() {
        destroyScope()
        super.onCleared()
    }
}