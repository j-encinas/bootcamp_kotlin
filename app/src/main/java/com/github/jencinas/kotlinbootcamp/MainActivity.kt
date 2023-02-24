package com.github.jencinas.kotlinbootcamp

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findViewById<View>(R.id.mainGoButton).setOnClickListener {
            val intent = Intent(this, GreetingActivity::class.java)
            val usernameTextView: TextView = findViewById<View>(R.id.mainName) as TextView
            val username = usernameTextView.text.toString()
            intent.putExtra("EXTRA_USERNAME", username)
            startActivity(intent)
        }
    }
}