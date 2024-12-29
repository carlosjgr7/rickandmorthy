package org.carlosjgr7.project.data

import androidx.paging.PagingConfig
import androidx.paging.PagingData
import app.cash.paging.Pager
import kotlinx.coroutines.flow.Flow
import org.carlosjgr7.project.data.remote.ApiService
import org.carlosjgr7.project.data.remote.pagining.CharactersPaginingSources
import org.carlosjgr7.project.domain.Repository
import org.carlosjgr7.project.domain.model.SingleCharacterModel

class RepositoryImpl(
    private val apiService: ApiService,
    private val characterPagingSource: CharactersPaginingSources
) : Repository {

    companion object {
        private const val MAX_ITEMS = 20
        private const val PREFETCH_DISTANCE = 5
    }

    override suspend fun getSingleCharacter(id: Int): SingleCharacterModel {
        return apiService.getSingleCharacter(id).toDomain()
    }

    override fun getAllCharacters(): Flow<PagingData<SingleCharacterModel>> {
        return Pager(config = PagingConfig(
            pageSize = MAX_ITEMS,
            prefetchDistance = PREFETCH_DISTANCE
        ),
            pagingSourceFactory = { characterPagingSource }).flow
    }
}
