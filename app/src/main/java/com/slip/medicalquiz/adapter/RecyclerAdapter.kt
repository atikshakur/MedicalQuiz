package com.slip.medicalquiz.adapter

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import android.view.LayoutInflater
import android.view.View
import android.widget.TextView
import com.slip.medicalquiz.R
import com.slip.medicalquiz.model.Flashcard


class RecyclerAdapter(private var items: ArrayList<Flashcard>): RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, p1: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item, parent, false)
        return ViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return items.size

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.title?.text = items[position].title
        holder.subTitle?.text = items[position].subTitle
    }

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        var title: TextView? = null
        var subTitle: TextView? = null

        init {
            this.title = itemView.findViewById(R.id.title)
            this.subTitle = itemView.findViewById(R.id.subTitle)
        }

    }
}