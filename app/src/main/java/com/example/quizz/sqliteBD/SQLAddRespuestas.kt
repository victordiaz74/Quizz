package com.example.quizz.sqliteBD

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.example.quizz.MainActivity
import com.example.quizz.R
import com.example.quizz.SQLPreguntaListAdapter
import com.example.quizz.sqliteBD.MiBDOpenHelper

class SQLAddRespuestas : AppCompatActivity() {


    lateinit var textoPregunta: String
    lateinit var editarTxtPregunta: TextView
    lateinit var editarTxtRespuesta1: EditText
    lateinit var editarTxtRespuesta2: EditText
    lateinit var editarTxtRespuesta3: EditText
    lateinit var editarTxtRespuesta4: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sqladd_respuestas)

        editarTxtPregunta = findViewById<TextView>(R.id.textoPregunta)
        editarTxtRespuesta1 = findViewById<EditText>(R.id.textoRespuesta1)
        editarTxtRespuesta2 = findViewById<EditText>(R.id.textoRespuesta2)
        editarTxtRespuesta3 = findViewById<EditText>(R.id.textoRespuesta3)
        editarTxtRespuesta4 = findViewById<EditText>(R.id.textoRespuesta4)

        textoPregunta = intent.getStringExtra("pregunta").toString()

        editarTxtPregunta.text = textoPregunta

        val button = findViewById<Button>(R.id.btnAdd)

        button.setOnClickListener {
            enviarPregunta()
        }


    }

    fun enviarPregunta(){
        if (TextUtils.isEmpty(editarTxtRespuesta1.text) || TextUtils.isEmpty(editarTxtRespuesta2.text)
            || TextUtils.isEmpty(editarTxtRespuesta3.text) || TextUtils.isEmpty(editarTxtRespuesta4.text)
        ) {
            Toast.makeText(this, "Rellena los campos", Toast.LENGTH_SHORT).show()
        } else {
            val pregunta = textoPregunta
            val respuesta1 = editarTxtRespuesta1.text.toString()
            val respuesta2 = editarTxtRespuesta2.text.toString()
            val respuesta3 = editarTxtRespuesta3.text.toString()
            val respuesta4 = editarTxtRespuesta4.text.toString()

            var preguntasDBHelper = MiBDOpenHelper(this, null)
            preguntasDBHelper.crearPregunta(
                pregunta,
                respuesta1,
                respuesta2,
                respuesta3,
                respuesta4
            )

            /*val cursor = preguntasDBHelper.obtenerPreguntas()

            miSQLiteRecyclerViewAdapter.SQLPreguntaListAdapter(this, cursor)

            miSQLiteRecyclerViewAdapter.notifyDataSetChanged()*/
            intent = Intent(this, SQLListadoPreguntas::class.java,).apply {

            }
            startActivity(intent)
        }
        finish()
    }





    fun btnVolver(view: View){
        intent = Intent(this, MainActivity::class.java,).apply{

        }
        startActivity(intent)
    }
}