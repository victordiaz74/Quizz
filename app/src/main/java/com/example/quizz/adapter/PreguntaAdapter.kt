package com.example.quizz.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.quizz.R

class PreguntaAdapter: RecyclerView.Adapter<PreguntaViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PreguntaViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return PreguntaViewHolder(layoutInflater.inflate(R.layout.itemuser, parent, false))
    }

    override fun onBindViewHolder(holder: PreguntaViewHolder, position: Int) {
        val item = usuarios[position]
        holder.render(item)
    }

    override fun getItemCount(): Int {
        return usuarios.size
    }

}


