package org.carlosjgr7.project.di
import org.carlosjgr7.project.ui.home.episodes.EpisodesViewmodel
import org.carlosjgr7.project.ui.home.characters.CharactersViewModel
import org.koin.compose.viewmodel.dsl.viewModelOf
import org.koin.dsl.module


val uiModule = module{
    viewModelOf(::EpisodesViewmodel)
    viewModelOf(::CharactersViewModel)
}