package org.carlosjgr7.project

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import org.carlosjgr7.project.domain.model.SingleCharacterModel
import org.carlosjgr7.project.ui.home.characters.CharacterOfTheDay
import org.carlosjgr7.project.ui.home.characters.CharactersScreen


@Preview(showBackground = true)
@Composable
fun CharacterOfTheDayPreview() {
    CharacterOfTheDay(
        SingleCharacterModel(
            id = "1",
            isAlive = true,
            image = "https://rickandmortyapi.com/api/character/avatar/1.jpeg",
            name = "Rick"
        )
    )
}