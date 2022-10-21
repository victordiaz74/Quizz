package com.example.quizz.adapter

import androidx.recyclerview.widget.RecyclerView

class PreguntaAdapter: RecyclerView.Adapter<PreguntaViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): JugadorViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return JugadorViewHolder(layoutInflater.inflate(R.layout.itemuser, parent, false))
    }

    override fun onBindViewHolder(holder: JugadorViewHolder, position: Int) {
        val item = usuarios[position]
        holder.render(item)
    }

    override fun getItemCount(): Int {
        return usuarios.size
    }

}


