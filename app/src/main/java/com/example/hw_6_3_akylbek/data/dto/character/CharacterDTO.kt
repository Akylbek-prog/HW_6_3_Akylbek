package com.example.hw_6_3_akylbek.data.dto.character

data class CharacterDTO(
    val id: Int = -1,
    val name: String? = "",
    val status: String? = "",
    val species: String? = "",
    val type: String? = "",
    val gender: String? = "",
    val image: String? = "",
    val episode: List<String>? = null,
    val url: String? = "",
    val created: String? = "",
    val location: LocationApiDTO,
    val origin: OriginDTO
)