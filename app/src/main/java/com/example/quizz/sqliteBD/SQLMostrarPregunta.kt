package com.example.quizz.sqliteBD

import android.content.Intent
import android.database.Cursor

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import com.example.quizz.MainActivity
import com.example.quizz.R

class SQLMostrarPregunta : AppCompatActivity() {

    private lateinit var idPregunta: String
    private lateinit var preguntasDBHelper: MiBDOpenHelper

    private lateinit var textoPreguntaId: TextView
    private lateinit var textoPregunta: TextView
    private lateinit var textoRespuesta1: TextView
    private lateinit var textoRespuesta2: TextView
    private lateinit var textoRespuesta3: TextView
    private lateinit var textoRespuesta4: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mostrar_pregunta)

        preguntasDBHelper = MiBDOpenHelper(this, null)
        idPregunta = intent.getStringExtra(EXTRA_MESSAGE).toString()

        textoPreguntaId = findViewById<TextView>(R.id.textoPreguntaId)
        textoPregunta = findViewById<TextView>(R.id.textoPreguntaCompleto)
        textoRespuesta1 = findViewById<TextView>(R.id.textoRespuesta1Completo)
        textoRespuesta2 = findViewById<TextView>(R.id.textoRespuesta2Completo)
        textoRespuesta3 = findViewById<TextView>(R.id.textoRespuesta3Completo)
        textoRespuesta4 = findViewById<TextView>(R.id.textoRespuesta4Completo)

        Log.e("$idPregunta", "idPregunta = $idPregunta")
        consultarPregunta(idPregunta)

    }

    fun consultarPregunta(idPreguntaGlobal:String){
        val cursor = preguntasDBHelper.obtenerPreguntaId(idPreguntaGlobal)

        /*
        while (cursor.moveToNext()) {
            if (cursor.getInt(0).toString() == idPregunta )
                break
        }*/

        if(cursor.count >= 1){
            while (cursor.moveToNext()){
                textoPreguntaId.text = cursor.getInt(0).toString()
                textoPregunta.text = cursor.getString(1)
                textoRespuesta1.text = cursor.getString(2)
                textoRespuesta2.text = cursor.getString(3)
                textoRespuesta3.text = cursor.getString(4)
                textoRespuesta4.text = cursor.getString(5)
            }
        }

        cursor.close()
    }

    fun btnVolver2(view: View){
        intent = Intent(this, MainActivity::class.java).apply{

        }
        startActivity(intent)
    }

}