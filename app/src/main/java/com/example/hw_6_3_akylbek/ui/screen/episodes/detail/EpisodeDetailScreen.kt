package com.example.hw_6_3_akylbek.ui.screen.episodes.detail

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import org.koin.androidx.compose.koinViewModel

@Composable
fun EpisodeDetailScreen(
    id: Int,
    viewModel: EpisodeDetailViewModel = koinViewModel()
) {
    LaunchedEffect(id) {
        viewModel.fetchEpisodeById(id)
    }

    val episode by viewModel.episodeStateFlow.collectAsState()

    if (episode != null) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.Start
        ) {
            Text(
                text = episode?.name.orEmpty(),
                style = MaterialTheme.typography.headlineSmall
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = "Episode Code: ${episode?.episode.orEmpty()}")
        }
    } else {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            CircularProgressIndicator()
        }
    }
}
