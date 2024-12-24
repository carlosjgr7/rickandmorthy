package org.carlosjgr7.project.data.remote

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import org.carlosjgr7.project.data.remote.response.SingleCharacter

class ApiService (private val client: HttpClient){
    suspend fun getSingleCharacter(id: Int): SingleCharacter {
        return client.get("/api/character/$id")
            .body<SingleCharacter>()
    }
}

