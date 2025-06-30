package com.example.hw_6_3_akylbek.ui.screen.characters

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.hw_6_3_akylbek.data.dto.character.CharacterDTO
import com.example.hw_6_3_akylbek.data.repository.CharacterRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class CharactersViewModel(
    private val repository: CharacterRepository
): ViewModel() {

    private val _charactersStateFlow = MutableStateFlow<List<CharacterDTO>>(emptyList())
    val charactersStateFlow = _charactersStateFlow.asStateFlow()

    fun fetchAllCharacters() {
        viewModelScope.launch(Dispatchers.IO) {
            repository.fetchAllCharacters()?.results?.let {
                _charactersStateFlow.value = it
            }
        }
    }
}