package be.valerianpt.evaland2_correction

import android.app.AlertDialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import be.valerianpt.evaland2_correction.databinding.FragmentTwitterBinding

class TwitterFragment : Fragment() {
private lateinit var binding: FragmentTwitterBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentTwitterBinding.inflate(layoutInflater)

        binding.loginButton.setOnClickListener {
            loginVerification()
        }

        return binding.root
    }
    private fun loginVerification() {
        if (binding.emailInput.text.isEmpty() || binding.passwordInput.text.isEmpty()) {
            val builder = AlertDialog.Builder(context)
            builder.setTitle("Erreur")
            builder.setMessage("Login incomplet")

            builder.setPositiveButton("Ok") { dialog, which ->
            }

            builder.show()
        } else {
            findNavController().navigate(TwitterFragmentDirections.actionTwitterFragmentToConnectedFragment("twitter"))
        }
    }
}