package com.example.phoneapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.phoneapp.adpter.GridPhoneAdapter
import com.example.phoneapp.databinding.ActivityPhonesBinding

class PhonesActivity : AppCompatActivity() {
    lateinit var binding:ActivityPhonesBinding
    var phones = ArrayList<String>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPhonesBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setData()
        val gridAdapter = GridPhoneAdapter(this,phones)
        binding.gridView.adapter = gridAdapter

        binding.gridView.setOnItemClickListener { adapterView, view, position, l ->
            val intent = Intent(this,ModelActivity::class.java)
            intent.putExtra("name",phones[position])
            startActivity(intent)
        }
    }

    private fun setData() {
            phones = arrayListOf("Iphone","Samsung","MI","Sony","Huawei","Artel")
    }
}