package com.example.quizz.adapter

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.quizz.Pregunta
import com.example.quizz.R

class PreguntaViewHolder(view: View):RecyclerView.ViewHolder(view) {

    val idPregunta = view.findViewById<TextView>(R.id.idPregunta)
    val preguntas = view.findViewById<TextView>(R.id.pregunta)
    val respuestas = view.findViewById<TextView>(R.id.respuestas)

    fun render(pregunta: Pregunta){
        idPregunta.text = pregunta.idPregunta
        preguntas.text = pregunta.preguntas
        respuestas.text = pregunta.respuestas

    }
}