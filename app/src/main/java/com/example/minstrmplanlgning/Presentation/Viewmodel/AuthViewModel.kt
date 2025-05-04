package com.example.minstrmplanlgning.Presentation.Viewmodel

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.minstrmplanlgning.BuildConfig
import com.example.minstrmplanlgning.data.remote.dto.FullPriceResponse
import com.example.minstrmplanlgning.data.remote.dto.SpotPriceResponse
import com.example.minstrmplanlgning.data.repository.ApiServiceRepository
import com.example.minstrmplanlgning.data.repository.ApiServiceRepositoryImpl
import com.example.minstrmplanlgning.data.useCase.GetFullPricesUseCase
import com.example.minstrmplanlgning.data.useCase.GetSpotPricesUseCase
import kotlinx.coroutines.launch

// Nicholas lavede denne viewmodel

class PriceViewModel : ViewModel() {

    private val _token = mutableStateOf(BuildConfig.BEARER_TOKEN)
    val token: State<String> = _token

    private val priceRepository: ApiServiceRepository = ApiServiceRepositoryImpl()
    private val getPricesUseCase = GetSpotPricesUseCase(priceRepository)
    private val getFullPricesCopenhagenUseCase = GetFullPricesUseCase(priceRepository)

    private val _prices = mutableStateOf<List<SpotPriceResponse>>(emptyList())
    val prices: State<List<SpotPriceResponse>> = _prices

    private val _fullPrices = mutableStateOf<List<FullPriceResponse>>(emptyList())
    val fullPrices: State<List<FullPriceResponse>> = _fullPrices

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
            getPricesUseCase(region)
                .onSuccess { response ->
                    _prices.value = response
                    Log.d("FetchPrices", "Prices loaded successfully.")
                }
                .onFailure { e ->
                    Log.e("FetchPrices", "Error fetching prices", e)
                    _error.value = "Fetching prices failed: ${e.localizedMessage}"
                }
            _isLoading.value = false
        }
    }

    fun getFullPricesCopenhagen() {
        if (_token.value.isBlank()) {
            _error.value = "Missing token, please authenticate first"
            return
        }

        _isLoading.value = true
        _error.value = ""

        viewModelScope.launch {
            getFullPricesCopenhagenUseCase(55.6761, 12.5683)
                .onSuccess { response ->
                    _fullPrices.value = response
                    Log.d("FullPrices", "Prices: $response")
                }
                .onFailure { e ->
                    Log.e("FullPrices", "Error fetching full prices", e)
                    _error.value = "Fetching full prices failed: ${e.localizedMessage}"
                }
            _isLoading.value = false
        }
    }

    fun clearError() {
        _error.value = ""
    }
}