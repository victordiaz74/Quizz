package com.example.quizz.sqliteBD

import android.content.Intent
import android.database.sqlite.SQLiteDatabase
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.quizz.MainActivity
import com.example.quizz.R
import com.example.quizz.SQLPreguntaListAdapter

class SQLMostrarPregunta : AppCompatActivity() {

    private var idPregunta = ""
    private lateinit var preguntasDBHelper: MiBDOpenHelper
    val txtPreguntaId = findViewById<TextView>(R.id.textoPreguntaId)
    val txtPregunta = findViewById<TextView>(R.id.textoPreguntaCompleto)
    val txtRespuesta1 = findViewById<TextView>(R.id.textoRespuesta1Completo)
    val txtRespuesta2 = findViewById<TextView>(R.id.textoRespuesta2Completo)
    val txtRespuesta3 = findViewById<TextView>(R.id.textoRespuesta3Completo)
    val txtRespuesta4 = findViewById<TextView>(R.id.textoRespuesta4Completo)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mostrar_pregunta)

        idPregunta = intent.getStringExtra("idPregunta").toString()


        consultarPregunta()

    }

    fun consultarPregunta(){
        val cursor = preguntasDBHelper.obtenerPreguntaId(idPregunta)

        txtPreguntaId.text = cursor.getInt(0).toString()
        txtPregunta.text = cursor.getString(1)
        txtRespuesta1.text = cursor.getString(2)
        txtRespuesta2.text = cursor.getString(3)
        txtRespuesta3.text = cursor.getString(4)
        txtRespuesta4.text = cursor.getString(5)
    }

    fun btnVolver2(view: View){
        intent = Intent(this, MainActivity::class.java).apply{

        }
        startActivity(intent)
    }

}