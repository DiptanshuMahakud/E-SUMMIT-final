package com.event.e_summit

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.event.e_summit.databinding.ActivitySignUpBinding
import com.google.firebase.auth.FirebaseAuth

class ActivitySignUp : AppCompatActivity() {


    lateinit var signUpBinding: ActivitySignUpBinding
    val auth: FirebaseAuth = FirebaseAuth.getInstance()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        signUpBinding = ActivitySignUpBinding.inflate(layoutInflater)
        val view = signUpBinding.root
        setContentView(view)


        signUpBinding.signUPButton.setOnClickListener {

            val user_email = signUpBinding.userEmail.text.toString()
            val user_password = signUpBinding.userPassword.text.toString()
            signUpWithFirebase(user_email, user_password)

        }
    }

    fun signUpWithFirebase(userEmail : String, userPassword:String)
    {
        auth.createUserWithEmailAndPassword(userEmail, userPassword). addOnCompleteListener { task ->

            if (task.isSuccessful)
            {
                Toast.makeText(applicationContext, "Sign Up Successful", Toast.LENGTH_SHORT).show()
                val intent = Intent(this , ActivityEvents::class.java)
                startActivity(intent)
                finish()
            }else{

                Toast.makeText(applicationContext, task.exception?.toString(), Toast.LENGTH_SHORT).show()
                val intent = Intent(this , ActivitySignUp::class.java)
                startActivity(intent)
                finish()

            }
        }
    }

}