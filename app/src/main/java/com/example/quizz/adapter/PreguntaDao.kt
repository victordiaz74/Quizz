package com.example.quizz.adapter

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query


@Dao
interface PreguntaDao {

    @Insert
    fun añadirPregunta(pregunta: Pregunta)

    @Query("SELECT * FROM pregunta_tabla ORDER BY idPregunta ASC")
    fun leerTodo(): LiveData<List<Pregunta>>
}