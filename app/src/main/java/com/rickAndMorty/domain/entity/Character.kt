package com.rickAndMorty.domain.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(
    tableName = "characters"
)

data class Character(
    @PrimaryKey(autoGenerate = true)
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