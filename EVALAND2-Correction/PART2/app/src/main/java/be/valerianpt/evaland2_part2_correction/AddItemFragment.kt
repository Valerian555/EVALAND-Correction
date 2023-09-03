package be.valerianpt.evaland2_part2_correction

import android.app.AlertDialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioButton
import androidx.navigation.fragment.findNavController
import be.valerianpt.evaland2_part2_correction.databinding.FragmentAddItemBinding

class AddItemFragment : Fragment() {
    private lateinit var binding: FragmentAddItemBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAddItemBinding.inflate(layoutInflater)

        //confirmer ajout
        binding.addButton.setOnClickListener {
            addItem()
        }

        //retour en arrière
        binding.cancelButton.setOnClickListener {
            findNavController().navigateUp()
        }

        return binding.root
    }

    private fun addItem() {
        if (binding.nameInput.text.isEmpty() || binding.countInput.text.isEmpty()) {
            val builder = AlertDialog.Builder(context)
            builder.setTitle("Erreur")
            builder.setMessage("Données incompletes")
            builder.setPositiveButton("Ok") { dialog, which -> }
            builder.show()

        } else {
            val itemName = binding.nameInput.text.toString()
            val itemCount = binding.countInput.text.toString().toInt()
            val itemType: ItemType = onRadioButtonClicked()

            //ajout des données dans la liste
            itemList.add(Item(itemName, itemCount, itemType))

            //retour vers l'ancien fragment
            findNavController().navigateUp()
        }
    }

    private fun onRadioButtonClicked(): ItemType {
        return when {
            binding.foodRadiobutton.isChecked -> ItemType.food
            binding.drinkRadiobutton.isChecked -> ItemType.drink
            binding.homeRadiobutton.isChecked -> ItemType.home
            binding.healthRadiobutton.isChecked -> ItemType.hygiene
            else -> ItemType.food
        }
    }
}