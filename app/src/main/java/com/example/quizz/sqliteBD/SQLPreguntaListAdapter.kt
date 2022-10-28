package com.example.quizz

import android.content.Context
import android.database.Cursor
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.quizz.data.Pregunta

class PreguntaListAdapter: RecyclerView.Adapter<PreguntaListAdapter.PreguntaViewHolder>() {

    private lateinit var context: Context
    private var cursor: Cursor? = null

    fun SQLiteRecyclerViewAapter(context: Context, cursor: Cursor) {
        this.context = context
        this.cursor = cursor
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PreguntaViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return PreguntaViewHolder(layoutInflater.inflate(R.layout.item_pregunta, parent,false))
    }

    override fun onBindViewHolder(holder: PreguntaViewHolder, position: Int) {
        cursor?.moveToPosition(position)
        val pregunta1: Pregunta = Pregunta(cursor?.getInt(0)!!,
            cursor?.getString(1)!!,
            cursor?.getString(2)!!, cursor?.getString(3)!!, cursor?.getString(4)!!, cursor?.getString(5)!!
        )
        holder.render(pregunta1)
    }

    override fun getItemCount(): Int {
        return cursor?.count!!
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
    }


}