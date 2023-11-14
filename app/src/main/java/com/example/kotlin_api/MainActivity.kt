package com.example.kotlin_api

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import com.example.kotlin_api.databinding.ActivityMainBinding
import com.example.kotlin_api.model.RickModel
import com.example.kotlin_api.network.ApiClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val client = ApiClient.getInstance()
        val response = client.getRick()
        val rickCharacters = mutableListOf<Character>()


        response.enqueue(object: Callback<RickModel>{
            override fun onResponse(call: Call<RickModel>, response: Response<RickModel>) {
                val thisResponse = response.body()
                val datas = thisResponse?.result ?: emptyList()

                if(datas.isNotEmpty()){
                    for (i in datas){
                        val character = Character(i.name, i.species, i.image)
                        rickCharacters.add(character)
                    }
                }

                val CharacterAdapter = CharaAdapter(rickCharacters) { clickedCharacter ->
                    val intent = Intent(this@MainActivity, Profile::class.java)
                    intent.putExtra("charaData", clickedCharacter)
                    startActivity(intent)
                    Toast.makeText(this@MainActivity, "Clicked: ${clickedCharacter.name}", Toast.LENGTH_SHORT).show()
                }


                binding.rvName.adapter = CharacterAdapter
            }

            override fun onFailure(call: Call<RickModel>, t: Throwable) {
                Toast.makeText(this@MainActivity, "Connection Error",Toast.LENGTH_SHORT).show()
            }

        })
    }
}