package com.example.quizz

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.quizz.room.ListadoPreguntas

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun btnPreguntas(view: View){
        intent = Intent(this, ListadoPreguntas::class.java,).apply{

        }
        startActivity(intent)
    }

    fun btnAdd(view: View){
        intent = Intent(this, AddNewPregunta::class.java,).apply{

        }
        startActivity(intent)
    }
}