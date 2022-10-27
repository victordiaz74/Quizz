package com.example.quizz.room

import android.app.Application
import com.example.quizz.data.PreguntaRepositorio
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob

class PreguntaApplication: Application() {

    val applicationScope = CoroutineScope(SupervisorJob())

    val database by lazy {
        PreguntaDatabase.getDatabase(this, applicationScope)
    }
    val repository by lazy{
        PreguntaRepositorio(database.preguntaDao())
    }

}