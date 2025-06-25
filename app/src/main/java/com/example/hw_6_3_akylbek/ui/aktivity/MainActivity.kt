package com.example.hw_6_3_akylbek.ui.aktivity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import com.example.hw_6_3_akylbek.ui.components.AppTopBar
import com.example.hw_6_3_akylbek.ui.components.BottomNavigationBar
import com.example.hw_6_3_akylbek.ui.screen.characters.CharacterDetailScreen
import com.example.hw_6_3_akylbek.ui.screen.characters.CharactersScreen
import com.example.hw_6_3_akylbek.ui.screen.episodes.EpisodeDetailScreen
import com.example.hw_6_3_akylbek.ui.screen.episodes.EpisodesScreen
import com.example.hw_6_3_akylbek.ui.screen.locations.LocationDetailScreen
import com.example.hw_6_3_akylbek.ui.screen.locations.LocationsScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                var currentScreen by remember { mutableStateOf("characters") }
                var selectedCharacterId by remember { mutableStateOf<Int?>(null) }
                var selectedLocationId by remember { mutableStateOf<Int?>(null) }
                var selectedEpisodeId by remember { mutableStateOf<Int?>(null) }

                Scaffold(
                    topBar = {
                        AppTopBar(
                            title = when (currentScreen) {
                                "characters" -> "Characters"
                                "characterDetail" -> "Character Detail"
                                "locations" -> "Locations"
                                "locationDetail" -> "Location Detail"
                                "episodes" -> "Episodes"
                                "episodeDetail" -> "Episode Detail"
                                else -> ""
                            },
                            showBackButton = currentScreen.endsWith("Detail"),
                            onBackClick = {
                                currentScreen = when (currentScreen) {
                                    "characterDetail" -> "characters"
                                    "locationDetail" -> "locations"
                                    "episodeDetail" -> "episodes"
                                    else -> "characters"
                                }
                            }
                        )
                    },
                    bottomBar = {
                        if (currentScreen in listOf("characters", "locations", "episodes")) {
                            BottomNavigationBar(currentScreen) { screen ->
                                currentScreen = screen
                            }
                        }
                    }
                ) { innerPadding ->
                    Box(modifier = Modifier.padding(innerPadding)) {
                        when (currentScreen) {
                            "characters" -> CharactersScreen { id ->
                                selectedCharacterId = id
                                currentScreen = "characterDetail"
                            }

                            "characterDetail" -> {
                                val id = selectedCharacterId
                                if (id != null) {
                                    CharacterDetailScreen(id)
                                }
                            }

                            "locations" -> LocationsScreen { id ->
                                selectedLocationId = id
                                currentScreen = "locationDetail"
                            }

                            "locationDetail" -> {
                                val id = selectedLocationId
                                if (id != null) {
                                    LocationDetailScreen(id)
                                }
                            }

                            "episodes" -> EpisodesScreen { id ->
                                selectedEpisodeId = id
                                currentScreen = "episodeDetail"
                            }

                            "episodeDetail" -> {
                                val id = selectedEpisodeId
                                if (id != null) {
                                    EpisodeDetailScreen(id)
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
