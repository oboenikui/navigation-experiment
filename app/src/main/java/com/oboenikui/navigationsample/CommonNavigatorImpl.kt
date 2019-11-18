package com.oboenikui.navigationsample

import androidx.navigation.findNavController
import com.oboenikui.navigationsample.navigator.CommonNavigator
import javax.inject.Inject

class CommonNavigatorImpl @Inject constructor(mainActivity: MainActivity) : CommonNavigator {

    private val navController by lazy {
        mainActivity.findNavController(R.id.nav_host_fragment_container)
    }

    override fun openWebActivity(url: String) {
        navController.navigate(MainNavigationDirections.actionLaunchWebActivity(url))
    }
}