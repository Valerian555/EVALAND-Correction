package be.valerianpt.evaland2_correction

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavArgs
import androidx.navigation.fragment.navArgs
import be.valerianpt.evaland2_correction.databinding.FragmentConnectedBinding

class ConnectedFragment : Fragment() {
    private lateinit var binding: FragmentConnectedBinding
    private val args: ConnectedFragmentArgs by navArgs()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentConnectedBinding.inflate(layoutInflater)

        //changement de la banner
        if (args.imageType == "facebook") {
            binding.connectedImage.setImageResource(R.drawable.facebook)
        } else if (args.imageType == "twitter") {
            binding.connectedImage.setImageResource(R.drawable.twitter)
        }

        return binding.root
    }

}