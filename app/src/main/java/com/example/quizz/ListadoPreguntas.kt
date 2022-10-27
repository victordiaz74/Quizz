package com.example.quizz

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.quizz.adapter.PreguntaAdapter

class ListadoPreguntas : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_listado)
        initRecyclerView()
    }

    fun initRecyclerView() {
        val rv = findViewById<RecyclerView>(R.id.listado)
        rv.layoutManager = LinearLayoutManager(this)
        val listadoPreguntas = PreguntaDatabase
        listadoPreguntas.setContext(this)
        rv.adapter = PreguntaAdapter(listadoPreguntas.filllist())
    }


}