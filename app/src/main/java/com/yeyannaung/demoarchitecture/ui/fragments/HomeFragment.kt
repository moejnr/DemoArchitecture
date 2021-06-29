package com.yeyannaung.demoarchitecture.ui.fragments

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.yeyannaung.demoarchitecture.R
import com.yeyannaung.demoarchitecture.ui.activities.WebViewActivity
import com.yeyannaung.demoarchitecture.utils.AppUtil
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment(R.layout.fragment_home) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btnBrowse.setOnClickListener {
            val url = "https://www.google.com"
            Intent(requireContext(), WebViewActivity::class.java).also {
                it.putExtra("url", url)
                it.putExtra("title", "Google")
                startActivity(it)
            }
//            AppUtil.launchWithChromeCustomTabs(requireContext(), url)
        }
    }
}