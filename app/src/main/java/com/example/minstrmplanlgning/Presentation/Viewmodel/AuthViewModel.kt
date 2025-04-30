package com.example.minstrmplanlgning.Presentation.Viewmodel

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.minstrmplanlgning.BuildConfig
import com.example.minstrmplanlgning.data.remote.RetrofitClient
import com.example.minstrmplanlgning.data.remote.dto.PriceResponseDK2
import kotlinx.coroutines.launch

class AuthViewModel : ViewModel() {

    private val _token = mutableStateOf(BuildConfig.BEARER_TOKEN)  // already includes "Bearer "
    val token: State<String> = _token

    private val _prices = mutableStateOf<List<PriceResponseDK2>>(emptyList())
    val prices: State<List<PriceResponseDK2>> = _prices

    private val _error = mutableStateOf("")
    val error: State<String> = _error

    private val _isLoading = mutableStateOf(false)
    val isLoading: State<Boolean> = _isLoading

    fun fetchPrices(region: String = "DK2") {
        if (_token.value.isBlank()) {
            _error.value = "Missing token, please set BEARER_TOKEN in BuildConfig"
            return
        }

        _isLoading.value = true
        _error.value = ""

        viewModelScope.launch {
            try {
                val bearer = "Bearer ${BuildConfig.BEARER_TOKEN}"
                val response = RetrofitClient.apiService.getPrices(bearer, region)
                _prices.value = response
                Log.d("FetchPrices", "Prices loaded successfully.")
            } catch (e: Exception) {
                Log.e("FetchPrices", "Error fetching prices", e)
                _error.value = "Fetching prices failed: ${e.localizedMessage}"
            } finally {
                _isLoading.value = false
            }
        }
    }

    fun clearError() {
        _error.value = ""
    }
}
