package com.oboenikui.navigationsample.feature.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController
import dagger.android.support.DaggerFragment

class EntryFragment : DaggerFragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView = inflater.inflate(R.layout.fragment_entry, container, false)
        rootView.findViewById<Button>(R.id.continueButton).setOnClickListener {
            findNavController().navigate(EntryFragmentDirections.actionEntryToLogin())
        }

        return rootView
    }
}