package org.carlosjgr7.project.ui.home.episodes

import androidx.paging.PagingData
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emptyFlow
import org.carlosjgr7.project.data.remote.pagining.EpisodesPaginingSources
import org.carlosjgr7.project.domain.model.EpisodeModel

data class EpisodesState(val episodes: Flow<PagingData<EpisodeModel>> = emptyFlow())
