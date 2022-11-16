package com.example.mhome

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.mhome.databinding.ActivityMainBinding
import com.example.mhome.features.*

class MainActivity : AppCompatActivity() {

    private lateinit var binding: com.example.mhome.databinding.ActivityMainBinding

    //Para Braodcast receiver
    lateinit var receiver: BroadcastReceiver

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Broadcast receiver, ver onDestroy() tambien
        val filter = IntentFilter()
        filter.addAction(Intent.ACTION_AIRPLANE_MODE_CHANGED)
        filter.addAction(Intent.ACTION_POWER_DISCONNECTED)
        receiver = object : BroadcastReceiver() {
            override fun onReceive(context: Context?, intent: Intent?) {
                Toast.makeText(context, intent?.action, Toast.LENGTH_LONG).show()
            }
        }

        binding.btnGo.setOnClickListener {
            checkName()
        }

        binding.btnLinear.setOnClickListener {
            val intent = Intent(this, LinearLayoutActivity::class.java)
            startActivity(intent)
        }

        binding.btnFrame.setOnClickListener {
            val intent = Intent(this, FrameLayoutActivity::class.java)
            startActivity(intent)
        }

        binding.btnConstrain.setOnClickListener {
            val intent = Intent(this, ConstrainLayoutActivity::class.java)
            startActivity(intent)
        }
        binding.btnAlarmMaganer.setOnClickListener {
            val intent = Intent(this,AlarmManagerActivity::class.java)
            startActivity(intent)
        }
    }

    fun checkName() {
        if (binding.etName.text.isNotEmpty()) {
            val intent = Intent(this, ResultActivity::class.java)
            intent.putExtra("KEY_NAME", binding.etName.text)
            startActivity(intent)
        } else
            errorName()
    }

    fun errorName() {
        Toast.makeText(this, "You need a name", Toast.LENGTH_SHORT).show()
    }

    override fun onDestroy() {
        unregisterReceiver(receiver)
        super.onDestroy()
    }
}

