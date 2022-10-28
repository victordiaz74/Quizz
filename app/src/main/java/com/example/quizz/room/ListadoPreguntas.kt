package com.example.quizz.room

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.quizz.MainActivity
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

//        initRecyclerView()
/*
        preguntaViewModel.todasLasPreguntas.observeOn(owner = this){
            preguntas ->
            pregunta.let{
                adapter.submitList(it)
            }
        }*/
    }
/*
    override fun onActivityResult(requestCode: Int, resultCode: Int, intentData: Intent?) {
        super.onActivityResult(requestCode, resultCode, intentData)

        if (requestCode == newPreguntaActivityRequestCode && resultCode == Activity.RESULT_OK) {
            intentData?.getStringExtra(AddNewPregunta.EXTRA_REPLY)?.let {
                    reply ->
                val pregunta = Pregunta(replyIntent)
                preguntaViewModel.insertarPregunta(pregunta)
            }
        } else {
            Toast.makeText(
                applicationContext,
                R.string.empty_not_saved,
                Toast.LENGTH_LONG
            ).show()
        }
    }*/
//
//    fun initRecyclerView() {
//        val rv = findViewById<RecyclerView>(R.id.listado)
//        val adapter = PreguntaListAdapter()
//        rv.adapter = adapter
//        rv.layoutManager = LinearLayoutManager(this)
//
//    }

    fun btnVolver1(view: View){
        intent = Intent(this, MainActivity::class.java,).apply{

        }
        startActivity(intent)
    }


}