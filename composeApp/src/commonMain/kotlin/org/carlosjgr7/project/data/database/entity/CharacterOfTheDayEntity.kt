package org.carlosjgr7.project.data.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import org.carlosjgr7.project.domain.model.CharacterOfTheDayModel
import org.carlosjgr7.project.domain.model.SingleCharacterModel


@Entity(tableName = "characteroftheday")
data class CharacterOfTheDayEntity(
    @PrimaryKey
    val id: String,
    val isAlive:Boolean,
    val image: String,
    val name: String,
    val selectedDate:String
) {
    fun toDomain(): CharacterOfTheDayModel? {
        return CharacterOfTheDayModel(
            characterModel = SingleCharacterModel(
                id = id,
                isAlive = isAlive,
                image = image,
                name = name
            ),
            selectedDay = selectedDate
        )
    }
}
