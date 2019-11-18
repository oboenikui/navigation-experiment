package com.oboenikui.navigationsample

import android.os.Bundle
import androidx.navigation.navArgs
import dagger.android.support.DaggerAppCompatActivity
import kotlinx.android.synthetic.main.activity_web.*

class WebActivity : DaggerAppCompatActivity() {

    private val args by navArgs<WebActivityArgs>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_web)
        webView.loadUrl(args.url)
    }
}