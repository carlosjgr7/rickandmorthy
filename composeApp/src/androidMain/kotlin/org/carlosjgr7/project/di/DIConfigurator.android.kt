package org.carlosjgr7.project.di

import org.carlosjgr7.project.data.database.RickMortyDatabase
import org.carlosjgr7.project.data.database.getDatabase
import org.koin.core.module.Module
import org.koin.dsl.module

actual fun platformModule(): Module {
    return module {
        single<RickMortyDatabase>{ getDatabase(get()) }
    }
}