package com.example.mhome.features

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.mhome.MyPreference
import com.example.mhome.databinding.ActivityConstrainLayoutBinding
import com.example.mhome.databinding.ActivityLinearLayoutBinding

class ConstrainLayoutActivity : AppCompatActivity() {

    private lateinit var binding: ActivityConstrainLayoutBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityConstrainLayoutBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Shared Preferences
        binding.btnSavePreference.setOnClickListener {
            // se creo MyPreference class, se necesita un Context y un editor q se saca del context
            val myPreference = MyPreference(this)
            var count = myPreference.getCount()
            count++
            myPreference.setCount(count)
            binding.tvString.text = count.toString()
        }

        binding.btnBack.setOnClickListener { onBackPressed() }
    }
}