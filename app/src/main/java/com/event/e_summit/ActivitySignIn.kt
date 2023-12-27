package com.event.e_summit

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.TextView
import android.widget.Toast
import com.event.e_summit.databinding.ActivitySignInBinding
import com.event.e_summit.databinding.ActivitySignUpBinding
import com.google.firebase.auth.FirebaseAuth

class ActivitySignIn : AppCompatActivity() {


    lateinit var loginBinding: ActivitySignInBinding
    val auth:FirebaseAuth = FirebaseAuth.getInstance()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        loginBinding = ActivitySignInBinding.inflate(layoutInflater)
        val view = loginBinding.root
        setContentView(view)




        loginBinding.directToSignup.setOnClickListener {

            val intent = Intent(this , ActivitySignUp::class.java)
            startActivity(intent)
            finish()
        }

        loginBinding.signInButton.setOnClickListener{
            val user_email = loginBinding.userEmail.text.toString()
            val user_password = loginBinding.userPassword.text.toString()

            SigninWithFireBase(user_email, user_password)
        }

    }

    fun SigninWithFireBase(userEmail : String, userPassword : String){

        auth.signInWithEmailAndPassword(userEmail, userPassword).addOnCompleteListener(this) { task ->

            if(task.isSuccessful)
            {
                Toast.makeText(applicationContext, "Login Successful", Toast.LENGTH_SHORT).show()
                val intent = Intent(this, ActivityEvents::class.java)
                startActivity(intent)
                finish()
            }else{
                Toast.makeText(applicationContext, task.exception.toString(), Toast.LENGTH_SHORT).show()
            }
        }

    }

    override fun onStart() {
        super.onStart()
        val user = auth.currentUser

        if(user != null)
        {
            val intent = Intent(this , ActivityEvents::class.java)
            startActivity(intent)
            finish()
        }
    }

}