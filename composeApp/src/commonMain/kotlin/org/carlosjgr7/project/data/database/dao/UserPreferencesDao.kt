package org.carlosjgr7.project.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import org.carlosjgr7.project.data.database.entity.CharacterOfTheDayEntity


@Dao
interface UserPreferencesDao {

    @Query("SELECT * FROM characteroftheday")
    suspend fun getCharacterOfTheDay(): CharacterOfTheDayEntity?

    @Insert( entity = CharacterOfTheDayEntity::class, onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveCharacterOfTheDay(characterOfTheDayEntity: CharacterOfTheDayEntity)


}