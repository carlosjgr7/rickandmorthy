package org.carlosjgr7.project.domain

import androidx.paging.PagingData
import kotlinx.coroutines.flow.Flow
import org.carlosjgr7.project.domain.model.SingleCharacterModel

interface Repository {
    suspend fun getSingleCharacter(id: Int): SingleCharacterModel
    fun getAllCharacters(): Flow<PagingData<SingleCharacterModel>>
}