package com.example.quizz.sqliteBD

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.quizz.MainActivity
import com.example.quizz.PreguntaListAdapter
import com.example.quizz.R

class SQLListadoPreguntas: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_listado)

        initRecyclerView()
    }

    fun initRecyclerView() {
        val rv = findViewById<RecyclerView>(R.id.listado)
        val adapter = PreguntaListAdapter()
        rv.adapter = adapter
        rv.layoutManager = LinearLayoutManager(this)

    }

    fun btnVolver1(view: View){
        intent = Intent(this, MainActivity::class.java,).apply{

        }
        startActivity(intent)
    }
}