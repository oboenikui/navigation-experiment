package com.oboenikui.navigationsample.di

import com.oboenikui.navigationsample.MainActivity
import com.oboenikui.navigationsample.WebActivity
import com.oboenikui.navigationsample.WebActivityArgs
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityModule {
    @ContributesAndroidInjector(modules = [MainActivityModule::class, NavigatorModule::class])
    abstract fun contributeMainActivity(): MainActivity

    @ContributesAndroidInjector
    abstract fun contributeWebActivity(): WebActivity
}