package org.carlosjgr7.project.domain

import org.carlosjgr7.project.data.remote.response.SingleCharacter
import org.carlosjgr7.project.domain.model.SingleCharacterModel

interface Repository {
    suspend fun getSingleCharacter(id: Int): SingleCharacterModel
}