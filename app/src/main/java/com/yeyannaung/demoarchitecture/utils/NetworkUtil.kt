package com.yeyannaung.demoarchitecture.utils

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.net.NetworkInfo
import android.os.Build

object NetworkUtil {

    @Suppress("DEPRECATION")
    fun isConnectionAvailable(context: Context): Boolean {
        val cm =
                context.applicationContext.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
            val networkCapabilities = cm.getNetworkCapabilities(cm.activeNetwork)
            networkCapabilities?.let {
                return (networkCapabilities.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR)
                        || networkCapabilities.hasTransport(NetworkCapabilities.TRANSPORT_WIFI))
                        || networkCapabilities.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET)
            }
        } else {
            val activeNetwork: NetworkInfo? = cm.activeNetworkInfo
            activeNetwork?.let {
                return activeNetwork.isConnectedOrConnecting
            }
        }
        return false
    }
}