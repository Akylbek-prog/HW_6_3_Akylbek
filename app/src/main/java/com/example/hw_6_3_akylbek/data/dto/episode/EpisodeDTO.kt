package com.example.hw_6_3_akylbek.data.dto.episode

data class EpisodeDTO(
    val id: Int,
    val name: String?,
    val episode: String?,
    val characters: List<String>?
)