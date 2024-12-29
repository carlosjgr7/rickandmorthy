package org.carlosjgr7.project.ui.home.characters

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.carlosjgr7.project.domain.GetRamdomCharacter
import org.carlosjgr7.project.domain.Repository
import org.carlosjgr7.project.domain.model.SingleCharacterModel

class CharactersViewModel(val getramdomCharacter: GetRamdomCharacter, private val repository: Repository) : ViewModel() {

    private val _state = MutableStateFlow(CharacterState())
    val state: StateFlow<CharacterState> = _state



    init {
        viewModelScope.launch {
            val result: SingleCharacterModel = withContext(Dispatchers.IO){
                getramdomCharacter()
            }
            _state.update {state -> state.copy(characterOfTheDay = result) }
        }
        getAllCharacters()
    }

    private fun getAllCharacters() {
        _state.update { state -> state.copy(characters = repository.getAllCharacters()) }
    }


}