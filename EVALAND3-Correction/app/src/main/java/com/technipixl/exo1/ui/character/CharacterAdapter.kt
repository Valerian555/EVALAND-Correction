package com.technipixl.exo1.ui.character

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.technipixl.exo1.databinding.CharacterCellLayoutBinding
import com.technipixl.exo1.network.model.Character
import com.technipixl.exo1.network.model.CharacterResponse
import com.technipixl.exo1.setupImage

class CharacterAdapter(private val characterResponse: CharacterResponse,
                       private val onItemClick: (Character) -> Unit)
    : RecyclerView.Adapter<CharacterAdapter.CharacterViewHolder>() {
    private lateinit var binding: CharacterCellLayoutBinding
    private val characterList = characterResponse.data.results

    class CharacterViewHolder(private var binding: CharacterCellLayoutBinding,
                              private val onItemClick: (Character) -> Unit) :
        RecyclerView.ViewHolder(binding.root) {
        fun setup(character: Character) {
            val imageUrl = "${character.thumbnail.path}.${character.thumbnail.extension}"
            binding.characterName.text = character.name

            setupImage(imageUrl, binding.characterImage)
            binding.container.setOnClickListener {
                onItemClick(character)
            }
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CharacterViewHolder {
        return CharacterViewHolder(CharacterCellLayoutBinding
            .inflate(LayoutInflater.from(parent.context), parent, false),
        onItemClick
        )
    }

    override fun onBindViewHolder(holder: CharacterViewHolder, position: Int) {
        holder.setup(characterList[position])
    }

    //retourne le nbr d'élément à afficher
    override fun getItemCount(): Int {
        return characterList.size
    }
}