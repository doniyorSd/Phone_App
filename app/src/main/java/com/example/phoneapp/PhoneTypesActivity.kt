package com.example.phoneapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.phoneapp.adpter.LinerPhoneAdapter
import com.example.phoneapp.databinding.ActivityPhoneTypesBinding
import com.example.phoneapp.models.Phone

class PhoneTypesActivity : AppCompatActivity() {
    lateinit var binding:ActivityPhoneTypesBinding
    lateinit var linerPhoneAdapter: LinerPhoneAdapter
    var phones = ArrayList<String>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPhoneTypesBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setData()

        linerPhoneAdapter = LinerPhoneAdapter(this,phones)
        binding.listView.adapter = linerPhoneAdapter

        binding.listView.setOnItemClickListener { adapterView, view, position, l ->
            val intent = Intent(this,CreatePhoneActivity::class.java)
            intent.putExtra("name",phones[position])
            startActivity(intent)
        }
    }

    override fun onRestart() {
        finish()
        super.onRestart()
    }
    private fun setData() {
        phones = arrayListOf("Iphone","Samsung","MI","Sony","Huawei","Artel")
    }
}