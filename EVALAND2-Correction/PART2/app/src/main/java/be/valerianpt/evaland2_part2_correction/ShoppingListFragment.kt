package be.valerianpt.evaland2_part2_correction

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import be.valerianpt.evaland2_part2_correction.databinding.FragmentShoppingListBinding
import com.google.android.material.snackbar.Snackbar

class ShoppingListFragment : Fragment() {
    private lateinit var binding: FragmentShoppingListBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentShoppingListBinding.inflate(layoutInflater)

        //titre de la toolbar
        binding.myToolbar.title = "Shopping List"

        //gestion des boutons de la toolbar
        binding.myToolbar.setOnMenuItemClickListener {
            when (it.itemId) {
                R.id.action_custom_button -> {
                    findNavController().navigate(ShoppingListFragmentDirections.actionShoppingListFragmentToAddItemFragment())
                    true
                }

                else -> false
            }
        }

        addItemText()

        setupRecyclerView()

        return binding.root
    }

    private fun setupRecyclerView() {

        //récupération du composant RecyclerView
        val recyclerView = binding.itemRecylerview

        //defintion de son type d'affichage
        recyclerView?.layoutManager = LinearLayoutManager(
            context, RecyclerView.VERTICAL, false
        )

        recyclerView?.adapter = ItemAdapter(itemList) { item ->
            view?.let {
                Snackbar.make(
                    requireContext(),
                    it, item.name, Snackbar.LENGTH_LONG
                ).show()
            }
        }
    }

    private fun addItemText() {
        val noItemText = binding.noItemText

        if (itemList.isEmpty()) {
            noItemText.visibility = View.VISIBLE
        } else {
            noItemText.visibility = View.INVISIBLE
        }
    }
}