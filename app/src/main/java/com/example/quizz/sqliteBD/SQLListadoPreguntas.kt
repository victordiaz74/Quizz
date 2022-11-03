package com.example.quizz.sqliteBD

import android.content.Intent
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.quizz.MainActivity
import com.example.quizz.SQLPreguntaListAdapter
import com.example.quizz.R
const val EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE"

class SQLListadoPreguntas: AppCompatActivity() {




    private lateinit var preguntasDBHelper: MiBDOpenHelper
    private lateinit var db: SQLiteDatabase
    private lateinit var miSQLiteRecyclerViewAdapter: SQLPreguntaListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_listado)

        preguntasDBHelper = MiBDOpenHelper(this, null)
        miSQLiteRecyclerViewAdapter = SQLPreguntaListAdapter()

        initRecyclerView()
        val btnAddPregunta : Button = findViewById(R.id.btnAddPregunta1)
        btnAddPregunta.setOnClickListener(){
            btnAddPregunta()
        }


    }

    fun initRecyclerView() {
        preguntasDBHelper = MiBDOpenHelper(this, null)
        val cursor = preguntasDBHelper.obtenerPreguntas()

        miSQLiteRecyclerViewAdapter = SQLPreguntaListAdapter()
        miSQLiteRecyclerViewAdapter.SQLPreguntaListAdapter(this, cursor)

        val rv = findViewById<RecyclerView>(R.id.listado)

        rv.setHasFixedSize(true)
        rv.layoutManager = LinearLayoutManager(this)
        rv.adapter = miSQLiteRecyclerViewAdapter


    }

    fun btnVolver1(view: View){
        intent = Intent(this, MainActivity::class.java).apply{

        }
        startActivity(intent)
    }

    fun btnAddPregunta(){
        intent = Intent(this, SQLAddNewPregunta::class.java)
        startActivity(intent)
    }

    fun abrirPregunta(view: View){

        var textView = findViewById<TextView>(R.id.txtPreguntaId)
        var valor = textView.text.toString()
        intent = Intent(this, SQLMostrarPregunta::class.java).apply {
            intent.putExtra(EXTRA_MESSAGE,valor)
        }
        startActivity(intent)
    }
}