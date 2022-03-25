package com.example.phoneapp.adpter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import com.example.phoneapp.R
import com.example.phoneapp.databinding.ItemGridBinding

class GridPhoneAdapter(
    context: Context,
    var phones: ArrayList<String>
) : ArrayAdapter<String>(context, R.layout.item_grid, phones) {
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val itemView: View
        if (convertView == null) {
            itemView =
                LayoutInflater.from(parent.context).inflate(R.layout.item_grid, parent, false)
        } else {
            itemView = convertView
        }

        val bind = ItemGridBinding.bind(itemView)
        bind.tv.text = phones[position]
        return itemView
    }

    override fun getCount(): Int {
        return phones.size
    }
}