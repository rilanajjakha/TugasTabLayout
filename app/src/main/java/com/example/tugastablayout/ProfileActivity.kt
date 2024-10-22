package com.example.tugastablayout

import android.content.SharedPreferences
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.tugastablayout.databinding.ActivityProfileBinding

class ProfileActivity : AppCompatActivity() {

    private lateinit var binding: ActivityProfileBinding
    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // mengambil data pengguna
        sharedPreferences = getSharedPreferences("UserPrefs", MODE_PRIVATE)
        val username = sharedPreferences.getString("username", "Unknown")
        val nim = sharedPreferences.getString("nim", "N/A")

        // menampilkan data
        binding.textViewUsername.text = "Username : $username"
        binding.textViewNIM.text = "NIM : $nim"

        // buttonback
        binding.buttonBack.setOnClickListener {
            finish()
        }
    }
}


