package com.example.quizz.sqliteBD

import android.view.View
import android.widget.EditText
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.quizz.R

class PreguntasViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    //val txtPreguntaId = view.findViewById<EditText>(R.id.textoPreguntaId)
    val txtPregunta = view.findViewById<EditText>(R.id.textoPregunta)
    val txtRespuesta1 = view.findViewById<EditText>(R.id.textoRespuesta1)
    val txtRespuesta2 = view.findViewById<EditText>(R.id.textoRespuesta2)
    val txtRespuesta3 = view.findViewById<EditText>(R.id.textoRespuesta3)
    val txtRespuesta4 = view.findViewById<EditText>(R.id.textoRespuesta4)


    fun render(textoPreguntaId: Int, textoPregunta: String, textoRespuesta1: String, textoRespuesta2: String, textoRespuesta3: String, textoRespuesta4: String ) {
        //txtPreguntaId.setText(textoPreguntaId.toString())
        txtPregunta.setText(textoPregunta)
        txtRespuesta1.setText(textoRespuesta1)
        txtRespuesta2.setText(textoRespuesta2)
        txtRespuesta3.setText(textoRespuesta3)
        txtRespuesta4.setText(textoRespuesta4)

    }
}