package org.carlosjgr7.project.di

import io.ktor.client.HttpClient
import io.ktor.client.plugins.DefaultRequest
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.http.ContentType
import io.ktor.http.URLProtocol
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import org.carlosjgr7.project.data.RepositoryImpl
import org.carlosjgr7.project.data.remote.ApiService
import org.carlosjgr7.project.data.remote.pagining.CharactersPaginingSources
import org.carlosjgr7.project.data.remote.pagining.EpisodesPaginingSources
import org.carlosjgr7.project.domain.Repository
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module

val dataModule = module {

    single {
        HttpClient {
            install(ContentNegotiation){
                json(json = Json { ignoreUnknownKeys = true }, contentType = ContentType.Any)
            }
            install(DefaultRequest) {
                url {
                    protocol = URLProtocol.HTTPS
                    host = "rickandmortyapi.com"
//                    parameters.append("key", "value")
                }
            }
        }
    }
    factoryOf(::ApiService)
    factoryOf(::RepositoryImpl) { bind<Repository>() }
    factoryOf(::CharactersPaginingSources)
    factoryOf(::EpisodesPaginingSources)
}