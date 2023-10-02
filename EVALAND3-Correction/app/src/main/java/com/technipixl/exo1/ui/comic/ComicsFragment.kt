package com.technipixl.exo1.ui.comic

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.technipixl.exo1.databinding.FragmentComicsBinding
import com.technipixl.exo1.network.model.Character
import com.technipixl.exo1.network.model.CharacterResponse
import com.technipixl.exo1.network.model.Comic
import com.technipixl.exo1.network.model.ComicList
import com.technipixl.exo1.network.service.BaseServiceImpl
import com.technipixl.exo1.network.service.CharacterServiceImpl
import com.technipixl.exo1.setupImage
import com.technipixl.exo1.ui.character.CharacterAdapter
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.HttpException
import java.util.Date
import javax.xml.transform.Result

class ComicsFragment : Fragment() {
    private var binding: FragmentComicsBinding? = null
    private val characterService by lazy { CharacterServiceImpl() }
    private val args: ComicsFragmentArgs by navArgs()
    private var character: Character? = null
    private var adapter: ComicAdapter? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentComicsBinding.inflate(layoutInflater, container, false)

        binding!!.root.visibility = View.INVISIBLE
        binding?.loadingProgressBar?.visibility = View.VISIBLE

        retrieveData()
        return binding?.root
    }

    private fun retrieveData() {
        CoroutineScope(Dispatchers.IO).launch {
            val timeStamp = Date().time
            val response = characterService.getCharacter(
                args.characterId,
                BaseServiceImpl.publicApiKey,
                timeStamp.toString(),
                characterService.hash(timeStamp)
            )
            withContext(Dispatchers.Main) {
                try {
                    if (response.isSuccessful) {
                        response.body().let { body ->
                            if (body != null) {
                                setupRecyclerView(body.data.results[0].comics)

                                setupHeader(body.data.results[0])
                            }
                        }

                        binding?.root?.visibility = View.VISIBLE
                        binding?.loadingProgressBar?.visibility = View.GONE
                        }
                } catch (e: HttpException) {
                    print(e)
                } catch (e: Throwable) {
                    print(e)
                }
            }
        }
    }

    private fun setupHeader(character: Character) {
        val imageUrl = "${character?.thumbnail?.path}.${character?.thumbnail?.extension}"
        binding?.characterName?.text = character?.name
        binding?.let { setupImage(imageUrl, it.characterImage) }
    }

    private fun setupRecyclerView(comicList: ComicList) {
        binding?.comicsRecyclerView?.layoutManager = LinearLayoutManager(requireContext(), RecyclerView.VERTICAL, false)

        adapter = ComicAdapter(comicList) { comic ->
            comic.resourceURI?.let { goToComicsDetailFragment(it) }
        }
        binding?.comicsRecyclerView?.adapter = adapter
    }

    private fun goToComicsDetailFragment(comicId: String) {
        findNavController().navigate(ComicsFragmentDirections.actionComicsFragmentToComicsDetailFragment(comicId.substringAfterLast("/")))
    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }
}