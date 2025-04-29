package org.carlosjgr7.project.ui.home.episodes

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import app.cash.paging.compose.collectAsLazyPagingItems
import org.koin.compose.viewmodel.koinViewModel
import org.koin.core.annotation.KoinExperimentalAPI

@OptIn(KoinExperimentalAPI::class)
@Composable
fun EpisodesScreen() {
    val episodesViewmodel = koinViewModel<EpisodesViewmodel>()

    val state by episodesViewmodel.state.collectAsState()
    val episodesState = state.episodes.collectAsLazyPagingItems()





    Box(Modifier.fillMaxSize().background(Color.Blue))
}


