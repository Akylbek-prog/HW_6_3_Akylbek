package com.example.hw_6_3_akylbek.ui.screen.episodes

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.hw_6_3_akylbek.data.dto.episode.EpisodeDTO
import com.example.hw_6_3_akylbek.data.repository.EpisodeRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class EpisodesViewModel(
    private val repository: EpisodeRepository
) : ViewModel() {

    private val _episodeStateFlow = MutableStateFlow<List<EpisodeDTO>>(emptyList())
    val episodeStateFlow = _episodeStateFlow.asStateFlow()

    fun fetchAllEpisodes() {
        viewModelScope.launch(Dispatchers.IO) {
            val episodes = repository.fetchAllEpisodes()
            episodes?.let {
                _episodeStateFlow.value = it
            }
        }
    }
}
