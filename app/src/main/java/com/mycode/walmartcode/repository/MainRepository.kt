package com.mycode.walmartcode.repository

import com.mycode.walmartcode.service.RetrofitService

class MainRepository constructor(private val retrofitService: RetrofitService) {
    suspend fun getAllCountries() = retrofitService.getAllCountries()
}