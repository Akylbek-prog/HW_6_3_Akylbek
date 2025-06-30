package com.example.hw_6_3_akylbek.data.api

import com.example.hw_6_3_akylbek.data.dto.location.LocationDTO
import com.example.hw_6_3_akylbek.data.dto.location.ResponseLocation
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface LocationApiService {
    @GET("location")
    suspend fun fetchAllLocations(): Response<ResponseLocation>

    @GET("location/{id}")
    suspend fun fetchLocationById(@Path("id") id: Int): Response<LocationDTO>
}