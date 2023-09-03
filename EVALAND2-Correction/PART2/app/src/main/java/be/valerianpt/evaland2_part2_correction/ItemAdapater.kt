package be.valerianpt.evaland2_part2_correction

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import be.valerianpt.evaland2_part2_correction.databinding.ItemCellLayoutBinding

class ItemAdapter(private val item: MutableList<Item>,
                  private val onItemClick: (Item) -> Unit)
    : RecyclerView.Adapter<ItemViewHolder>() {
    private lateinit var binding: ItemCellLayoutBinding

    //responsable de la création de chaque cellule dans la recyclerView
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ItemViewHolder {
        binding = ItemCellLayoutBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)
        return ItemViewHolder(binding, onItemClick)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.setup(itemList[position])
    }

    //retourne le nbr d'élément à afficher
    override fun getItemCount(): Int {
        return itemList.size
    }
}