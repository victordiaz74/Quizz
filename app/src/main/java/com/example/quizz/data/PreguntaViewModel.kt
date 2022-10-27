package com.example.quizz.data

import androidx.lifecycle.*
import kotlinx.coroutines.launch

class PreguntaViewModel(private val repositorioPreguntas: PreguntaRepositorio): ViewModel() {

    val todasLasPreguntas: LiveData<List<Pregunta>> = repositorioPreguntas.todasLasPreguntas.asLiveData()

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