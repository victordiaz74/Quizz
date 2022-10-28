package com.example.quizz.sqliteBD

import android.content.Intent
import android.database.sqlite.SQLiteDatabase
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.quizz.MainActivity
import com.example.quizz.PreguntaListAdapter
import com.example.quizz.R
import com.example.quizz.room.AddNewPregunta

class SQLListadoPreguntas: AppCompatActivity() {

    private lateinit var preguntasDBHelper: MiBDOpenHelper
    private lateinit var db: SQLiteDatabase
    private lateinit var miSQLiteRecyclerViewAdapter: PreguntaListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_listado)

        initRecyclerView()
        val buttonCrearNota : Button = findViewById(R.id.btnAddPregunta1)
        buttonCrearNota.setOnClickListener(){
            btnCrearPregunta()
        }

    }

    fun initRecyclerView() {
        preguntasDBHelper = MiBDOpenHelper(this, null)
        val cursor = preguntasDBHelper.obtenerPreguntas()

        miSQLiteRecyclerViewAdapter = PreguntaListAdapter()
        miSQLiteRecyclerViewAdapter.SQLiteRecyclerViewAapter(this, cursor)
        val rv = findViewById<RecyclerView>(R.id.listado)
        rv.adapter = miSQLiteRecyclerViewAdapter
        rv.layoutManager = LinearLayoutManager(this)

    }

    fun btnVolver1(view: View){
        intent = Intent(this, MainActivity::class.java,).apply{

        }
        startActivity(intent)
    }

    fun btnCrearPregunta(){
        intent = Intent(this, AddNewPregunta::class.java,).apply{

        }
        startActivity(intent)
    }
}