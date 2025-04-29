package com.example.minstrmplanlgning.Presentation.Viewmodel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.minstrmplanlgning.data.remote.AuthRequest
import com.example.minstrmplanlgning.data.remote.RetrofitClient
import com.example.minstrmplanlgning.data.remote.dto.PriceResponseDK2
import kotlinx.coroutines.launch

class AuthViewModel : ViewModel() {

    private val _token = mutableStateOf("")
    val token: State<String> = _token

    private val _prices = mutableStateOf<List<PriceResponseDK2>>(emptyList())
    val prices: State<List<PriceResponseDK2>> = _prices

    private val _error = mutableStateOf("")
    val error: State<String> = _error

    private val _isLoading = mutableStateOf(false)
    val isLoading: State<Boolean> = _isLoading

    fun authenticate(clientId: String, clientSecret: String) {
        _isLoading.value = true
        _error.value = ""

        viewModelScope.launch {
            try {
                val response = RetrofitClient.apiService.getAccessToken(
                    AuthRequest(clientId = clientId, clientSecret = clientSecret)
                )
                _token.value = response.accessToken
            } catch (e: Exception) {
                _error.value = "Authentication failed: ${e.localizedMessage}"
            } finally {
                _isLoading.value = false
            }
        }
    }

    fun fetchPrices(region: String = "DK2") {
        if (_token.value.isBlank()) {
            _error.value = "Missing token, please authenticate first"
            return
        }

        _isLoading.value = true
        _error.value = ""

        viewModelScope.launch {
            try {
                val bearer = "Bearer ${_token.value}"
                val response = RetrofitClient.apiService.getPrices(bearer, region)
                _prices.value = response
            } catch (e: Exception) {
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
