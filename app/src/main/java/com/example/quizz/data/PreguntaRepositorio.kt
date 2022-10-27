package com.example.quizz.data

import androidx.annotation.WorkerThread
import androidx.lifecycle.LiveData
import kotlinx.coroutines.flow.Flow

class PreguntaRepositorio (private val preguntaDao: PreguntaDao){

    val todasLasPreguntas: LiveData<List<Pregunta>> = preguntaDao.obtenerTodasLasPreguntas()

    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun addPregunta(pregunta: Pregunta){
        preguntaDao.addPregunta(pregunta)
    }

}