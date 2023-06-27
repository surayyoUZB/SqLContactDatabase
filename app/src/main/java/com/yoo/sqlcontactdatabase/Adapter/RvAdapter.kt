package com.yoo.sqlcontactdatabase.Adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.yoo.sqlcontactdatabase.databinding.ItemGroupBinding
import com.yoo.sqlcontactdatabase.model.Contact

class RvAdapter:RecyclerView.Adapter<RvAdapter.ViewHolder>() {
    private var onClickListener: OnClickListener? = null
    var contactList= mutableListOf<Contact>()

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
        holder.itemView.setOnClickListener {
            if (onClickListener != null) {
                onClickListener!!.onClick(position)
            }
        }
    }

    fun setOnClickListener(onClickListener: OnClickListener){
        this.onClickListener=onClickListener
    }

    interface OnClickListener {
        fun onClick(position:Int)
    }

    inner class ViewHolder(private val binding: ItemGroupBinding):RecyclerView.ViewHolder(binding.root){
    fun bind(contact: Contact){
        binding.name.text=contact.name
        itemView.setOnClickListener {

        }
    }
}
}