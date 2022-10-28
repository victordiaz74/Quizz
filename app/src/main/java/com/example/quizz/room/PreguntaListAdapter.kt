package com.example.quizz.room

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.quizz.R
import com.example.quizz.data.Pregunta

class PreguntaListAdapter: ListAdapter<Pregunta, PreguntaListAdapter.PreguntaViewHolder>(WORDS_COMPARATOR) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PreguntaViewHolder {
        return PreguntaViewHolder.create(parent)
    }

    override fun onBindViewHolder(holder: PreguntaViewHolder, position: Int) {
        val pregunta = getItem(position)
        holder.render(pregunta)
    }

    class PreguntaViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val txtPregunta: TextView = itemView.findViewById(R.id.txtPregunta)
        val txtRespuesta1: TextView = itemView.findViewById(R.id.txtRespuesta1)
        val txtRespuesta2: TextView = itemView.findViewById(R.id.txtRespuesta2)
        val txtRespuesta3: TextView = itemView.findViewById(R.id.txtRespuesta3)
        val txtRespuesta4: TextView = itemView.findViewById(R.id.txtRespuesta4)



        fun render(pregunta: Pregunta) {
            txtPregunta.text = pregunta.textoPregunta
            txtRespuesta1.text = pregunta.textoRespuesta1
            txtRespuesta2.text = pregunta.textoRespuesta2
            txtRespuesta3.text = pregunta.textoRespuesta3
            txtRespuesta4.text = pregunta.textoRespuesta4
        }

        companion object {
            fun create(parent: ViewGroup): PreguntaViewHolder {
                val view: View = LayoutInflater.from(parent.context)
                    .inflate(R.layout.activity_listado, parent, false)
                return PreguntaViewHolder(view)
            }
        }
    }
    companion object {
        private val WORDS_COMPARATOR = object : DiffUtil.ItemCallback<Pregunta>() {
            override fun areItemsTheSame(oldItem: Pregunta, newItem: Pregunta): Boolean {
                return oldItem === newItem
            }

            override fun areContentsTheSame(oldItem: Pregunta, newItem: Pregunta): Boolean {
                return oldItem.idPregunta == newItem.idPregunta
            }
        }
    }
}