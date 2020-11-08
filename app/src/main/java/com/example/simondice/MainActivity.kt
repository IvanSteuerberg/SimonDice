package com.example.simondice

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import java.util.*
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var game = ArrayList<Int>()
        var player = ArrayList<Int>()
        val start = findViewById<Button>(R.id.start_button)


        start.setOnClickListener {
            prueba()

        }


    }

    private fun prueba() {
        val randomInt = Random().nextInt(4) + 1
        when (randomInt) {
            1 -> R.id.green_button
            else ->R.id.yellow_button
        }
    }





}