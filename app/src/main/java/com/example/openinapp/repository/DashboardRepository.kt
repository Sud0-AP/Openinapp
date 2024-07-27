package com.example.openinapp.repository

import com.example.openinapp.model.DashboardResponse
import com.example.openinapp.network.RetrofitInstance
import retrofit2.Response

class DashboardRepository {
    suspend fun getDashboardData(token: String): Response<DashboardResponse> {
        return RetrofitInstance.apiService.getDashboardData(token)
    }
}
