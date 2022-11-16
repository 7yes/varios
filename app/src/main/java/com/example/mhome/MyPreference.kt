package com.example.mhome

import android.content.Context

class MyPreference (context: Context){

    val PREFERENCE_NAME = "SharedPreferenceName"
    val PREFERENCE_NAME_COUNT = "SharedPreferenceCount"
    val PREFERENCE_NAME_STRING = "SharedPreferenceString"


    val preference = context.getSharedPreferences(PREFERENCE_NAME, Context.MODE_PRIVATE)

    fun setCount(count:Int){
        val editor = preference.edit()
        editor.putInt(PREFERENCE_NAME_COUNT,count)
        editor.apply()
    }

    fun getCount():Int{
        return preference.getInt(PREFERENCE_NAME_COUNT,0)
    }
}