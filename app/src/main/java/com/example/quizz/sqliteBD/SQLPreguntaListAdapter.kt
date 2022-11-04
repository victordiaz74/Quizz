package com.example.quizz

import android.content.Context
import android.database.Cursor
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.quizz.sqliteBD.PreguntasViewHolder

class SQLPreguntaListAdapter: RecyclerView.Adapter<PreguntasViewHolder>() {

    private lateinit var context: Context
    private lateinit var cursor: Cursor
    private lateinit var onItemClickListener: (String) -> Unit
    private lateinit var onClickDelete: Unit

    fun SQLPreguntaListAdapter(context: Context, cursor: Cursor, onItemClickListener: (String) -> Unit) {
        this.context = context
        this.cursor = cursor
        this.onItemClickListener = onItemClickListener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PreguntasViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return PreguntasViewHolder(layoutInflater.inflate(R.layout.item_pregunta, parent,false))
    }

    override fun onBindViewHolder(holder: PreguntasViewHolder, position: Int) {
        cursor.moveToPosition(position)
        holder.render(cursor.getInt(0), cursor.getString(1), onItemClickListener)

    }

    override fun getItemCount(): Int {
        return cursor.count

    }

}