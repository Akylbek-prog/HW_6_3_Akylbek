package com.example.hw_6_3_akylbek.ui.screen.characters.detail

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import org.koin.androidx.compose.koinViewModel

@Composable
fun CharacterDetailScreen(
    id: Int,
    viewModel: CharacterDetailViewModel = koinViewModel()
) {
    val character by viewModel.characterState.collectAsState()

    LaunchedEffect(id) {
        viewModel.fetchCharacterById(id)
    }

    character?.let { char ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            Image(
                painter = rememberAsyncImagePainter(char.image),
                contentDescription = char.name,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(300.dp)
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(text = char.name ?: "Unknown", style = MaterialTheme.typography.titleLarge)
            Text(text = "Status: ${char.status ?: "Unknown"}", style = MaterialTheme.typography.bodyMedium)
            Text(text = "Species: ${char.species ?: "Unknown"}", style = MaterialTheme.typography.bodyMedium)
            Text(text = "Gender: ${char.gender ?: "Unknown"}", style = MaterialTheme.typography.bodyMedium)
            Text(text = "Origin: ${char.origin.name ?: "Unknown"}", style = MaterialTheme.typography.bodyMedium)
            Text(text = "Location: ${char.location.name ?: "Unknown"}", style = MaterialTheme.typography.bodyMedium)
        }
    } ?: run {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            Text("Loading character details...")
        }
    }
}
