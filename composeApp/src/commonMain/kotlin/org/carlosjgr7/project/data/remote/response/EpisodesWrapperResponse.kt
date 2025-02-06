package org.carlosjgr7.project.data.remote.response

import kotlinx.serialization.Serializable


@Serializable
data class EpisodesWrapperResponse(
    val info: InfoResponse,
    val results: List<EpisodeResponse>
)
