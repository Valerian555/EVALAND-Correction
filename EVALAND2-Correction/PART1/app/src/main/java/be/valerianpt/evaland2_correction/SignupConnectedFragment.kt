package be.valerianpt.evaland2_correction

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import be.valerianpt.evaland2_correction.databinding.FragmentConnectedBinding
import be.valerianpt.evaland2_correction.databinding.FragmentSignupConnectedBinding

class SignupConnectedFragment : Fragment() {
    private lateinit var binding: FragmentSignupConnectedBinding
    private val args: SignupConnectedFragmentArgs by navArgs()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSignupConnectedBinding.inflate(layoutInflater)

        binding.helloConnectedText.text = args.userName

        return  binding.root
    }

}