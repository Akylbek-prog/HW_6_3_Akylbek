package com.example.hw_6_3_akylbek.data.api

import com.example.hw_6_3_akylbek.data.dto.character.CharacterDTO
import com.example.hw_6_3_akylbek.data.dto.character.ResponseCharacter
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface CharacterApiService {

    @GET ("character")
    suspend fun fetchAllCharacters(): Response<ResponseCharacter>

    @GET("character/{id}")
    suspend fun fetchCharacterById(@Path("id") id: Int): Response<CharacterDTO>
}
