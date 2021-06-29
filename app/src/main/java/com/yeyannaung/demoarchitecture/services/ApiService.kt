package com.yeyannaung.demoarchitecture.services

import retrofit2.http.GET
import retrofit2.http.Headers

interface ApiService {

    @GET
    @Headers("No-Authentication: true")
    suspend fun getData()
}