package com.example.hw_6_3_akylbek.ui.screen.locations.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.hw_6_3_akylbek.data.dto.location.LocationDTO
import com.example.hw_6_3_akylbek.data.repository.LocationRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class LocationDetailViewModel(
    private val repository: LocationRepository
) : ViewModel() {

    private val _locationDetail = MutableStateFlow<LocationDTO?>(null)
    val locationDetail = _locationDetail.asStateFlow()

    fun fetchLocationById(id: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            val location = repository.fetchLocationById(id)
            _locationDetail.value = location
        }
    }
}

