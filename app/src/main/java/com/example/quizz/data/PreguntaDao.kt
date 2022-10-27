package com.example.quizz.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow


@Dao
interface PreguntaDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addPregunta(pregunta: Pregunta)

    @Query("SELECT * FROM pregunta_tabla ORDER BY idPregunta ASC")
    fun obtenerTodasLasPreguntas(): Flow<List<Pregunta>>

    @Query("DELETE FROM pregunta_tabla")
    suspend fun borrarTodasLasPreguntas()

    @Query("DELETE FROM pregunta_tabla WHERE idPregunta = :idPregunta")
    suspend fun borrarPreguntaPorId(idPregunta: Int)
}