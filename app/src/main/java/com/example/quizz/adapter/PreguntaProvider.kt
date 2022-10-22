package com.example.quizz.adapter

import android.content.Context
import com.example.quizz.Pregunta
import java.io.BufferedReader
import java.io.File
import java.io.FileReader

class PreguntaProvider {

    private lateinit var context: Context

    fun setContext(contexto:Context)
    {
        context=contexto
    }

    fun fillList(): ArrayList<Pregunta>
    {
        val listadoPreguntas: ArrayList<Pregunta> = ArrayList<Pregunta>()
        val ficheroCsv = File("/data/data/com.example.concurso/files/")

        val bufferedReader = BufferedReader(FileReader(ficheroCsv))
        val csvParser = CSVParser(bufferedReader, CSVFormat.DEFAULT);
        for (csvRecord in csvParser)
        {
            val nombre = csvRecord[0]
            val puntuacion = csvRecord[1]
            val casa = csvRecord[2]
            listadoPreguntas.add(Pregunta(idPregunta, pregunta, respuestas))
        }

        return listadoPreguntas
    }

}