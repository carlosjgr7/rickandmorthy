package org.carlosjgr7.project.data.remote.response

import kotlinx.serialization.Serializable

@Serializable
data class CharactersWrapperResponse(
    val info: InfoResponse,
    val results: List<SingleCharacter>
)