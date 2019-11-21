package com.oboenikui.navigationsample.feature.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.oboenikui.navigationsample.domain.model.Account
import com.oboenikui.navigationsample.domain.model.Content
import dagger.android.support.DaggerFragment

class HomeFragment : DaggerFragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val rootView = inflater.inflate(R.layout.fragment_home, container, false)
        val recyclerView = rootView.findViewById<RecyclerView>(R.id.recyclerView)
        val adapter = HomeAdapter(DUMMY_DATA)
        adapter.onContentItemClick = {
            findNavController().navigate(HomeFragmentDirections.actionHomeToDetail(it))
        }
        recyclerView.adapter = adapter
        return rootView
    }

    companion object {
        private val DUMMY_DATA = (0..50).map {
            Content(
                body = "the quick brown fox jumps over the lazy dog",
                url = "https://example.com",
                account = Account(
                    name = "Cat lover",
                    themeColor = 0xff336688L.toInt()
                )
            )
        }
    }
}