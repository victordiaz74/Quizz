package com.example.quizz.sqliteBD

import android.app.Activity
import android.content.Intent
import android.database.sqlite.SQLiteDatabase
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.quizz.MainActivity
import com.example.quizz.R
import com.example.quizz.SQLPreguntaListAdapter

class SQLAddNewPregunta : AppCompatActivity(){

    lateinit var preguntasDBHelper: MiBDOpenHelper
    lateinit var miSQLiteRecyclerViewAdapter: SQLPreguntaListAdapter

    lateinit var editarTxtPregunta: EditText
    lateinit var editarTxtRespuesta1: EditText
    lateinit var editarTxtRespuesta2: EditText
    lateinit var editarTxtRespuesta3: EditText
    lateinit var editarTxtRespuesta4: EditText


    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_pregunta)

        editarTxtPregunta = findViewById<EditText>(R.id.txtPregunta)
        editarTxtRespuesta1 = findViewById<EditText>(R.id.txtRespuesta1)
        editarTxtRespuesta2 = findViewById<EditText>(R.id.txtRespuesta2)
        editarTxtRespuesta3 = findViewById<EditText>(R.id.txtRespuesta3)
        editarTxtRespuesta4 = findViewById<EditText>(R.id.txtRespuesta4)

        val button = findViewById<Button>(R.id.btnAdd)

        //inicializar preguntasBDHelper
        button.setOnClickListener {
            enviarPregunta()
        }

    }

    fun enviarPregunta(){
        if (TextUtils.isEmpty(editarTxtPregunta.text) || TextUtils.isEmpty(editarTxtRespuesta1.text)
            || TextUtils.isEmpty(editarTxtRespuesta2.text) || TextUtils.isEmpty(editarTxtRespuesta3.text) || TextUtils.isEmpty(editarTxtRespuesta4.text)
        ) {
            Toast.makeText(this, "Rellena los campos", Toast.LENGTH_SHORT).show()
        } else {
            val pregunta = editarTxtPregunta.text.toString()
            val respuesta1 = editarTxtRespuesta1.text.toString()
            val respuesta2 = editarTxtRespuesta2.text.toString()
            val respuesta3 = editarTxtRespuesta3.text.toString()
            val respuesta4 = editarTxtRespuesta4.text.toString()

            if(this::preguntasDBHelper.isInitialized) {
                preguntasDBHelper.crearPregunta(
                    pregunta,
                    respuesta1,
                    respuesta2,
                    respuesta3,
                    respuesta4
                )

                val cursor = preguntasDBHelper.obtenerPreguntas()
                miSQLiteRecyclerViewAdapter.SQLPreguntaListAdapter(this, cursor)

                miSQLiteRecyclerViewAdapter.notifyDataSetChanged()
                intent = Intent(this, SQLListadoPreguntas::class.java,).apply {

                }
                startActivity(intent)
            }
        }
        finish()
    }

    fun btnVolver(view: View){
        intent = Intent(this, MainActivity::class.java,).apply{

        }
        startActivity(intent)
    }

}