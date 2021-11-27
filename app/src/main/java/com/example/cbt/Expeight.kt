package com.example.cbt

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_expeight.*
import kotlinx.android.synthetic.main.activity_main2.*
import kotlinx.android.synthetic.main.activity_main2.Q_btn
import kotlinx.android.synthetic.main.activity_main2.btn3

class Expeight : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_expeight)

        btn3.setOnClickListener{
            val intent= Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        Q_btn.setOnClickListener{
            val intent= Intent(this, Question::class.java)
            startActivity(intent)
        }
    }
}