package com.example.tugastablayout

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.tugastablayout.databinding.FragmentLoginBinding

class LoginFragment : Fragment() {

    private var _binding: FragmentLoginBinding? = null
    private val binding get() = _binding!!

    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inisialisasi ViewBinding untuk fragment
        _binding = FragmentLoginBinding.inflate(inflater, container, false)
        val view = binding.root

        // Inisialisasi SharedPreferences untuk menyimpan email
        sharedPreferences = requireActivity().getSharedPreferences("UserPrefs", Context.MODE_PRIVATE)

        // Listener button Login
        binding.btnLogin.setOnClickListener {
            // Mengambil teks dari EditText untuk email dan password
            val email = binding.editTextEmail.text.toString()
            val password = binding.editTextPassword.text.toString()

            // Validasi input
            if (email.isNotEmpty() && password.isNotEmpty()) {
                with(sharedPreferences.edit()) {
                    putString("email", email)
                    apply()
                }

                // Memanggil navigateToDashboard() dari MainActivity untuk pindah halaman
                (requireActivity() as MainActivity).navigateToDashboard()
            } else {
                Toast.makeText(requireContext(), "Please fill in all fields", Toast.LENGTH_SHORT).show()
            }
        }
        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}




