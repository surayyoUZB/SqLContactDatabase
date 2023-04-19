package com.yoo.sqlcontactdatabase.Adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.appcompat.view.menu.MenuView.ItemView
import androidx.recyclerview.widget.RecyclerView
import com.yoo.sqlcontactdatabase.databinding.ItemGroupBinding
import com.yoo.sqlcontactdatabase.model.Contact

class RvAdapter:RecyclerView.Adapter<RvAdapter.ViewHolder>() {

    var contactList= mutableListOf<Contact>()

    inner class ViewHolder(private val binding: ItemGroupBinding):RecyclerView.ViewHolder(binding.root){
        fun bind(contact: Contact){
            binding.name.text=contact.name
            binding.number.text=contact.number
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemGroupBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun getItemCount(): Int {
        return contactList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(contactList[position])
    }
}