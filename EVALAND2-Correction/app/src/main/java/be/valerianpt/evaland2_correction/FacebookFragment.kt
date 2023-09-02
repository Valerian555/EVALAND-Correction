package be.valerianpt.evaland2_correction

import android.app.AlertDialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import be.valerianpt.evaland2_correction.databinding.FragmentFacebookBinding

class FacebookFragment : Fragment() {
    private lateinit var binding: FragmentFacebookBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFacebookBinding.inflate(layoutInflater)

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
            findNavController().navigate(FacebookFragmentDirections.actionFacebookFragmentToConnectedFragment("facebook"))
        }
    }
}