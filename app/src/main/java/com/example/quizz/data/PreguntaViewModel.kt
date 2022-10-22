package com.example.quizz.data

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.quizz.Pregunta
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class PreguntaViewModel(application: Application): AndroidViewModel(application) {

    private val leerTodo: LiveData<List<Pregunta>>
    private val repositorio: PreguntaRepositorio

    init {
        val preguntaDao = PreguntaDatabase.getDatabase(application).preguntaDao()
        repositorio = PreguntaRepositorio(preguntaDao)
        leerTodo = repositorio.leerTodo

    }


    fun añadirPregunta(pregunta: Pregunta){

        viewModelScope.launch(Dispatchers.IO){
            repositorio.añadirPregunta(pregunta)
        }

    }
}