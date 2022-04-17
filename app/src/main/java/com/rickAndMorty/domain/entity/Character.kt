package com.rickAndMorty.domain.entity

import java.io.Serializable

data class Character(
    val id: Int,
    val created: String,
    val episode: List<Any>,
    val gender: String,
    val image: String,
    val location: Location,
    val name: String,
    val origin: Origin,
    val species: String,
    val status: String,
    val type: String,
    val url: String,
) : Serializable

data class Origin(
    val name: String,
    val url: String,
) : Serializable

data class Location(
    val name: String,
    val url: String,
) : Serializable