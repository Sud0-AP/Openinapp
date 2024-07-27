package com.example.openinapp.network

import com.example.openinapp.model.DashboardResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header

interface ApiService {
    @GET("dashboardNew")
    suspend fun getDashboardData(
        @Header("Authorization") token: String
    ): Response<DashboardResponse>
}
