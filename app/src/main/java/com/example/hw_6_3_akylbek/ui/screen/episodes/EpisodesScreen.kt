package com.example.hw_6_3_akylbek.ui.screen.episodes

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.hw_6_3_akylbek.data.dto.episode.EpisodeDTO
import org.koin.androidx.compose.koinViewModel
import androidx.compose.foundation.lazy.items

@Composable
fun EpisodesScreen(
    onItemClick: (Int) -> Unit,
    viewModel: EpisodesViewModel = koinViewModel()
) {
    val episodes by viewModel.episodeStateFlow.collectAsState()

    LaunchedEffect(Unit) {
        viewModel.fetchAllEpisodes()
    }

    LazyColumn(
        contentPadding = PaddingValues(8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(episodes) { episode ->
            EpisodeItem(episode = episode, onClick = { onItemClick(episode.id) })
        }
    }
}

@Composable
fun EpisodeItem(episode: EpisodeDTO, onClick: () -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onClick() }
    ) {
        Column(modifier = Modifier.padding(12.dp)) {
            Text(text = episode.name ?: "Unknown", style = MaterialTheme.typography.titleMedium)
            Text(text = "Code: ${episode.episode ?: "Unknown"}")
        }
    }
}
