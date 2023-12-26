package com.event.e_summit

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class ActivitySignIn : AppCompatActivity() {


    lateinit var signUpText:TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)


        signUpText = findViewById(R.id.directToSignup)

        signUpText.setOnClickListener {

            val intent = Intent(this , ActivitySignUp::class.java)
            startActivity(intent)
            finish()
        }

    }
}