package com.example.minstrmplanlgning.Presentation.Viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.minstrmplanlgning.domain.model.ApplianceData
import com.example.minstrmplanlgning.domain.repository.ApplianceRepository
import kotlinx.coroutines.launch

// Jacob lavede denne viewmodel

class PlanViewModel(
    private val repository: ApplianceRepository
) : ViewModel() {

    fun addAppliance(appliance: ApplianceData) {
        viewModelScope.launch {
            repository.addAppliance(appliance)
        }
    }
}
