package com.keltiga.eccomerce.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.keltiga.eccomerce.R
import com.keltiga.eccomerce.databinding.ItemSliderBinding
import com.keltiga.eccomerce.model.ResponseNewsUpdateItem

class SliderAdapter(private val items: List<ResponseNewsUpdateItem>,
                    private var onItemClick: (ResponseNewsUpdateItem) -> Unit) : RecyclerView.Adapter<SliderAdapter.ViewHolder>() {

    inner class ViewHolder(var binding: ItemSliderBinding) : RecyclerView.ViewHolder(binding.root) {
        init {
            binding.root.setOnClickListener {
                onItemClick.invoke(items[adapterPosition])
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemSliderBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentItem = items[position]
        holder.itemView.setOnClickListener{
            onItemClick(currentItem)
        }
        holder.binding.titleSlider.text = items[position].title
        Glide.with(holder.itemView)
            .load(items[position].newsImage)
            .centerCrop()
            .placeholder(R.drawable.ic_launcher_background)
            .into(holder.binding.sliderImage)
    }

    override fun getItemCount(): Int {
        return items.size
    }
}
