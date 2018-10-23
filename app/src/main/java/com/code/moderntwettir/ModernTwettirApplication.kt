package com.code.moderntwettir

import android.app.Application

/**
 * Created by engi2nee on 22.10.2018
 */

open class ModernTwettirApplication : Application() {


    override fun onCreate() {
        super.onCreate()

        INSTANCE = this

    }

    companion object {
        lateinit var INSTANCE: ModernTwettirApplication
    }
}

