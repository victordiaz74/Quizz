package com.example.quizz.sqliteBD

import android.content.Intent
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


    lateinit var button: Button

    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_pregunta)

        button = findViewById<Button>(R.id.btnAdd)

        button.setOnClickListener(){
            enviarPregunta()
        }

    }

    fun enviarPregunta() {

       val editarTxtPregunta = findViewById<EditText>(R.id.textoPregunta).text.toString()
        if(editarTxtPregunta != "") {
            intent = Intent(this, SQLAddRespuestas::class.java).apply {
                putExtra("pregunta", editarTxtPregunta)
            }

            startActivity(intent)
        }
        else {
            Toast.makeText(this, "Introduce una pregunta.", Toast.LENGTH_SHORT).show()
        }

    }


    fun btnVolver(view: View){
        intent = Intent(this, MainActivity::class.java,).apply{

        }
        startActivity(intent)
    }

}