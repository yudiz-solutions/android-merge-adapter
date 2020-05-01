package com.mergeadapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class FooterAdapter : RecyclerView.Adapter<FooterAdapter.FooterViewHolder>() {

    private var isProgress = true

    class FooterViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val progress: ProgressBar = itemView.findViewById(R.id.progress)
        private val quote: TextView = itemView.findViewById(R.id.tv_food_quote)
        fun bind(isProgress: Boolean) {
            if (isProgress) {
                progress.visibility = View.VISIBLE
                quote.visibility = View.GONE
            } else {
                progress.visibility = View.GONE
                quote.visibility = View.VISIBLE
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        FooterViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.layout_footer, parent,
                false
            )
        )

    fun changeState() {
        isProgress = false
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int = 1

    override fun onBindViewHolder(holder: FooterViewHolder, position: Int) =
        holder.bind(isProgress)

}