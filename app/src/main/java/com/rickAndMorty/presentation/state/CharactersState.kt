package com.rickAndMorty.presentation.state

import com.rickAndMorty.domain.entity.CharactersList

sealed class CharactersState {
    object Loading : CharactersState()

    data class Content(val data: CharactersList) : CharactersState()
    data class Error(val message: String) : CharactersState()
}
