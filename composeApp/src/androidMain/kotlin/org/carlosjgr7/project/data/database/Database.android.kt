package org.carlosjgr7.project.data.database

import android.content.Context
import androidx.room.Room
import androidx.sqlite.driver.bundled.BundledSQLiteDriver
import kotlinx.coroutines.Dispatchers

fun getDatabase(context: Context): RickMortyDatabase {
    val dbFile = context.getDatabasePath(DATA_BASE_NAME)
    return Room.databaseBuilder<RickMortyDatabase>(context, dbFile.absolutePath)
        .setDriver(BundledSQLiteDriver())
        .setQueryCoroutineContext(Dispatchers.IO)
        .build()
}