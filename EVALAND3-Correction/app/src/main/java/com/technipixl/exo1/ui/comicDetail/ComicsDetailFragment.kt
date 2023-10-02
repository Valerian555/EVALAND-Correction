package com.technipixl.exo1.ui.comicDetail

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.technipixl.exo1.databinding.FragmentComicsDetailBinding
import com.technipixl.exo1.network.model.ComicDetailResponse
import com.technipixl.exo1.network.service.BaseServiceImpl
import com.technipixl.exo1.network.service.CharacterServiceImpl
import com.technipixl.exo1.network.service.ComicServiceImpl
import com.technipixl.exo1.setupImage
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.HttpException
import java.util.Date

class ComicsDetailFragment : Fragment() {

    private var binding: FragmentComicsDetailBinding? = null
    private val args: ComicsDetailFragmentArgs by navArgs()
    private val comicService by lazy { ComicServiceImpl() }
    private var result: ComicDetailResponse? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentComicsDetailBinding.inflate(layoutInflater, container, false)

        binding!!.root.visibility = View.INVISIBLE

        retrieveData()

        return binding?.root
    }

    private fun retrieveData() {
        CoroutineScope(Dispatchers.IO).launch {
            val timeStamp = Date().time
            val response = comicService.comicsDetail(
                args.comicsId,
                BaseServiceImpl.publicApiKey,
                timeStamp.toString(),
                comicService.hash(timeStamp)
            )
            withContext(Dispatchers.Main) {
                try {
                    if (response.isSuccessful) {
                        result = response.body()

                        setupView()

                        binding!!.root.visibility = View.VISIBLE

                        }
                } catch (e: HttpException) {
                    print(e)
                } catch (e: Throwable) {
                    print(e)
                }
            }
        }
    }

    private fun setupView() {
        val imageUrl = "${result?.data?.results?.get(0)?.thumbnail?.path}.${result?.data?.results?.get(0)?.thumbnail?.extension}"
        binding?.comicName?.text = result?.data?.results?.get(0)?.title
        binding?.comicDescription?.text = result?.data?.results?.get(0)?.description

        binding?.comicImage?.let { setupImage(imageUrl, it) }
    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }
}