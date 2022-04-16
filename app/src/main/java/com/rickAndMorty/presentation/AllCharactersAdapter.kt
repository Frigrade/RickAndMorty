package com.rickAndMorty.presentation

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.rickAndMorty.R
import com.rickAndMorty.domain.entity.Character
import kotlinx.android.synthetic.main.item_character_preview.view.*

class AllCharactersAdapter(
    private val openCharacterBio: (Character) -> Unit,
) : ListAdapter<Character, AllCharactersAdapter.CharacterViewHolder>(DiffUtilCallback()) {

    inner class CharacterViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterViewHolder {
        return CharacterViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_character_preview,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: CharacterViewHolder, position: Int) {
        val character = currentList[position]

        holder.itemView.apply {
            Glide.with(this)
                .load(character.image)
                .into(ivCharacterImage)

            tvName.text = character.name
            tvSpecies.text = resources.getString(R.string.characterSpecies, character.species)
            tvGender.text = resources.getString(R.string.characterGender, character.gender)

            setOnClickListener {
                openCharacterBio(character)
            }
        }
    }

    override fun getItemCount(): Int {
        return currentList.size
    }

}

class DiffUtilCallback : DiffUtil.ItemCallback<Character>() {
    override fun areItemsTheSame(oldItem: Character, newItem: Character): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Character, newItem: Character): Boolean {
        return oldItem.id == newItem.id
    }
}
