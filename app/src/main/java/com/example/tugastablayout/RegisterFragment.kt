package com.example.tugastablayout

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.content.Context
import android.content.SharedPreferences
import android.widget.Toast
import androidx.viewpager2.widget.ViewPager2
import com.example.tugastablayout.databinding.FragmentRegisterBinding

class RegisterFragment : Fragment() {

    private var _binding: FragmentRegisterBinding? = null
    private val binding get() = _binding!!

    private lateinit var sharedPreferences: SharedPreferences
    private lateinit var viewPager: ViewPager2

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentRegisterBinding.inflate(inflater, container, false)
        val view = binding.root

        sharedPreferences = requireActivity().getSharedPreferences("UserPrefs", Context.MODE_PRIVATE)
        viewPager = requireActivity().findViewById(R.id.view_pager)

        binding.btnRegister.setOnClickListener {
            val username = binding.editTextUsername.text.toString()
            val email = binding.editTextEmail.text.toString()
            val nim = binding.editTextNIM.text.toString()
            val password = binding.editTextPassword.text.toString()

            if (username.isNotEmpty() && email.isNotEmpty() && nim.isNotEmpty() && password.isNotEmpty()) {
                val text = sharedPreferences.edit()
                text.putString("username", username)
                text.putString("email", email)
                text.putString("nim", nim)
                text.putString("password", password)
                text.apply()

                Toast.makeText(requireContext(), "Registration Successful", Toast.LENGTH_SHORT).show()

                // Pindah ke tab Login
                viewPager.currentItem = 0
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