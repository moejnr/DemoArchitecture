package com.yeyannaung.demoarchitecture.repositories

import com.yeyannaung.demoarchitecture.services.ApiService
import javax.inject.Inject

class RemoteRepository @Inject constructor(
        val apiService: ApiService
) {

}