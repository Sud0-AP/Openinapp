package com.example.openinapp.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.openinapp.model.DashboardResponse
import com.example.openinapp.repository.DashboardRepository
import com.example.openinapp.util.TokenManager
import kotlinx.coroutines.launch

class DashboardViewModel(application: Application) : AndroidViewModel(application) {
    private val repository = DashboardRepository()
    val dashboardData = MutableLiveData<DashboardResponse>()
    val errorMessage = MutableLiveData<String>()

    fun fetchDashboardData() {
        val token = TokenManager.getToken(getApplication<Application>().applicationContext)
        if (token != null) {
            viewModelScope.launch {
                val response = repository.getDashboardData(token)
                if (response.isSuccessful) {
                    dashboardData.postValue(response.body())
                } else {
                    errorMessage.postValue("Error: ${response.message()}")
                }
            }
        } else {
            errorMessage.postValue("Token not found")
        }
    }
}
