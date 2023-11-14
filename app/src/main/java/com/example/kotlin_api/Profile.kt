package com.example.kotlin_api

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.example.kotlin_api.databinding.ActivityProfileBinding

class Profile : AppCompatActivity() {
    private lateinit var binding: ActivityProfileBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val character =  intent.getSerializableExtra("charaData") as Character


        with(binding) {
            Glide.with(root)
                .load(character.img) // Assuming img is the URL or resource for the image
                .into(ivImage)
            tvName.text = character.name
            tvScpecies.text = character.species
        }
    }
}