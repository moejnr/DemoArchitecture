package com.yeyannaung.demoarchitecture.ui.activities

import android.annotation.SuppressLint
import android.graphics.Bitmap
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.webkit.WebChromeClient
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient
import com.yeyannaung.demoarchitecture.R
import kotlinx.android.synthetic.main.activity_webview.*
import timber.log.Timber

class WebViewActivity : BaseActivity() {

    lateinit var mUrl: String
    lateinit var title: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_webview)

        setActionBar()

        intent?.let {
            mUrl = it.getStringExtra("url") ?: ""
            title = it.getStringExtra("title") ?: ""
        }

        tvTitle.text = title
        webView.apply {
            setupWebSettings(settings)
            scrollBarStyle = View.SCROLLBARS_INSIDE_OVERLAY
            overScrollMode = View.OVER_SCROLL_NEVER
            // Configure the client to use when opening URLs
            webViewClient = object : WebViewClient() {
                override fun onPageStarted(view: WebView?, url: String?, favicon: Bitmap?) {
                    progressBar.progress = 0
                }
            }
            webChromeClient = object : WebChromeClient() {
                override fun onProgressChanged(view: WebView?, newProgress: Int) {
                    progressBar.progress = newProgress
                    if (newProgress == 100) {
                        progressBar.progress = 0
                    }
                }
            }
            // Load the initial URL
            loadUrl(mUrl)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.browser_option_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> {
                finish()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onBackPressed() {
        if (webView.canGoBack()) {
            webView.goBack()
            return
        }
        super.onBackPressed()
    }

    @SuppressLint("SetJavaScriptEnabled")
    private fun setupWebSettings(settings: WebSettings) {
        settings.javaScriptEnabled = true
        settings.loadsImagesAutomatically = true
        // Enable responsive layout
        settings.useWideViewPort = true
        // Zoom out if the content width is greater than the width of the viewport
        settings.loadWithOverviewMode = true
        // Enable zoom control
        settings.setSupportZoom(true)
        settings.builtInZoomControls = true // Allow pinch to zoom
        settings.displayZoomControls = false // Disable the default zoom controls on the page
    }

    private fun setActionBar() {
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }
}