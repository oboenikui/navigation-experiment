package com.oboenikui.navigationsample.feature.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.navigation.fragment.navArgs
import com.oboenikui.navigationsample.navigator.CommonNavigator
import dagger.android.support.DaggerFragment
import javax.inject.Inject

class DetailFragment : DaggerFragment() {

    @Inject
    lateinit var commonNavigator: CommonNavigator

    private val args by navArgs<DetailFragmentArgs>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView = inflater.inflate(R.layout.fragment_detail, container, false)
        rootView.findViewById<TextView>(R.id.accountNameView).text = args.content.account.name
        rootView.findViewById<TextView>(R.id.bodyView).text = args.content.body
        rootView.findViewById<View>(R.id.themeColorView)
            .setBackgroundColor(args.content.account.themeColor)
        rootView.findViewById<Button>(R.id.accessButton).setOnClickListener {
            commonNavigator.openWebActivity(args.content.url)
        }
        return rootView
    }
}