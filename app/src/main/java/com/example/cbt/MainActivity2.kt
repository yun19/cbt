package com.example.cbt

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast
import androidx.core.view.isVisible
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.activity_main2.*



class MainActivity2 : AppCompatActivity() {
    private val TAG = "Firestore"
    var database: FirebaseFirestore? = null
    var count = 0
    var a = ""
    var resultText = ""

    private lateinit var array: ArrayList<*>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        //activity_main2 레이아웃에서 visibility gone 설정함으로 필요 없어짐
        //answer!!.visibility = View.GONE
        //expp!!.visibility = View.GONE
        array = intent.getStringArrayListExtra("list") as ArrayList<*>
        database = FirebaseFirestore.getInstance()
        get_problem()

        btn3.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }

        back_btn.setOnClickListener {
            //count가 0이상일때 실행
            if(count > 0) {
                if (count < array.size - 1) {
                    answer!!.visibility = View.GONE
                    expp!!.visibility = View.GONE
                    get_problem()
                    count--
                    rgo.clearCheck()
                }
            }else {
                Toast.makeText(this, "첫번째 문제", Toast.LENGTH_SHORT).show()
            }
        }
        next_btn.setOnClickListener {
            if (count < array.size - 1) {
                get_problem()
                count++
                answer!!.visibility = View.GONE
                expp!!.visibility = View.GONE
                resultText=""
                //라디오그룹 전체 체크를 해제함
                rgo.clearCheck()
            } else
                Toast.makeText(this, "마지막 문제", Toast.LENGTH_SHORT).show()
        }
        Q_btn.setOnClickListener {
            val intent = Intent(this, Question::class.java)
            startActivity(intent)
        }


        post.setOnClickListener {
            Checked()
            //선택 안됐을 경우를 체크
            if(resultText != "") {
                expp!!.visibility = View.VISIBLE
                answer!!.visibility = View.VISIBLE
                if (a == resultText) {
                    Toast.makeText(this, "정답", Toast.LENGTH_SHORT).show()
                } else
                    Toast.makeText(this, "오답", Toast.LENGTH_SHORT).show()

            }else
                Toast.makeText(this, "답을 선택 해주세요", Toast.LENGTH_SHORT).show()
        }
        //라디오 버튼 선택이 바뀔때 실행됨(추천), 사용시 Checked()호출 및 함수 삭제
        /*rgo.setOnCheckedChangeListener { group, checkedId ->
            when(checkedId) {
                R.id.ex1 -> resultText = "1"
                R.id.ex2 -> resultText = "2"
                R.id.ex3 -> resultText = "3"
                R.id.ex4 -> resultText = "4"
            }
        }*/
    }
    //함수를 호출해야 실행됨
    private fun Checked() {
        val ex1: RadioButton = findViewById<RadioButton>(R.id.ex1)
        val ex2: RadioButton = findViewById<RadioButton>(R.id.ex2)
        val ex3: RadioButton = findViewById<RadioButton>(R.id.ex3)
        val ex4: RadioButton = findViewById<RadioButton>(R.id.ex4)
        when {
            ex1.isChecked -> {
                resultText = "1"
            }
            ex2.isChecked -> {
                resultText = "2"
            }
            ex3.isChecked -> {
                resultText = "3"
            }
            ex4.isChecked -> {
                resultText = "4"
            }
        }
    }

    private fun get_problem() {
        database!!.collection("problem")
            .get()
            .addOnSuccessListener { result ->
                for (document in result!!) {
                    if (document.id == array[count]) {
                        problemtitle.text = document.data["title"].toString()
                        ex1.text = document.data["ex1"].toString()
                        ex2.text = document.data["ex2"].toString()
                        ex3.text = document.data["ex3"].toString()
                        ex4.text = document.data["ex4"].toString()
                        ranswer.text = document.data["ranswer"].toString()
                        exp.text = document.data["exp"].toString()
                        a = document.data["ranswer"].toString()
                    }
                }
            }
    }
}
