package org.carlosjgr7.project.data.remote.response

data class CharactersWrapperResponse(
    val info: InfoResponse,
    val results: List<SingleCharacter>
)