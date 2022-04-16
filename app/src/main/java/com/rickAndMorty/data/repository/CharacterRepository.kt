package com.rickAndMorty.data.repository

import com.rickAndMorty.data.api.CharacterAPI
import javax.inject.Inject

class CharacterRepository @Inject constructor(
    private val api: CharacterAPI,
) {
    suspend fun getCharacter(page: Int) =
        api.getCharacter(page)
}