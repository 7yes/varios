package com.example.mhome.features

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.mhome.databinding.ActivityLinearLayoutBinding

class LinearLayoutActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLinearLayoutBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityLinearLayoutBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnBack.setOnClickListener{onBackPressed()}
    }
}