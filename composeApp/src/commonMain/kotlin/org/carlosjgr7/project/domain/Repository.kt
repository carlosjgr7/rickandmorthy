package org.carlosjgr7.project.domain

import androidx.paging.PagingData
import kotlinx.coroutines.flow.Flow
import org.carlosjgr7.project.data.database.entity.CharacterOfTheDayEntity
import org.carlosjgr7.project.domain.model.CharacterOfTheDayModel
import org.carlosjgr7.project.domain.model.SingleCharacterModel

interface Repository {
    suspend fun getSingleCharacter(id: Int): SingleCharacterModel
    fun getAllCharacters(): Flow<PagingData<SingleCharacterModel>>
    suspend fun getCharacterEntity() : CharacterOfTheDayModel?
    suspend fun saveCharacterDb(characterOfTheDayModel: CharacterOfTheDayModel)
}