package com.example.hw_6_3_akylbek.ui.screen.locations

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.hw_6_3_akylbek.data.dto.location.LocationDTO
import com.example.hw_6_3_akylbek.data.repository.LocationRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class LocationsViewModel(
    private val repository: LocationRepository
) : ViewModel() {
    private val _locationsStateFlow = MutableStateFlow<List<LocationDTO>>(emptyList())
    val locationsStateFlow = _locationsStateFlow.asStateFlow()

    fun fetchAllLocations() {
        viewModelScope.launch {
            val response = repository.fetchAllLocations()
            response?.let { _locationsStateFlow.value = it }
        }
    }
}


