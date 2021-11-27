package com.example.cbt

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val array = arrayListOf("20-6-1","20-6-2","20-6-2","20-6-3","20-6-4","20-6-5","20-6-6","20-6-7","20-6-8","20-6-9")

        exp20_6.setOnClickListener{
            val intent= Intent(this, MainActivity2::class.java)
            intent.putExtra("list", array)
            startActivity(intent)
        }

        exp20_8.setOnClickListener{
            val intent= Intent(this, Expeight::class.java)
            startActivity(intent)
        }

        exp20_9.setOnClickListener{
            val intent= Intent(this, ExpNine::class.java)
            startActivity(intent)
        }


        exp21_5.setOnClickListener{
            val intent= Intent(this, Expfive::class.java)
            startActivity(intent)
        }




    }
}