package com.event.e_summit

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import com.event.e_summit.databinding.ActivityEventsBinding
import com.google.android.material.appbar.MaterialToolbar
import com.google.firebase.auth.FirebaseAuth

class ActivityEvents : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_events)

        val toolbar : MaterialToolbar
        toolbar = findViewById(R.id.material_toolbar)
        toolbar.setOnMenuItemClickListener { item->
            if(item.itemId == R.id.sign_out_user)
            {
                FirebaseAuth.getInstance().signOut()
                val intent = Intent(this, ActivitySignIn::class.java)
                startActivity(intent)
                finish()
            }
            return@setOnMenuItemClickListener true
        }

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                onBackPressed()
                return true
            }
            // Add other cases if needed
            else -> return super.onOptionsItemSelected(item)
        }
    }
}