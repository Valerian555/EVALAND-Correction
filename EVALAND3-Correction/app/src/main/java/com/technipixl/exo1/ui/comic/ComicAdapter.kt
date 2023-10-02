package com.technipixl.exo1.ui.comic

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.technipixl.exo1.databinding.CharacterCellLayoutBinding
import com.technipixl.exo1.databinding.ComicCellLayoutBinding
import com.technipixl.exo1.network.model.Character
import com.technipixl.exo1.network.model.CharacterResponse
import com.technipixl.exo1.network.model.Comic
import com.technipixl.exo1.network.model.ComicList
import com.technipixl.exo1.setupImage
import com.technipixl.exo1.ui.character.CharacterAdapter

class ComicAdapter(private val comicList: ComicList,
                   private val onItemClick: (Comic) -> Unit)
    : RecyclerView.Adapter<ComicAdapter.ComicViewHolder>() {
    private lateinit var binding: ComicCellLayoutBinding
    private val comicsList = comicList.items

    class ComicViewHolder(private var binding: ComicCellLayoutBinding,
                              private val onItemClick: (Comic) -> Unit) :
        RecyclerView.ViewHolder(binding.root) {
        fun setup(comic: Comic) {
            binding.comicName.text = comic.name
            binding.container.setOnClickListener {
                onItemClick(comic)
            }
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ComicViewHolder {
        return ComicViewHolder(
            ComicCellLayoutBinding
            .inflate(LayoutInflater.from(parent.context), parent, false),
            onItemClick
        )
    }

    override fun onBindViewHolder(holder: ComicViewHolder, position: Int) {
        holder.setup(comicsList[position])
    }

    //retourne le nbr d'élément à afficher
    override fun getItemCount(): Int {
        return comicsList.size
    }
}