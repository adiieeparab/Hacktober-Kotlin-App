package com.example.kotlincrud.auth

import android.annotation.SuppressLint
import android.os.Bundle
import android.text.Spannable
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.kotlincrud.R
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class ForgetPasswordActivity : AppCompatActivity() {

    private lateinit var emailEt : TextInputEditText
    private lateinit var sendLinkBtn : MaterialButton
    private lateinit var auth : FirebaseAuth

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forget_password)

        emailEt = findViewById(R.id.restEmailEt)
        sendLinkBtn = findViewById(R.id.sendResetLinkBtn)
        auth = Firebase.auth

        sendLinkBtn.setOnClickListener {
            if (!emailEt.text.isNullOrBlank()){
                resetPassword(emailEt.text.toString())
            }
        }

    }

    private fun resetPassword(email: String) {
        auth.sendPasswordResetEmail(email)
            .addOnCompleteListener(this){
                if(it.isSuccessful){
                    Toast.makeText(applicationContext, "Resent Link Sent Successfully", Toast.LENGTH_SHORT).show()
                }else{
                    Toast.makeText(applicationContext, it.exception.toString() , Toast.LENGTH_SHORT).show()
                }
            }
    }

}