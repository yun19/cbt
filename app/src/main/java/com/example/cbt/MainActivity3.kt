package com.example.cbt

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main2.*
import kotlinx.android.synthetic.main.activity_main3.*

class MainActivity3 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)

        btn2.setOnClickListener{
            val intent= Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        back_btn1.setOnClickListener {
            val intent=Intent( this, MainActivity2::class.java)
            startActivity(intent)
        }

        Q_btn1.setOnClickListener {
            val intent=Intent( this, Question::class.java)
            startActivity(intent)
        }

    }
}