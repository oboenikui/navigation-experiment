package com.oboenikui.navigationsample.di

import com.oboenikui.navigationsample.feature.account.AccountFragment
import com.oboenikui.navigationsample.feature.detail.DetailFragment
import com.oboenikui.navigationsample.feature.home.HomeFragment
import com.oboenikui.navigationsample.feature.login.EntryFragment
import com.oboenikui.navigationsample.feature.login.LoginFragment
import com.oboenikui.navigationsample.feature.trend.TrendFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class MainActivityModule {

    @ContributesAndroidInjector
    abstract fun contributeHomeFragment(): HomeFragment

    @ContributesAndroidInjector
    abstract fun contributeTrendFragment(): TrendFragment

    @ContributesAndroidInjector
    abstract fun contributeAccountFragment(): AccountFragment

    @ContributesAndroidInjector
    abstract fun contributeDetailFragment(): DetailFragment

    @ContributesAndroidInjector
    abstract fun contributeEntryFragment(): EntryFragment

    @ContributesAndroidInjector
    abstract fun contributeLoginFragment(): LoginFragment
}