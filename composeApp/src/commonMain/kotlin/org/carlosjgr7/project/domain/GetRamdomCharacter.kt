package org.carlosjgr7.project.domain

import org.carlosjgr7.project.domain.model.SingleCharacterModel
import org.carlosjgr7.project.ui.home.characters.CharacterState

class GetRamdomCharacter(private val repository: Repository) {

    suspend operator fun invoke():SingleCharacterModel{
        val ramdomCharacter = (0..826).random()
        return repository.getSingleCharacter(ramdomCharacter)
    }


}