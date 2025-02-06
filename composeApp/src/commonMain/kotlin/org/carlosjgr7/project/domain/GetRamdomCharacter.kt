package org.carlosjgr7.project.domain

import kotlinx.datetime.Clock
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toLocalDateTime
import org.carlosjgr7.project.data.database.entity.CharacterOfTheDayEntity
import org.carlosjgr7.project.domain.model.CharacterOfTheDayModel
import org.carlosjgr7.project.domain.model.SingleCharacterModel
import org.carlosjgr7.project.ui.home.characters.CharacterState

class GetRamdomCharacter(private val repository: Repository) {

    suspend operator fun invoke(): SingleCharacterModel {

        val characterEntity: CharacterOfTheDayModel? = repository.getCharacterEntity()
        val selectedDay = getCurrentDayOfTheYear()

        if (characterEntity != null && characterEntity.selectedDay == selectedDay) {
            return characterEntity.characterModel
        }else{
            val result = getRamdonCharacter()
            repository.saveCharacterDb(CharacterOfTheDayModel(result, selectedDay))
            return result
        }

    }

    private suspend fun getRamdonCharacter(): SingleCharacterModel {
        val ramdomCharacter = (0..826).random()
        return repository.getSingleCharacter(ramdomCharacter)
    }

    private fun getCurrentDayOfTheYear(): String {
        val instant = Clock.System.now()
        val localtime = instant.toLocalDateTime(TimeZone.currentSystemDefault())
        return "${localtime.dayOfYear}${localtime.year}"
    }
}