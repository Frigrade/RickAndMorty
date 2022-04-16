package com.rickAndMorty.di

import com.rickAndMorty.data.repository.CharacterRepository
import com.rickAndMorty.presentation.CharactersViewModelProviderFactory
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ViewModelModule {

    @Singleton
    @Provides
    fun provideViewModelFactory(characterRepository: CharacterRepository): CharactersViewModelProviderFactory =
        CharactersViewModelProviderFactory(characterRepository)
}