package com.mergeadapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.recyclerview.widget.RecyclerView

class HeaderAdapter(private val onOfferClick: OnOfferClick) :
    RecyclerView.Adapter<HeaderAdapter.HeaderViewHolder>() {

    class HeaderViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val btnOffer: Button = itemView.findViewById(R.id.btn_offer)
        fun bind(onOfferClick: OnOfferClick) {
            btnOffer.setOnClickListener {
                when {
                    btnOffer.text.toString().contains("show", true) -> {
                        btnOffer.text = itemView.resources.getString(R.string.hide_offer)
                        onOfferClick.onOfferClick(true)
                    }
                    btnOffer.text.toString().contains("hide", true) -> {
                        btnOffer.text = itemView.resources.getString(R.string.show_offer)
                        onOfferClick.onOfferClick(false)
                    }
                }
            }
        }
    }

    interface OnOfferClick {
        fun onOfferClick(isShow: Boolean)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        HeaderViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.layout_header, parent,
                false
            )
        )

    override fun getItemCount(): Int = 1

    override fun onBindViewHolder(holder: HeaderViewHolder, position: Int) =
        holder.bind(onOfferClick)

}