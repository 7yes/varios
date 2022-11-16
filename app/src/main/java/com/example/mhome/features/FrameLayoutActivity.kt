package com.example.mhome.features

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.mhome.databinding.ActivityFrameLayoutBinding

class FrameLayoutActivity : AppCompatActivity() {

    private lateinit var binding:ActivityFrameLayoutBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityFrameLayoutBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnBack.setOnClickListener { onBackPressed() }
    }
}