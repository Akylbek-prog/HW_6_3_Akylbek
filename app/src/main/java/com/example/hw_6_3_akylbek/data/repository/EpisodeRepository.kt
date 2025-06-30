package com.example.hw_6_3_akylbek.data.repository

import com.example.hw_6_3_akylbek.data.api.EpisodeApiService
import com.example.hw_6_3_akylbek.data.dto.episode.EpisodeDTO

class EpisodeRepository(
    private val api: EpisodeApiService
) {
    suspend fun fetchAllEpisodes(): List<EpisodeDTO>? {
        val response = api.fetchAllEpisodes()
        return if (response.isSuccessful) response.body()?.results else null
    }

    suspend fun fetchEpisodeById(id: Int): EpisodeDTO? {
        val response = api.fetchEpisodeById(id)
        return if (response.isSuccessful) response.body() else null
    }
}
