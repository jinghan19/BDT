package com.example.bdt

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class BDAdapter internal constructor(context: Context)
    : RecyclerView.Adapter<BDAdapter.BDViewHolder>() {

    private val inflater: LayoutInflater = LayoutInflater.from(context) // layout is flat when want to show thing then blow, like pump in the data and show to user //inflat the ui
    private var bds = emptyList<BD>() // Cached copy of birthday data


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BDViewHolder { //create one single item
        val itemView = inflater.inflate(R.layout.recyclerview_item, parent, false) //inflat each item which is name and bod to the recycle view in parent
        return BDViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return bds.size
    }

    override fun onBindViewHolder(holder: BDViewHolder, position: Int) { //binf data to the view
        val bdRecord = bds.get(position)

        holder.textViewName.text = bdRecord.name
        holder.textViewDOB.text = bdRecord.dob
    }

    inner class BDViewHolder(itemView: View)
        : RecyclerView.ViewHolder(itemView) {

        val textViewName: TextView = itemView.findViewById(R.id.textViewName)
        val textViewDOB: TextView = itemView.findViewById(R.id.textViewDOB)
    }

    internal fun setBDS(bds: List<BD>) {
        this.bds = bds
        notifyDataSetChanged() //tell when got change
    }

}
