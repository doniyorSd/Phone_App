package com.example.phoneapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.phoneapp.databinding.ActivityFeaturesBinding

class FeaturesActivity : AppCompatActivity() {
    lateinit var binding: ActivityFeaturesBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFeaturesBinding.inflate(layoutInflater)
        setContentView(binding.root)
        
        val features = intent.getStringExtra("name")
        binding.tv.text = features
    }
}