package com.example.kotlincrud

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
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

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        auth = Firebase.auth

        usernameEt = findViewById(R.id.usernameEt);
        passwordEt = findViewById(R.id.passwordEt);
        loginBtn = findViewById(R.id.loginBtn);

        loginBtn.setOnClickListener {
            usernameTxt = usernameEt.text.toString()
            passwordTxt = passwordEt.text.toString()

            loginUser(usernameTxt,passwordTxt)
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