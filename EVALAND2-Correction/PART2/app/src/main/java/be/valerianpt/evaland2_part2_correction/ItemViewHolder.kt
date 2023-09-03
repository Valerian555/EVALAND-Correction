package be.valerianpt.evaland2_part2_correction

import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import be.valerianpt.evaland2_part2_correction.databinding.ItemCellLayoutBinding
import com.google.android.material.snackbar.Snackbar

class ItemViewHolder(private var viewBinding: ItemCellLayoutBinding,
                     private val onItemClick: (Item) -> Unit) :
    RecyclerView.ViewHolder(viewBinding.root) {

    fun setup(item: Item) {
        //change le textView se trouvant dans le xml de la cellule en fonction des éléments se trouvant dans notre liste d'élément
        viewBinding.itemName.text = item.name
        viewBinding.itemCount.text = item.count.toString()

        //changement de la couleur en fonction du type d'item
        when (item.type) {
            ItemType.food -> {viewBinding.itemImage.setImageResource(R.drawable.food)
            viewBinding.itemName.setTextColor(ContextCompat.getColor(itemView.context, R.color.blue))}
            ItemType.drink -> {viewBinding.itemImage.setImageResource(R.drawable.drink)
                viewBinding.itemName.setTextColor(ContextCompat.getColor(itemView.context, R.color.purple))}
            ItemType.home -> {viewBinding.itemImage.setImageResource(R.drawable.home)
                viewBinding.itemName.setTextColor(ContextCompat.getColor(itemView.context, R.color.pink))}
            else -> {viewBinding.itemImage.setImageResource(R.drawable.health)
                viewBinding.itemName.setTextColor(ContextCompat.getColor(itemView.context, R.color.yellow))}
        }

        viewBinding.container.setOnClickListener {
            onItemClick(item)
        }
    }
}