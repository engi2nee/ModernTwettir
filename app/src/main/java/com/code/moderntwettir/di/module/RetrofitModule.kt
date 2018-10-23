package com.code.moderntwettir.di.module

import com.code.moderntwettir.network.TwitterApi
import com.code.moderntwettir.utils.BASE_URL
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.Reusable
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

/**
 * Created by engi2nee on 22.10.2018
 */

@Module
@Suppress("unused")
object RetrofitModule {

    @Provides
    @Reusable
    @JvmStatic
    internal fun provideTwitterApi(retrofit: Retrofit): TwitterApi {
        return retrofit.create(TwitterApi::class.java)
    }

    @Provides
    @Reusable
    @JvmStatic
    internal fun provideRetrofitInterface(): Retrofit {
        return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(MoshiConverterFactory.create())
                .addCallAdapterFactory(CoroutineCallAdapterFactory())
                .build()
    }
}
