package com.technipixl.exo1.ui.character

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.technipixl.exo1.databinding.FragmentCharactersBinding
import com.technipixl.exo1.network.model.Character
import com.technipixl.exo1.network.model.CharacterResponse
import com.technipixl.exo1.network.service.BaseServiceImpl
import com.technipixl.exo1.network.service.CharacterServiceImpl
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.HttpException
import java.util.Date

class CharactersFragment : Fragment() {
    private var binding: FragmentCharactersBinding? = null
    private val characterService by lazy { CharacterServiceImpl() }
    private var adapter: CharacterAdapter? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCharactersBinding.inflate(layoutInflater, container, false)

        retrieveData()

        return binding?.root
    }

    //6. Récupérer les données
    private fun retrieveData() {
        CoroutineScope(Dispatchers.IO).launch {
            val timeStamp = Date().time
            val response = characterService.getCharacters(
                BaseServiceImpl.publicApiKey,
                timeStamp.toString(),
                characterService.hash(timeStamp)
            )
            withContext(Dispatchers.Main) {
                try {
                    if (response.isSuccessful) {
                        response.body().let { body ->
                            if (body != null) {
                                setupRecyclerView(body)
                            }
                        }
                    }
                } catch (e: HttpException) {
                    print(e)
                } catch (e: Throwable) {
                    print(e)
                }
            }
        }
    }

    private fun setupRecyclerView(characterResponse: CharacterResponse) {
        binding?.characterRecyclerView?.layoutManager = LinearLayoutManager(requireContext(), RecyclerView.VERTICAL, false)

        adapter = CharacterAdapter(characterResponse) { character ->
            goToComicFragment(character)
        }
        binding?.characterRecyclerView?.adapter = adapter
    }

    private fun goToComicFragment(character: Character) {
        findNavController().navigate(CharactersFragmentDirections.actionCharactersFragmentToComicsFragment(character.id))
    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }
}