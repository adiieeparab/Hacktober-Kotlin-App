package com.example.kotlincrud.utils

import android.content.SharedPreferences
import android.content.Context


class SharedPrefsHelper {
    fun saveToSharedPrefs(ctx: Context, username : String, loggedIn: Boolean) {
        val sharedPrefs = ctx.getSharedPreferences("kotlin_app_prefs", Context.MODE_PRIVATE)
        val editor = sharedPrefs.edit()
        editor.putString("username",username)
        editor.putBoolean("loggedIn",loggedIn)
        editor.apply()
    }

    fun getSharedPrefs(ctx: Context) : Boolean{
        val sharedPrefs = ctx.getSharedPreferences("kotlin_app_prefs", Context.MODE_PRIVATE)
        return sharedPrefs.getBoolean("loggedIn", false)
    }

    fun clearSharedPrefs(ctx: Context){
        val sharedPrefs = ctx.getSharedPreferences("kotlin_app_prefs", Context.MODE_PRIVATE)
        val editor = sharedPrefs.edit()
        editor.putString("username", null)
        editor.putBoolean("loggedIn", false)
        editor.apply()
    }

}