package com.example.hw_6_3_akylbek.ui.screen.locations

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.hw_6_3_akylbek.data.mock.mockLocations

@Composable
fun LocationDetailScreen(id: Int) {
    val location = mockLocations.find { it.id == id }

    if (location != null) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.Start
        ) {
            Text(text = location.name, style = MaterialTheme.typography.headlineSmall)
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = "Type: ${location.type}")
            Text(text = "Dimension: ${location.dimension}")
        }
    } else {
        Text("Location not found")
    }
}
