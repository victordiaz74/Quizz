package com.example.quizz.sqliteBD

import android.view.View
import android.view.View.OnClickListener
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.quizz.R

class PreguntasViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    val txtPreguntaId = itemView.findViewById<TextView>(R.id.txtPreguntaId)
    val txtPregunta = itemView.findViewById<TextView>(R.id.txtPregunta)

    fun render(textoPreguntaId: Int, textoPregunta: String, onClickListener: (String) -> Unit) {

        txtPreguntaId.text = textoPreguntaId.toString()
        txtPregunta.text = textoPregunta
        txtPregunta.setOnClickListener{
            onClickListener(textoPreguntaId.toString())
        }
    }


}

