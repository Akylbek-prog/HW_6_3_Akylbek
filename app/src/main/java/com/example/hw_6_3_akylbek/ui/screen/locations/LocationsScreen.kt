package com.example.hw_6_3_akylbek.ui.screen.locations

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.hw_6_3_akylbek.data.dto.location.LocationDTO
import org.koin.androidx.compose.koinViewModel

@Composable
fun LocationsScreen(
    onItemClick: (Int) -> Unit,
    viewModel: LocationsViewModel = koinViewModel()
) {
    val locations by viewModel.locationsStateFlow.collectAsState()

    LaunchedEffect(Unit) {
        viewModel.fetchAllLocations()
    }

    LazyColumn(
        contentPadding = PaddingValues(8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(locations) { location ->
            LocationItem(location = location, onClick = { onItemClick(location.id) })
        }
    }
}

@Composable
fun LocationItem(location: LocationDTO, onClick: () -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onClick() }
    ) {
        Column(modifier = Modifier.padding(12.dp)) {
            Text(text = location.name ?: "Unknown", style = MaterialTheme.typography.titleMedium)
            Text(text = "Type: ${location.type.orEmpty()}")
            Text(text = "Dimension: ${location.dimension.orEmpty()}")
        }
    }
}
