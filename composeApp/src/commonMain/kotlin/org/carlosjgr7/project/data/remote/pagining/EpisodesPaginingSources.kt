package org.carlosjgr7.project.data.remote.pagining

import org.carlosjgr7.project.data.remote.ApiService
import androidx.paging.PagingSource
import androidx.paging.PagingState
import io.ktor.utils.io.errors.IOException
import org.carlosjgr7.project.domain.model.EpisodeModel
import org.carlosjgr7.project.domain.model.SingleCharacterModel

class EpisodesPaginingSources(private val api: ApiService) :
    PagingSource<Int, EpisodeModel>() {
    override fun getRefreshKey(state: PagingState<Int, EpisodeModel>): Int? {
        return state.anchorPosition
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, EpisodeModel> {
        return try {
            val page = params.key ?: 1
            val response = api.getAllEpisodes(page)
            val episodes = response.results
            val prev = if (page == 1) null else page - 1
            val next = if (response.info.next == null) null else page + 1

             LoadResult.Page(
                data = episodes.map { it.toDomain() },
                prevKey = prev,
                nextKey = next
            )
        } catch (e: IOException) {
            return LoadResult.Error(e)
        }
    }


}