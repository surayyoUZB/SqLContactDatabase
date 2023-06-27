package com.yoo.sqlcontactdatabase.Adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.yoo.sqlcontactdatabase.databinding.ItemGroupBinding
import com.yoo.sqlcontactdatabase.model.Contact

//class RvAdapter2:RecyclerView.Adapter<RvAdapter2.ViewHolder>() {
//    var contactList= mutableListOf<Contact>()
//
//    inner class ViewHolder(private val binding: EveryItemLayoutBinding): RecyclerView.ViewHolder(binding.root){
//        fun bind(contact: Contact){
//            binding.text.text=contact.name
//        }
//    }
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
//        return ViewHolder(
//            EveryItemLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
//        )
//    }
//
//    override fun getItemCount(): Int {
//        return contactList.size
//    }
//
//    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
//        holder.bind(contactList[position])
//    }
//}