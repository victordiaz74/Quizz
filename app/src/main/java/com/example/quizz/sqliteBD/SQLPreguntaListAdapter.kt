package com.example.quizz

import android.content.Context
import android.database.Cursor
import android.view.LayoutInflater
import android.view.View.OnClickListener
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.quizz.sqliteBD.PreguntasViewHolder

class SQLPreguntaListAdapter(private var onClickListener: (String) -> Unit) : RecyclerView.Adapter<PreguntasViewHolder>() {

    private lateinit var context: Context
    private lateinit var cursor: Cursor


    fun SQLPreguntaListAdapter(context: Context, cursor: Cursor) {
        this.context = context
        this.cursor = cursor
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PreguntasViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return PreguntasViewHolder(layoutInflater.inflate(R.layout.item_pregunta, parent,false))
    }

    override fun onBindViewHolder(holder: PreguntasViewHolder, position: Int) {
        cursor.moveToPosition(position)
        holder.render(cursor.getInt(0), cursor.getString(1), onClickListener)

    }

    override fun getItemCount(): Int {
        return cursor.count

    }

}