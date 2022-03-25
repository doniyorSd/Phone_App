package com.example.phoneapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.phoneapp.adpter.LinerPhoneAdapter
import com.example.phoneapp.databinding.ActivityModelBinding
import com.example.phoneapp.models.Phone
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class ModelActivity : AppCompatActivity() {
    lateinit var binding: ActivityModelBinding
    var phones = ArrayList<Phone>()
    private val TAG = "ModelActivity"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityModelBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setData()
        val names = ArrayList<String>()
        val str = intent.getStringExtra("name")
        binding.listView.setOnItemClickListener { adapterView, view, position, l ->
            val intent = Intent(this,FeaturesActivity::class.java)
            var features = ""
            phones.forEach {
                if (names[position] == it.name){
                    features = it.features
                }
            }
            intent.putExtra("name",features)
            startActivity(intent)
        }
        phones.forEach {
            Log.d(TAG, "onCreate: $it")
            if (it.type == str) {
                names.add(it.name)
            }
        }
        val adapter = LinerPhoneAdapter(this,names)
        binding.listView.adapter = adapter
    }

    private fun setData() {
        val gson = Gson()
        val shared = getSharedPreferences("shared", MODE_PRIVATE)
        val gsonStr = shared.getString("gson", "")
        if (gsonStr != "") {
            val type = object : TypeToken<ArrayList<Phone>>() {}.type
            phones = gson.fromJson(gsonStr, type)
        }
    }
}