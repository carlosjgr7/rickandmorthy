package org.carlosjgr7.project.domain.model

import org.carlosjgr7.project.data.database.entity.CharacterOfTheDayEntity

data class CharacterOfTheDayModel(
    val characterModel: SingleCharacterModel,
    val selectedDay: String
) {
    fun toEntity(): CharacterOfTheDayEntity {
        return CharacterOfTheDayEntity(
            id = characterModel.id,
            isAlive = characterModel.isAlive,
            image = characterModel.image,
            name = characterModel.name,
            selectedDate = selectedDay
        )
    }
}