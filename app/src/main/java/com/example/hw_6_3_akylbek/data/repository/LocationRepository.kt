package com.example.hw_6_3_akylbek.data.repository

import com.example.hw_6_3_akylbek.data.api.LocationApiService
import com.example.hw_6_3_akylbek.data.dto.location.LocationDTO

class LocationRepository(
    private val api: LocationApiService
) {
    suspend fun fetchAllLocations(): List<LocationDTO>? {
        val response = api.fetchAllLocations()
        return if (response.isSuccessful) response.body()?.results else null
    }

    suspend fun fetchLocationById(id: Int): LocationDTO? {
        val response = api.fetchLocationById(id)
        return if (response.isSuccessful) response.body() else null
    }
}