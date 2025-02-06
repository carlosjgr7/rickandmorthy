package org.carlosjgr7.project.data.database

import androidx.room.ConstructedBy
import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.RoomDatabaseConstructor
import org.carlosjgr7.project.data.database.dao.UserPreferencesDao
import org.carlosjgr7.project.data.database.entity.CharacterOfTheDayEntity

const val DATA_BASE_NAME = "rick_morty_databae.db"

expect object RickMortyCtor : RoomDatabaseConstructor<RickMortyDatabase>

@Database(entities = [CharacterOfTheDayEntity::class], version = 1)
@ConstructedBy(RickMortyCtor::class)
abstract class RickMortyDatabase : RoomDatabase() {
    abstract fun getPreferencesDao(): UserPreferencesDao
}
