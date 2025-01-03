package org.carlosjgr7.project.data.remote.response


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import org.carlosjgr7.project.domain.model.SingleCharacterModel

@Serializable
data class SingleCharacter(
    @SerialName("created")
    val created: String,
    @SerialName("episode")
    val episode: List<String>,
    @SerialName("gender")
    val gender: String,
    @SerialName("id")
    val id: Int,
    @SerialName("image")
    val image: String,
    @SerialName("location")
    val location: Location,
    @SerialName("name")
    val name: String,
    @SerialName("origin")
    val origin: Origin,
    @SerialName("species")
    val species: String,
    @SerialName("status")
    val status: String,
    @SerialName("type")
    val type: String,
    @SerialName("url")
    val url: String
) {
    fun toDomain(): SingleCharacterModel {
        return SingleCharacterModel(
            id = id.toString(),
            isAlive = status.lowercase() == "alive",
            image = image,
            name = name
        )
    }
}