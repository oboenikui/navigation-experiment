package com.oboenikui.navigationsample.di

import android.app.Application
import com.oboenikui.navigationsample.App
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidSupportInjectionModule::class,
        ActivityModule::class,
        AppModule::class
    ]
)
interface AppComponent : AndroidInjector<App> {
    @Component.Factory
    interface Factory {

        fun create(): AppComponent
    }
}

fun Application.createAppComponent() = DaggerAppComponent.factory()
    .create()