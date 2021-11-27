package com.example.cbt

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.NumberPicker
import kotlinx.android.synthetic.main.activity_qask.*

class Qask : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_qask)

        day.wrapSelectorWheel=false
        month.wrapSelectorWheel=false
        num.wrapSelectorWheel=false
        num.isInEditMode

        //최소값
        day.minValue =2020
        month.minValue = 1
        num.minValue=1

        //최대값
        day.maxValue =2021
        month.maxValue=3
        num.maxValue=100


    }
}