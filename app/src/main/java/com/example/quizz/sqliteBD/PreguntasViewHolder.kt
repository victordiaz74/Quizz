package com.example.quizz.sqliteBD

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.quizz.R

class PreguntasViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    val txtPreguntaId = view.findViewById<TextView>(R.id.textoPreguntaId)
    val txtPregunta = view.findViewById<TextView>(R.id.txtPregunta)
    val txtRespuesta1 = view.findViewById<TextView>(R.id.txtRespuesta1)
    val txtRespuesta2 = view.findViewById<TextView>(R.id.txtRespuesta2)
    val txtRespuesta3 = view.findViewById<TextView>(R.id.txtRespuesta3)
    val txtRespuesta4 = view.findViewById<TextView>(R.id.txtRespuesta4)


    fun render(textoPreguntaId: Int, textoPregunta: String, textoRespuesta1: String, textoRespuesta2: String, textoRespuesta3: String, textoRespuesta4: String ) {
        txtPreguntaId.text = textoPreguntaId.toString()
        txtPregunta.text = textoPregunta
        txtRespuesta1.text = textoRespuesta1
        txtRespuesta2.text = textoRespuesta2
        txtRespuesta3.text = textoRespuesta3
        txtRespuesta4.text = textoRespuesta4
    }
}