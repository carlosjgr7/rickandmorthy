package org.carlosjgr7.project.di

import org.carlosjgr7.project.domain.GetRamdomCharacter
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module


val domainModule = module{

    factoryOf(::GetRamdomCharacter)

}