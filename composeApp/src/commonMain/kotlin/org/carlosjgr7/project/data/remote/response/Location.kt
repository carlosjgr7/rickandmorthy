package org.carlosjgr7.project.data.remote.response


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Location(
    @SerialName("name")
    val name: String,
    @SerialName("url")
    val url: String
)