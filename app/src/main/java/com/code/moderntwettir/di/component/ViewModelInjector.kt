package com.code.moderntwettir.di.component

import com.code.moderntwettir.di.module.RetrofitModule
import com.code.moderntwettir.features.search.SearchViewModel
import dagger.Component
import javax.inject.Singleton

/**
 * Created by engi2nee on 22.10.2018
 */

@Singleton
@Component(modules = [(RetrofitModule::class)])
interface ViewModelInjector {

    fun inject(searchViewModel: SearchViewModel)

    @Component.Builder
    interface Builder {
        fun build(): ViewModelInjector
        fun networkModule(retrofitModule: RetrofitModule): Builder
    }
}