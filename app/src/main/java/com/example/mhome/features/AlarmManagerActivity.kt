package com.example.mhome.features

import android.app.AlarmManager
import android.app.PendingIntent
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.mhome.R
import com.example.mhome.databinding.ActivityAlarmManagerBinding
import java.util.Date

class AlarmManagerActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAlarmManagerBinding
    private lateinit var context: Context
    private lateinit var alarmManager: AlarmManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAlarmManagerBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // initializing context and alarmManager
        context = this
        alarmManager = getSystemService(Context.ALARM_SERVICE) as AlarmManager

        binding.btnCreate.setOnClickListener {
            val seconds = binding.etTimer.text.toString().toInt()*1000
            val intent = Intent(context,BReceiver::class.java)
            val pendingIntent = PendingIntent.getBroadcast(context,0,intent,PendingIntent.FLAG_UPDATE_CURRENT)
            Log.d("TAJ", "Created: " + Date().toString())
            alarmManager.set(AlarmManager.RTC_WAKEUP,System.currentTimeMillis()+seconds,pendingIntent)
        }
        binding.btnUpdate.setOnClickListener {
            val seconds = binding.etTimer.text.toString().toInt()*1000
            val intent = Intent(context,BReceiver::class.java)
            val pendingIntent = PendingIntent.getBroadcast(context,0,intent,PendingIntent.FLAG_UPDATE_CURRENT)
            Log.d("TAJ", "Updated: " + Date().toString())
            alarmManager.set(AlarmManager.RTC_WAKEUP,System.currentTimeMillis()+seconds,pendingIntent)

        }
        binding.btnCancel.setOnClickListener {
            val intent = Intent(context,BReceiver::class.java)
            val pendingIntent = PendingIntent.getBroadcast(context,0,intent,PendingIntent.FLAG_UPDATE_CURRENT)
            Log.d("TAJ", "Cancel: " + Date().toString())
            alarmManager.cancel(pendingIntent)

        }
        binding.btnBack.setOnClickListener { onBackPressed() }
    }

    class BReceiver:BroadcastReceiver(){
        override fun onReceive(context: Context?, intent: Intent?) {
            Log.d("TAJ", "Receive: " + Date().toString())
        }
    }
}