package com.example.hw_6_3_akylbek.data.dto.location

data class LocationDTO(
    val id: Int,
    val name: String?,
    val type: String?,
    val dimension: String?,
    val residents: List<String>?
)