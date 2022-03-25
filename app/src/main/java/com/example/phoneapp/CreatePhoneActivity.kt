package com.example.phoneapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.phoneapp.databinding.ActivityCreatePhoneBinding
import com.example.phoneapp.models.Phone
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class CreatePhoneActivity : AppCompatActivity() {
    lateinit var binding: ActivityCreatePhoneBinding
    var phones = ArrayList<Phone>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCreatePhoneBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val gson = Gson()
        val shared = getSharedPreferences("shared", MODE_PRIVATE)
        val edit = shared.edit()

        val strGson = shared.getString("gson", "")
        if (strGson != "") {
            val gsonType = object : TypeToken<ArrayList<Phone>>() {}.type
            phones = gson.fromJson(strGson, gsonType)
        }

        val type = intent.getStringExtra("name")
        binding.add.setOnClickListener {
            val name = binding.etName.text.toString()
            val features = binding.etFeatures.text.toString()

            val phone = Phone(type!!,name, features)
            phones.add(phone)
            val toJson = gson.toJson(phones)
            edit.putString("gson", toJson)
            edit.apply()
            finish()
        }
    }
}