package com.example.kotlin_api

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.kotlin_api.databinding.CharacterLayoutBinding


class CharaAdapter(
    var char: List<Character>,
    private var onItemClickListener: ((Character) -> Unit)? = null
) : RecyclerView.Adapter<CharaAdapter.CharViewHolder>() {

    inner class CharViewHolder(val binding:CharacterLayoutBinding) : RecyclerView.ViewHolder(binding.root)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = CharacterLayoutBinding.inflate(layoutInflater, parent, false)
        return CharViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CharViewHolder, position: Int) {
        holder.binding.apply {

            // Use Glide to load the image into the ImageView
            Glide.with(root)
                .load(char[position].img) // Assuming img is the URL or resource for the image
                .into(ivChara)
            tvChara.text = char[position].name
            root.setOnClickListener {
                onItemClickListener?.invoke(char[position])
            }
        }
    }

    override fun getItemCount(): Int {
        return char.size
    }
}