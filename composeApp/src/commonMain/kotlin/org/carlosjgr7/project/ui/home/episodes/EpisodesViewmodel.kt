package org.carlosjgr7.project.ui.home.episodes

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import org.carlosjgr7.project.domain.Repository

class EpisodesViewmodel(private val repository: Repository) : ViewModel()
{
    private val _state = MutableStateFlow(EpisodesState())
    val state: StateFlow<EpisodesState> = _state

    init {
        _state.update { state -> state.copy(episodes = repository.getAllEpisodes().cachedIn(viewModelScope)) }
    }
}