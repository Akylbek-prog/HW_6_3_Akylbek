package com.example.hw_6_3_akylbek.data.api

import com.example.hw_6_3_akylbek.data.dto.episode.EpisodeDTO
import com.example.hw_6_3_akylbek.data.dto.episode.ResponseEpisode
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface EpisodeApiService {
    @GET("episode")
    suspend fun fetchAllEpisodes(): Response<ResponseEpisode>

    @GET("episode/{id}")
    suspend fun fetchEpisodeById(@Path("id") id: Int): Response<EpisodeDTO>
}
