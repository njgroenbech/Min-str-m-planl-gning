package com.example.minstrmplanlgning.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.minstrmplanlgning.data.repository.PowerRepository
import kotlinx.coroutines.launch

class PowerViewModel : ViewModel() {

    private val repository = PowerRepository()

    private val _powerPrice = MutableLiveData<Double>()
    val powerPrice: LiveData<Double> = _powerPrice

    fun getPowerPrice() {
        viewModelScope.launch {
            try {
                val response = repository.getPowerPrice()
                _powerPrice.value = response.price
            } catch (e: Exception) {
                _powerPrice.value = -1.0 // Den viser en negativ værdi, hvis der opstår fejl på netværkskaldet
            }
        }
    }
}