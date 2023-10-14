package com.example.kotlincrud

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.button.MaterialButton

class NavigationActivity : AppCompatActivity() {

    private lateinit var login_btn : MaterialButton;
    private lateinit var register_btn : MaterialButton;


    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_navigation)

        login_btn = findViewById(R.id.loginBtn);
        register_btn = findViewById(R.id.registerBtn);

        login_btn.setOnClickListener {
           startActivity(Intent(applicationContext, LoginActivity::class.java))
        }

        register_btn.setOnClickListener {
            startActivity(Intent(applicationContext, SignupActivity::class.java));
        }

    }
}