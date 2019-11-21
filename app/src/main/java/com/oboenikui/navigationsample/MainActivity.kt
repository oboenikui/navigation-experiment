package com.oboenikui.navigationsample

import android.os.Bundle
import android.preference.PreferenceManager
import android.view.View
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import dagger.android.support.DaggerAppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : DaggerAppCompatActivity() {

    private val navController by lazy {
        findNavController(R.id.nav_host_fragment_container)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        bottomNavigationView.setupWithNavController(navController)
        navController.addOnDestinationChangedListener { controller, destination, arguments ->
            bottomNavigationView.visibility =
                if (destination.id in BOTTOM_NAV_VISIBLE_DESTINATIONS) {
                    View.VISIBLE
                } else {
                    View.GONE
                }
        }
        if (!PreferenceManager.getDefaultSharedPreferences(this).getBoolean("logged_in", false)) {
            navController.navigate(MainNavigationDirections.actionLogin())
        }
    }

    companion object {
        private val BOTTOM_NAV_VISIBLE_DESTINATIONS = setOf(
            R.id.nav_home_fragment,
            R.id.nav_trend_fragment,
            R.id.nav_account_fragment
        )
    }
}
