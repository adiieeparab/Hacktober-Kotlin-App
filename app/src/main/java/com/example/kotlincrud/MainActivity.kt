package com.example.kotlincrud

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.WindowManager
import com.example.kotlincrud.utils.SharedPrefsHelper

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
        )

        Handler(Looper.getMainLooper()).postDelayed({

            if (SharedPrefsHelper().getSharedPrefs(applicationContext)){
                startActivity(Intent(applicationContext, DashboardActivity::class.java))
            }else{
                startActivity(Intent(applicationContext, NavigationActivity::class.java))
            }

        },3000)

    }
}