package com.github.jencinas.kotlinbootcamp

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class GreetingActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_greeting)
        val username: String = intent.getStringExtra("EXTRA_USERNAME") ?: ""
        val textView = findViewById<View>(R.id.greetingMessage) as TextView
        val greeting = "Hello $username"
        textView.text = greeting
    }
}