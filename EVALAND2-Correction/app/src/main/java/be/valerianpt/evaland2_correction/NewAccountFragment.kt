package be.valerianpt.evaland2_correction

import android.app.AlertDialog
import android.app.DirectAction
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import be.valerianpt.evaland2_correction.databinding.FragmentNewAccountBinding

class NewAccountFragment : Fragment() {
    private lateinit var binding: FragmentNewAccountBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentNewAccountBinding.inflate(layoutInflater)

        binding.signupButton.setOnClickListener {
            signUpVerification()
        }

        return binding.root
    }

    private fun signUpVerification() {
        //email verification
        if (!binding.emailInput.text.contains('@') || binding.emailInput.text.isEmpty()) {
            val builder = AlertDialog.Builder(context)
            builder.setTitle("Erreur")
            builder.setMessage("L'email est invalide.")
            builder.setPositiveButton("Ok") { dialog, which ->
            }
            builder.show()

            return
        }

        //Login verification
        if (binding.loginInput.text.isEmpty()) {
            val builder = AlertDialog.Builder(context)
            builder.setTitle("Erreur")
            builder.setMessage("Le login est vide.")
            builder.setPositiveButton("Ok") { dialog, which ->
            }
            builder.show()

            return
        }

        //passwords confirmation
        if (binding.passwordInput.text.toString() != binding.confirmationInput.text.toString()) {
            val builder = AlertDialog.Builder(context)
            builder.setTitle("Erreur")
            builder.setMessage("Les mots de passe ne correspondent pas.")
            builder.setPositiveButton("Ok") { dialog, which ->
            }
            builder.show()

            return
        }

        //Navigation si les champs sont correctement complétés
        findNavController().navigate(NewAccountFragmentDirections.actionNewAccountFragmentToSignupConnectedFragment("Bonjour ${binding.loginInput.text.toString()}"))
    }
}