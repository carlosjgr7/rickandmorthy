package org.carlosjgr7.project.data.remote.pagining

import org.carlosjgr7.project.data.remote.ApiService
import androidx.paging.PagingSource
import androidx.paging.PagingState
import io.ktor.utils.io.errors.IOException
import org.carlosjgr7.project.domain.model.SingleCharacterModel

class CharactersPaginingSources(private val api: ApiService) :
    PagingSource<Int, SingleCharacterModel>() {
    override fun getRefreshKey(state: PagingState<Int, SingleCharacterModel>): Int? {
        return state.anchorPosition
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, SingleCharacterModel> {
        return try {
            val page = params.key ?: 1
            val response = api.getAllCharacters(page)
            val characters = response.results
            val prev = if (page == 1) null else page - 1
            val next = if (response.info.next == null) null else page + 1

             LoadResult.Page(
                data = characters.map { it.toDomain() },
                prevKey = prev,
                nextKey = next
            )
        } catch (e: IOException) {
            return LoadResult.Error(e)
        }
    }


}