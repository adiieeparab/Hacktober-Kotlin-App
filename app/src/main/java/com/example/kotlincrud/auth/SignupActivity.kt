package com.example.kotlincrud.auth

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.kotlincrud.DashboardActivity
import com.example.kotlincrud.R
import com.example.kotlincrud.utils.SharedPrefsHelper
import com.example.kotlincrud.utils.User
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class SignupActivity : AppCompatActivity() {

    private lateinit var nameET : TextInputEditText
    private lateinit var emailET : TextInputEditText
    private lateinit var usernameET : TextInputEditText
    private lateinit var passwordET : TextInputEditText
    private lateinit var confirmPasswordET : TextInputEditText
    private lateinit var signupBTN : MaterialButton
    private lateinit var auth : FirebaseAuth
    private lateinit var db : FirebaseFirestore
    private lateinit var nameTxt: String
    private lateinit var emailTxt : String
    private lateinit var confirmPasswordTxt : String
    private lateinit var usernameTxt : String



    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)

        //  Firebase Authentication and Firestore instantiation
        auth = Firebase.auth
        db = Firebase.firestore

        nameET = findViewById(R.id.nameEt)
        emailET = findViewById(R.id.emailEt)
        usernameET = findViewById(R.id.usernameEt)
        passwordET = findViewById(R.id.passwordEt)
        confirmPasswordET = findViewById(R.id.confirmPasswordEt)
        signupBTN = findViewById(R.id.signupBtn)

        signupBTN.setOnClickListener {
            nameTxt = nameET.text.toString()
            usernameTxt = usernameET.text.toString()
            emailTxt = emailET.text.toString()
            confirmPasswordTxt = confirmPasswordET.text.toString()
            registerUser(nameTxt, usernameTxt,emailTxt,confirmPasswordTxt);
        }

    }

    // Registering a new user on Auth & Firestore
    private fun registerUser(nameTxt: String, usernameTxt: String, emailTxt: String, confirmPasswordTxt: String) {
        auth.createUserWithEmailAndPassword(emailTxt, confirmPasswordTxt)
            .addOnCompleteListener(this){
                if(it.isSuccessful){
                    val user = User(usernameTxt,emailTxt,nameTxt)
                    db.collection("users").document(user.username).set(user)
                    SharedPrefsHelper().saveToSharedPrefs(applicationContext , user.username, true)
                    startActivity(Intent(applicationContext, DashboardActivity::class.java));
                    Toast.makeText(applicationContext,"Welcome",Toast.LENGTH_LONG).show()
                }else{
                    Toast.makeText(applicationContext,"Error",Toast.LENGTH_LONG).show()
                }
            }
    }
}