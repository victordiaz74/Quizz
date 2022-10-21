package com.example.quizz.adapter

data class Pregunta(idPregunta: Int, pregunta: String, respuestas:Array<String>){
    val idPregunta: Int
    val pregunta: String
    val respuestas: Array<String>

    init {
        this.idPregunta = idPregunta
        this.pregunta = pregunta
        this.respuestas = respuestas
    }
}