package com.oboenikui.navigationsample

import com.oboenikui.navigationsample.di.createAppComponent
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication

class App: DaggerApplication() {
    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return createAppComponent()
    }
}