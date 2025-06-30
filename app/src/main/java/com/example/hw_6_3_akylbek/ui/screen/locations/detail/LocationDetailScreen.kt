package com.example.hw_6_3_akylbek.ui.screen.locations.detail

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import org.koin.androidx.compose.koinViewModel

@Composable
fun LocationDetailScreen(
    id: Int,
    viewModel: LocationDetailViewModel = koinViewModel()
) {
    LaunchedEffect(id) {
        viewModel.fetchLocationById(id)
    }

    val location by viewModel.locationDetail.collectAsState()

    if (location != null) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.Start
        ) {
            Text(
                text = location?.name ?: "Unknown",
                style = MaterialTheme.typography.headlineSmall
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "Type: ${location?.type.orEmpty()}",
                style = MaterialTheme.typography.bodyMedium
            )
            Text(
                text = "Dimension: ${location?.dimension.orEmpty()}",
                style = MaterialTheme.typography.bodyMedium
            )
        }
    } else {
        Text("Location not found")
    }
}

