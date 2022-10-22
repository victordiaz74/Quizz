package com.example.quizz

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "pregunta_tabla")
data class Pregunta(
    @PrimaryKey(autoGenerate = true)
    val idPregunta: Int,
    val pregunta: String,
    val respuestas: Array<String>
)
