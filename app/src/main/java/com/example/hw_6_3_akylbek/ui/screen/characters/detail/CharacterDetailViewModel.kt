package com.example.hw_6_3_akylbek.ui.screen.characters.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.hw_6_3_akylbek.data.dto.character.CharacterDTO
import com.example.hw_6_3_akylbek.data.repository.CharacterRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class CharacterDetailViewModel(
    private val repository: CharacterRepository
) : ViewModel() {
    private val _characterState = MutableStateFlow<CharacterDTO?>(null)
    val characterState = _characterState.asStateFlow()

    fun fetchCharacterById(id: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            val character = repository.fetchCharacterById(id)
            _characterState.value = character
        }
    }
}