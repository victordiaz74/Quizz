package com.example.quizz

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class AddNewPregunta : AppCompatActivity(){

    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_pregunta)
        val editarTxtPregunta = findViewById<EditText>(R.id.txtPregunta)
        val editarTxtRespuesta1 = findViewById<EditText>(R.id.txtRespuesta1)
        val editarTxtRespuesta2 = findViewById<EditText>(R.id.txtRespuesta2)
        val editarTxtRespuesta3 = findViewById<EditText>(R.id.txtRespuesta3)
        val editarTxtRespuesta4 = findViewById<EditText>(R.id.txtRespuesta4)

        val button = findViewById<Button>(R.id.btnAdd)
        button.setOnClickListener {
            val replyIntent = Intent()
            if (TextUtils.isEmpty(editarTxtPregunta.text) || TextUtils.isEmpty(editarTxtRespuesta1.text)
                || TextUtils.isEmpty(editarTxtRespuesta2.text) || TextUtils.isEmpty(editarTxtRespuesta3.text) || TextUtils.isEmpty(editarTxtRespuesta4.text)
            ) {
                setResult(Activity.RESULT_CANCELED, replyIntent)
            } else {
                val pregunta = editarTxtPregunta.text.toString()
                replyIntent.putExtra(EXTRA_REPLY, pregunta)
                setResult(Activity.RESULT_OK, replyIntent)

                val respuesta1 = editarTxtRespuesta1.text.toString()
                replyIntent.putExtra(EXTRA_REPLY, respuesta1)
                setResult(Activity.RESULT_OK, replyIntent)

                val respuesta2 = editarTxtRespuesta2.text.toString()
                replyIntent.putExtra(EXTRA_REPLY, respuesta2)
                setResult(Activity.RESULT_OK, replyIntent)

                val respuesta3 = editarTxtRespuesta3.text.toString()
                replyIntent.putExtra(EXTRA_REPLY, respuesta3)
                setResult(Activity.RESULT_OK, replyIntent)

                val respuesta4 = editarTxtRespuesta4.text.toString()
                replyIntent.putExtra(EXTRA_REPLY, respuesta4)
                setResult(Activity.RESULT_OK, replyIntent)
            }
            finish()
        }

    }

    fun btnVolver(view: View){
        intent = Intent(this, MainActivity::class.java,).apply{

        }
        startActivity(intent)
    }

    companion object {
        const val EXTRA_REPLY = "com.example.android.preguntalistsql.REPLY"
    }
}