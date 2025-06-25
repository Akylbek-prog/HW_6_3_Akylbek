package com.example.hw_6_3_akylbek.ui.screen.episodes

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.hw_6_3_akylbek.data.mock.mockEpisodes

@Composable
fun EpisodesScreen(onItemClick: (Int) -> Unit) {
    LazyColumn(
        contentPadding = PaddingValues(8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(mockEpisodes) { episode ->
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable { onItemClick(episode.id) }
            ) {
                Column(modifier = Modifier.padding(12.dp)) {
                    Text(text = episode.name, style = MaterialTheme.typography.titleMedium)
                    Text(text = "Air Date: ${episode.airDate}")
                    Text(text = "Code: ${episode.episodeCode}")
                }
            }
        }
    }
}
