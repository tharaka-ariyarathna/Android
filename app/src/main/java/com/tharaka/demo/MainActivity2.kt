package com.tharaka.demo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import org.w3c.dom.Text

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_secondmainactivity)

        val buttonSecondActivity = findViewById<Button>(R.id.button_second_activity)
        val textSecondActivity = findViewById<TextView>(R.id.textview_second_activity)
        buttonSecondActivity.setOnClickListener(){
            textSecondActivity.text = "Beautiful"
        }
    }
}