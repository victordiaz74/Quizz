package com.example.quizz.data

import androidx.lifecycle.*
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

class PreguntaViewModel(private val repositorioPreguntas: PreguntaRepositorio): ViewModel() {

    val todasLasPreguntas: Flow<List<Pregunta>> = repositorioPreguntas.todasLasPreguntas

    fun insertarPregunta(pregunta: Pregunta) = viewModelScope.launch {
        repositorioPreguntas.addPregunta(pregunta)
    }

}

class PreguntaViewModelFactory(private val repositorioPreguntas: PreguntaRepositorio) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(PreguntaViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return PreguntaViewModel(repositorioPreguntas) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}