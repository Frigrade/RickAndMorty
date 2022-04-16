package com.rickAndMorty.domain.entity

import java.io.Serializable

data class CharactersList(
    val results: List<Character>,
    val info: Info,
) : Serializable
