package com.example.databasedoit

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.databasedoit.databinding.ItemMainBinding

class RecyclerViewHolder(val binding: ItemMainBinding): RecyclerView.ViewHolder(binding.root)

class RecyclerViewAdapter(var dataList : MutableList<String>) : RecyclerView.Adapter<RecyclerViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerViewHolder =
        RecyclerViewHolder(ItemMainBinding.inflate(LayoutInflater.from(parent.context), parent, false))

    override fun onBindViewHolder(holder: RecyclerViewHolder, position: Int) {
        holder.binding.text.text = dataList[position]
    }

    override fun getItemCount(): Int = dataList.size

    fun setData(dataList2: MutableList<String>){
        this.dataList = dataList2
    }
}