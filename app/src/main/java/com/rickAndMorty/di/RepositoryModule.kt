package com.rickAndMorty.di

import com.rickAndMorty.data.api.CharacterAPI
import com.rickAndMorty.data.repository.CharacterRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepositoryModule {

    @Singleton
    @Provides
    fun getNewsRepository(characterAPI: CharacterAPI): CharacterRepository =
        CharacterRepository(characterAPI)
}