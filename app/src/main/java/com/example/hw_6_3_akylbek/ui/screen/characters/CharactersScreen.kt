package com.example.hw_6_3_akylbek.ui.screen.characters

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.example.hw_6_3_akylbek.data.mock.mockCharacters

@Composable
fun CharactersScreen(onItemClick: (Int) -> Unit) {
    LazyColumn(
        contentPadding = PaddingValues(8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(mockCharacters) { character ->
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable { onItemClick(character.id) }
            ) {
                Row(modifier = Modifier.padding(8.dp)) {
                    Image(
                        painter = rememberAsyncImagePainter(character.imageUrl),
                        contentDescription = character.name,
                        modifier = Modifier.size(64.dp),
                        contentScale = ContentScale.Crop
                    )
                    Spacer(modifier = Modifier.width(12.dp))
                    Column {
                        Text(text = character.name, style = MaterialTheme.typography.titleMedium)
                        Text(text = character.status, style = MaterialTheme.typography.bodyMedium)
                    }
                }
            }
        }
    }
}
