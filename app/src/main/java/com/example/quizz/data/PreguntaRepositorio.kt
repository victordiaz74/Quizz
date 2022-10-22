package com.example.quizz.data

import androidx.lifecycle.LiveData
import com.example.quizz.Pregunta

class PreguntaRepositorio (private val preguntaDao: PreguntaDao){

    val leerTodo: LiveData<List<Pregunta>> = preguntaDao.leerTodo()


    suspend fun añadirPregunta(pregunta: Pregunta){
        preguntaDao.añadirPregunta(pregunta)
    }

}