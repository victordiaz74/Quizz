package com.example.quizz.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.quizz.Pregunta


@Dao
interface PreguntaDao {

    @Insert
    fun añadirPregunta(pregunta: Pregunta)

    @Query("SELECT * FROM pregunta_tabla ORDER BY idPregunta ASC")
    fun leerTodo(): LiveData<List<Pregunta>>
}