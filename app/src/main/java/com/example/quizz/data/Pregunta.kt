package com.example.quizz.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "pregunta_tabla")
data class Pregunta(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "idPregunta") val idPregunta: Int=0,
    @ColumnInfo(name = "textoPregunta") val textoPregunta: String,
    @ColumnInfo(name = "textoRespuestas") val textoRespuestas: Array<String>
)