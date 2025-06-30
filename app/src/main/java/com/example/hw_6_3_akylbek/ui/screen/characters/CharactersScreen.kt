package com.example.hw_6_3_akylbek.ui.screen.characters

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.example.hw_6_3_akylbek.data.dto.character.CharacterDTO
import org.koin.androidx.compose.koinViewModel

@Composable
fun CharactersScreen(
    onCharacterClick: (Int) -> Unit,
    viewModel: CharactersViewModel = koinViewModel()
) {
    val characters by viewModel.charactersStateFlow.collectAsState()

    LaunchedEffect(Unit) {
        viewModel.fetchAllCharacters()
    }

    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(characters) { character ->
            CharacterItem(character = character, onClick = { onCharacterClick(character.id) })
        }
    }
}

@Composable
fun CharacterItem(character: CharacterDTO, onClick: () -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onClick() }
            .padding(4.dp),
        shape = MaterialTheme.shapes.medium,
    ) {
        Row(
            modifier = Modifier.padding(12.dp),
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            Image(
                painter = rememberAsyncImagePainter(model = character.image),
                contentDescription = character.name,
                modifier = Modifier.size(64.dp)
            )
            Column {
                Text(text = character.name ?: "Unknown", style = MaterialTheme.typography.titleMedium)
                Text(text = "Status: ${character.status ?: "Unknown"}", style = MaterialTheme.typography.bodyMedium)
            }
        }
    }
}
