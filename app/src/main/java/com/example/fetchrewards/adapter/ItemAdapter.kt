package com.example.fetchrewards.adapter

import android.app.Activity
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.fetchrewards.model.InformationItems
import com.example.fetchrewards.R


class ItemAdapter(private val context: Activity, private val dataItems: List<Pair<Int, List<InformationItems>>>) :
    RecyclerView.Adapter<ItemAdapter.MyViewHolder>() {

    class MyViewHolder (itemView: View) :RecyclerView.ViewHolder(itemView){
        val listId: TextView = itemView.findViewById(R.id.headerTV)
        val names: TextView = itemView.findViewById(R.id.contentTV)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):MyViewHolder  {
            val itemView = LayoutInflater.from(context).inflate(R.layout.each_group, parent, false)
            return MyViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return dataItems.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        // get the list ID for this ViewHolder
        val listId = dataItems[position].second[0]

        // set the list ID headertextView for this ViewHolder
        holder.listId.text = "List ${listId.listId}"

        // join the names  and id of all Items in this list and set the contentTV text for this ViewHolder
        val names = dataItems[position].second.joinToString("\n\n") { "Name: ${it.name!!}\nID: ${it.id} " }
        holder.names.text = names




}
    }