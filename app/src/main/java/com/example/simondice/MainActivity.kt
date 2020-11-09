package com.example.simondice

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import java.util.*
import kotlin.collections.ArrayList
import kotlin.random.Random

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var game = ArrayList<Int>()
        var player = ArrayList<Int>()
        var finished  = false
        val start = findViewById<Button>(R.id.start_button)
        val check = findViewById<Button>(R.id.check_button)
        val blue = findViewById<Button>(R.id.blue_button)
        val red = findViewById<Button>(R.id.red_button)
        val yellow = findViewById<Button>(R.id.yellow_button)
        val green = findViewById<Button>(R.id.green_button)
        val toast = Toast.makeText(applicationContext,"Juego terminado", Toast.LENGTH_SHORT)
        val toast2 = Toast.makeText(applicationContext,"Inicio", Toast.LENGTH_SHORT)


        start.setOnClickListener{
            finished = false
            reset(game,player)
            addToSecu(game)
            toast2.show()
            showSec(game)
        }

        check.setOnClickListener{
            if(finished==false){
                if(checkSec(game,player)){
                    addToSecu(game)
                    player.clear()
                    showSec(game)
                }else{
                    finished=true
                    toast.show()
                }
            }
        }
        red.setOnClickListener{
            addUserSec(player,1)
        }
        green.setOnClickListener{
            addUserSec(player,2)
        }
        yellow.setOnClickListener{
            addUserSec(player,3)
        }
        blue.setOnClickListener{
            addUserSec(player,4)
        }
        //showSec(sec)

    }

    fun addToSecu(sec : MutableList<Int>)  {
        val numb= Random.nextInt(4) + 1
        sec.add(numb)
    }

    fun checkSec(sec : MutableList<Int>, secUsr : MutableList<Int>) : Boolean {
        return sec == secUsr
    }

    fun reset(sec: MutableList<Int>, secUsr: MutableList<Int>){
        sec.clear()
        secUsr.clear()
    }

    fun addUserSec(secUsr: MutableList<Int>, color: Int){
        when(color){
            1 -> secUsr.add(1)
            2 -> secUsr.add(2)
            3 -> secUsr.add(3)
            else -> secUsr.add(4)
        }
    }

    fun showSec(sec: MutableList<Int>){
        var t = Toast.makeText(applicationContext,"Inicio", Toast.LENGTH_SHORT)
        for (color in sec){
            when(color){
                1 -> Toast.makeText(applicationContext,"Rojo", Toast.LENGTH_SHORT).show()
                2 -> Toast.makeText(applicationContext,"Verde", Toast.LENGTH_SHORT).show()
                3 -> Toast.makeText(applicationContext,"Amarillo", Toast.LENGTH_SHORT).show()
                4 -> Toast.makeText(applicationContext,"Azul", Toast.LENGTH_SHORT).show()
            }
        }
    }





}