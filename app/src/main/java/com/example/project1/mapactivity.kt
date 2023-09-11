package com.example.project1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class mapactivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mapactivity)

        val selectedCity = intent.getStringExtra("selectedCity")
        val selectedState = intent.getStringExtra("selectedState")



    }
}