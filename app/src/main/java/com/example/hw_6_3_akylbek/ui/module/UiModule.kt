package com.example.hw_6_3_akylbek.ui.module

import com.example.hw_6_3_akylbek.ui.screen.characters.CharactersViewModel
import com.example.hw_6_3_akylbek.ui.screen.characters.detail.CharacterDetailViewModel
import com.example.hw_6_3_akylbek.ui.screen.locations.detail.LocationDetailViewModel
import com.example.hw_6_3_akylbek.ui.screen.episodes.EpisodesViewModel
import com.example.hw_6_3_akylbek.ui.screen.episodes.detail.EpisodeDetailViewModel
import com.example.hw_6_3_akylbek.ui.screen.locations.LocationsViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val uiModule = module {
    viewModel {CharactersViewModel(get())}
    viewModel { CharacterDetailViewModel(get()) }

    viewModel { EpisodesViewModel(get()) }
    viewModel { EpisodeDetailViewModel(get()) }

    viewModel { LocationsViewModel(get()) }
    viewModel { LocationDetailViewModel(get()) }
}