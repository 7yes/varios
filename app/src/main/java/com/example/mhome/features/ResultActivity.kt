package com.example.mhome.features

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.mhome.databinding.ActivityResultBinding

class ResultActivity : AppCompatActivity() {

    private lateinit var binding: ActivityResultBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityResultBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnBack.setOnClickListener{
            onBackPressed()
        }
        getAndShowName()
    }

    fun getAndShowName(){
        val bundle = intent.extras
        val name = bundle?.get("KEY_NAME")
        binding.tvName.text= "Welcome Mr $name"
    }
}