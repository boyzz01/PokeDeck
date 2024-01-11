package com.pokedeck.application

import android.app.Application
import androidx.appcompat.app.AppCompatDelegate
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class AppController : Application() {

    init {
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true)
    }


}