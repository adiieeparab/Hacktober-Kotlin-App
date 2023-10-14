package com.example.kotlincrud.auth

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import com.example.kotlincrud.NavigationActivity
import com.example.kotlincrud.R
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class LoginActivity : AppCompatActivity() {

    private lateinit var usernameEt : TextInputEditText
    private lateinit var passwordEt : TextInputEditText
    private lateinit var loginBtn : MaterialButton
    private lateinit var usernameTxt : String
    private lateinit var passwordTxt : String
    private lateinit var auth : FirebaseAuth
    private lateinit var forgetPasswordTv : TextView

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        auth = Firebase.auth

        usernameEt = findViewById(R.id.usernameEt)
        passwordEt = findViewById(R.id.passwordEt)
        loginBtn = findViewById(R.id.loginBtn)
        forgetPasswordTv = findViewById(R.id.forgetPassTv)

        loginBtn.setOnClickListener {
            usernameTxt = usernameEt.text.toString()
            passwordTxt = passwordEt.text.toString()

            loginUser(usernameTxt,passwordTxt)
        }

        forgetPasswordTv.setOnClickListener {
            startActivity(Intent(applicationContext, ForgetPasswordActivity::class.java))
        }

    }

    private fun loginUser(usernameTxt: String, passwordTxt: String) {

        auth.signInWithEmailAndPassword(usernameTxt,passwordTxt).addOnCompleteListener(this){
            if(it.isSuccessful){
                Toast.makeText(applicationContext, "Login Successful", Toast.LENGTH_SHORT).show()
            }else{
                Toast.makeText(applicationContext, "Bad Credentials", Toast.LENGTH_SHORT).show()
            }
        }

    }
}