package com.event.e_summit

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler

class MainActivity : AppCompatActivity() {

    private val SPLASH_TIME_OUT: Long = 2000 // 2 seconds
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Handler().postDelayed({
            // This code will be executed after the specified delay
            val intent = Intent(this@MainActivity, ActivitySignIn::class.java)
            startActivity(intent)
            finish() // Close the current activity
        }, SPLASH_TIME_OUT)
    }
}