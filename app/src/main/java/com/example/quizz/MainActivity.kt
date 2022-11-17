package com.example.quizz

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.quizz.fragmentos.Fragmento
import com.example.quizz.sqliteBD.SQLAddNewPregunta
import com.example.quizz.sqliteBD.SQLListadoPreguntas

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun btnStart(view: View){
        intent = Intent(this, Fragmento::class.java)
        startActivity(intent)
    }

    fun btnPreguntas(view: View){
        intent = Intent(this, SQLListadoPreguntas::class.java)
        startActivity(intent)
    }

    fun btnAdd(view: View){
        intent = Intent(this, SQLAddNewPregunta::class.java)
        startActivity(intent)
    }

    fun btnInfo(view: View){
        intent = Intent(this, InfoApp::class.java)
        startActivity(intent)
    }


    @Override
    override fun onNewIntent(intent: Intent){
        super.onNewIntent(intent)
        setIntent(intent)
    }
}