package com.example.hw_6_3_akylbek.ui.screen.episodes.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.hw_6_3_akylbek.data.dto.episode.EpisodeDTO
import com.example.hw_6_3_akylbek.data.repository.EpisodeRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class EpisodeDetailViewModel(
    private val repository: EpisodeRepository
) : ViewModel() {

    private val _episodeStateFlow = MutableStateFlow<EpisodeDTO?>(null)
    val episodeStateFlow = _episodeStateFlow.asStateFlow()

    fun fetchEpisodeById(id: Int) {
        viewModelScope.launch {
            val result = repository.fetchEpisodeById(id)
            _episodeStateFlow.value = result
        }
    }
}
