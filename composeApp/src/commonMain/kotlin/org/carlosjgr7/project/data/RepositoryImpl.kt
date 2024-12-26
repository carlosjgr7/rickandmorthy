package org.carlosjgr7.project.data

import org.carlosjgr7.project.data.remote.ApiService
import org.carlosjgr7.project.domain.Repository
import org.carlosjgr7.project.domain.model.SingleCharacterModel

class RepositoryImpl(private val apiService: ApiService) : Repository {
    override suspend fun getSingleCharacter(id: Int): SingleCharacterModel {
        return apiService.getSingleCharacter(id).toDomain()
    }
}
