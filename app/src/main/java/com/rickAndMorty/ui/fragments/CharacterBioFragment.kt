package com.rickAndMorty.ui.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.rickAndMorty.R
import com.rickAndMorty.domain.entity.Character
import kotlinx.android.synthetic.main.fragment_character_bio.*

class CharacterBioFragment : Fragment(R.layout.fragment_character_bio) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val character = arguments?.getSerializable("character") as Character

        Glide.with(this)
            .load(character.image)
            .into(ivCharacterBioImage)

        tvNameBio.text = resources.getString(R.string.characterName, character.name)
        tvSpeciesBio.text = resources.getString(R.string.characterSpecies, character.species)
        tvGenderBio.text = resources.getString(R.string.characterGender, character.gender)
        tvStatusBio.text = resources.getString(R.string.characterStatus, character.status)
        tvLocationBio.text =
            resources.getString(R.string.characterLocation, character.location.name)
        tvEpisodesBio.text = resources.getQuantityString(R.plurals.pluralEpisode,
            character.episode.size,
            character.name,
            character.episode.size)

    }
}