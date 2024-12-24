package org.carlosjgr7.project

import android.app.Application
import org.carlosjgr7.project.di.initKoin
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger

class RickMortyApp: Application(){
    override fun onCreate() {
        super.onCreate()
        initKoin{
            androidLogger()
            androidContext(this@RickMortyApp)
        }
    }
}