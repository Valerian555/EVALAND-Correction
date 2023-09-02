package be.valerianpt.evaland2_correction

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import be.valerianpt.evaland2_correction.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(layoutInflater)

        //navigation vers les differents fragments
        binding.twitterButton.setOnClickListener {
            findNavController().navigate(HomeFragmentDirections.actionHomeFragmentToTwitterFragment())
        }

        binding.facebookButton.setOnClickListener {
            findNavController().navigate(HomeFragmentDirections.actionHomeFragmentToFacebookFragment())
        }

        binding.newAccountButton.setOnClickListener {
            findNavController().navigate(HomeFragmentDirections.actionHomeFragmentToNewAccountFragment())
        }

        return binding.root
    }
}