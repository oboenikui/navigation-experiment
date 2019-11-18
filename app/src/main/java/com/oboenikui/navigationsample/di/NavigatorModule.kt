package com.oboenikui.navigationsample.di

import com.oboenikui.navigationsample.CommonNavigatorImpl
import com.oboenikui.navigationsample.navigator.CommonNavigator
import dagger.Binds
import dagger.Module

@Module
abstract class NavigatorModule {
    @Binds
    abstract fun bindCommonNavigator(impl: CommonNavigatorImpl): CommonNavigator
}