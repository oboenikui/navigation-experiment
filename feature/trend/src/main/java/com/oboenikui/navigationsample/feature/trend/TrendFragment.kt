package com.oboenikui.navigationsample.feature.trend

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.oboenikui.navigationsample.domain.model.Account
import com.oboenikui.navigationsample.domain.model.Content
import com.oboenikui.navigationsample.domain.model.Trend
import com.oboenikui.navigationsample.navigator.CommonNavigator
import dagger.android.support.DaggerFragment
import javax.inject.Inject

class TrendFragment : DaggerFragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView = inflater.inflate(R.layout.fragment_trend, container, false)
        val recyclerView = rootView.findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.adapter = TrendAdapter(
            listOf(
                Trend(
                    name = "Android",
                    contents = listOf(
                        Content(
                            body = "Navigation Component is cool!! #Android #Navigation",
                            url = "https://example.com",
                            account = Account(
                                name = "Android Developer",
                                themeColor = 0x3ddc84
                            )
                        ),
                        Content(
                            body = "Will foldable devices become the future standard? #Android #Smartphone",
                            url = "https://example.com",
                            account = Account(
                                name = "Android User",
                                themeColor = 0xffffff
                            )
                        )
                    )
                ),
                Trend(
                    name = "Baseball",
                    contents = listOf(
                        Content(
                            body = """
                            WBSC Premier12 Past Champions
                            - 2015 Korea
                            - 2019 Japan
                        """.trimIndent(),
                            url = "https://example.com",
                            account = Account(
                                name = "Baseball fan",
                                themeColor = 0xffffff
                            )
                        )
                    )
                )
            ),
            findNavController()
        )
        return rootView
    }
}