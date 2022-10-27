package com.example.quizz.room

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.quizz.PreguntaListAdapter
import com.example.quizz.R
import com.example.quizz.data.PreguntaViewModel
import com.example.quizz.data.PreguntaViewModelFactory
import kotlinx.coroutines.flow.observeOn

class ListadoPreguntas : AppCompatActivity() {

    private val newPreguntaActivityRequestCode = 1
    private val preguntaViewModel: PreguntaViewModel by viewModels{
        PreguntaViewModelFactory((application as PreguntaApplication).repository)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_listado)

        initRecyclerView()
/*
        preguntaViewModel.todasLasPreguntas.observeOn(owner = this){
            preguntas ->
            pregunta.let{
                adapter.submitList(it)
            }
        }*/
    }

    fun initRecyclerView() {
        val rv = findViewById<RecyclerView>(R.id.listado)
        val adapter = PreguntaListAdapter()
        rv.adapter = adapter
        rv.layoutManager = LinearLayoutManager(this)

    }


}