package com.rickAndMorty.data.api

import com.rickAndMorty.domain.entity.CharactersList
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface CharacterAPI {
    @GET("character/")
    suspend fun getCharacter(
        @Query("page")
        page: Int = 1,
    ): Response<CharactersList>

}