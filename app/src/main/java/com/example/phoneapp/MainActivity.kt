package com.example.phoneapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.phoneapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnAddPhone.setOnClickListener {
            val intent = Intent(this,PhoneTypesActivity::class.java)
            startActivity(intent)
        }
        binding.btnPhones.setOnClickListener {
            val intent = Intent(this,PhonesActivity::class.java)
            startActivity(intent)
        }
    }
}