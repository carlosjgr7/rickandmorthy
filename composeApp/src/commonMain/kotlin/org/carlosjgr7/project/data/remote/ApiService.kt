package org.carlosjgr7.project.data.remote

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.parameter
import org.carlosjgr7.project.data.remote.response.CharactersWrapperResponse
import org.carlosjgr7.project.data.remote.response.EpisodesWrapperResponse
import org.carlosjgr7.project.data.remote.response.SingleCharacter

class ApiService (private val client: HttpClient){
    suspend fun getSingleCharacter(id: Int): SingleCharacter {
        return client.get("/api/character/$id")
            .body()
    }

    suspend fun getAllCharacters(page: Int): CharactersWrapperResponse {
        return client.get("/api/character/"){
            parameter("page", page)
        }.body()
    }

    suspend fun getAllEpisodes(page : Int): EpisodesWrapperResponse {
        return client.get("/api/episode/"){
            parameter("page", page)
        }.body()

    }
}

