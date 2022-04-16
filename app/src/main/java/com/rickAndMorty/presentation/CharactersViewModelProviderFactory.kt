package com.rickAndMorty.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.rickAndMorty.data.repository.CharacterRepository
import javax.inject.Inject

class CharactersViewModelProviderFactory @Inject constructor(
    private val characterRepository: CharacterRepository,
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return AllCharactersViewModel(characterRepository) as T
    }
}