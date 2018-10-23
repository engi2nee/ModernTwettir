package com.code.moderntwettir.base

/**
 * Created by engi2nee on 22.10.2018
 */

import android.arch.lifecycle.ViewModel
import com.code.moderntwettir.di.component.DaggerViewModelInjector
import com.code.moderntwettir.di.component.ViewModelInjector
import com.code.moderntwettir.di.module.RetrofitModule
import com.code.moderntwettir.features.search.SearchViewModel

abstract class BaseViewModel : ViewModel() {
    private val injector: ViewModelInjector = DaggerViewModelInjector
            .builder()
            .networkModule(RetrofitModule)
            .build()

    init {
        inject()
    }


    private fun inject() {
        when (this) {
            is SearchViewModel -> injector.inject(this)
        }
    }
}