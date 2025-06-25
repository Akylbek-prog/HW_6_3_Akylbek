package com.example.hw_6_3_akylbek.ui.screen.episodes

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.hw_6_3_akylbek.data.mock.mockEpisodes

@Composable
fun EpisodeDetailScreen(id: Int) {
    val episode = mockEpisodes.find { it.id == id }

    if (episode != null) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.Start
        ) {
            Text(text = episode.name, style = MaterialTheme.typography.headlineSmall)
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = "Air Date: ${episode.airDate}")
            Text(text = "Code: ${episode.episodeCode}")
        }
    } else {
        Text("Episode not found")
    }
}
