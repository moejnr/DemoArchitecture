package com.yeyannaung.demoarchitecture.ui.activities

import android.os.Bundle
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import com.yeyannaung.demoarchitecture.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)

    val navController = navHostFragment.findNavController()
    bottomNavigationView.setupWithNavController(navController)
  }
}