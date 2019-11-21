package com.oboenikui.navigationsample.feature.login

import android.os.Bundle
import android.preference.PreferenceManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController
import dagger.android.support.DaggerFragment

class LoginFragment : DaggerFragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView = inflater.inflate(R.layout.fragment_login, container, false)
        rootView.findViewById<Button>(R.id.loginButton).setOnClickListener {
            PreferenceManager.getDefaultSharedPreferences(requireContext()).edit()
                .putBoolean("logged_in", true)
                .apply()

            findNavController().navigate(LoginFragmentDirections.actionLoginToMain())
        }

        return rootView
    }
}