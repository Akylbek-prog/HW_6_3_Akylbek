package com.example.hw_6_3_akylbek.data.repository

import com.example.hw_6_3_akylbek.data.api.CharacterApiService
import com.example.hw_6_3_akylbek.data.dto.character.CharacterDTO
import com.example.hw_6_3_akylbek.data.dto.character.ResponseCharacter

class CharacterRepository (
    private val characterApiService: CharacterApiService
) {
    suspend fun fetchAllCharacters(): ResponseCharacter? {
        val response = characterApiService.fetchAllCharacters()

        return if (response.isSuccessful) {
            response.body()
        } else {
            null
        }
    }

    suspend fun fetchCharacterById(id: Int): CharacterDTO? {
        val response = characterApiService.fetchCharacterById(id)
        return if (response.isSuccessful) {
            response.body()
        } else {
            null
        }
    }
}
