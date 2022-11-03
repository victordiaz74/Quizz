package com.example.quizz.sqliteBD

import android.view.View
import android.widget.EditText
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.quizz.R

class PreguntasViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val txtPreguntaId = itemView.findViewById<TextView>(R.id.txtPreguntaId)
    val txtPregunta = itemView.findViewById<TextView>(R.id.txtPregunta)
    val txtRespuesta1 = itemView.findViewById<TextView>(R.id.txtRespuesta1)
    val txtRespuesta2 = itemView.findViewById<TextView>(R.id.txtRespuesta2)
    val txtRespuesta3 = itemView.findViewById<TextView>(R.id.txtRespuesta3)
    val txtRespuesta4 = itemView.findViewById<TextView>(R.id.txtRespuesta4)


    fun render(textoPreguntaId: Int, textoPregunta: String, textoRespuesta1: String, textoRespuesta2: String, textoRespuesta3: String, textoRespuesta4: String ) {
        txtPreguntaId.setText(textoPreguntaId.toString())
        txtPregunta.setText(textoPregunta)
        txtRespuesta1.setText(textoRespuesta1)
        txtRespuesta2.setText(textoRespuesta2)
        txtRespuesta3.setText(textoRespuesta3)
        txtRespuesta4.setText(textoRespuesta4)

    }
}