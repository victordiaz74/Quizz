package com.example.quizz.sqliteBD

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "pregunta_tabla")
data class Pregunta(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "idPregunta") val idPregunta: Int=0,
    @ColumnInfo(name = "textoPregunta") val textoPregunta: String,
    @ColumnInfo(name = "textoRespuesta1") val textoRespuesta1: String,
    @ColumnInfo(name = "textoRespuesta2") val textoRespuesta2: String,
    @ColumnInfo(name = "textoRespuesta3") val textoRespuesta3: String,
    @ColumnInfo(name = "textoRespuesta4") val textoRespuesta4: String
)