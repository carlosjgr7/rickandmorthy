package org.carlosjgr7.project.ui.home.characters

import androidx.paging.PagingData
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emptyFlow
import org.carlosjgr7.project.domain.model.SingleCharacterModel

data class CharacterState(
    val characterOfTheDay: SingleCharacterModel? = null,
    val characters: Flow<PagingData<SingleCharacterModel>> = emptyFlow()
)
