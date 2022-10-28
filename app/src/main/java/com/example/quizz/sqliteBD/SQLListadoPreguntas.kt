package com.example.quizz.sqliteBD

import android.content.Intent
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.quizz.MainActivity
import com.example.quizz.SQLPreguntaListAdapter
import com.example.quizz.R
import com.example.quizz.room.AddNewPregunta

class SQLListadoPreguntas: AppCompatActivity() {

    private lateinit var preguntasDBHelper: MiBDOpenHelper
    private lateinit var db: SQLiteDatabase
    private lateinit var miSQLiteRecyclerViewAdapter: SQLPreguntaListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_listado)

        initRecyclerView()
        val btnAddPregunta : Button = findViewById(R.id.btnAddPregunta1)
        btnAddPregunta.setOnClickListener(){
            btnAddPregunta()
        }


    }

    fun initRecyclerView() {
        preguntasDBHelper = MiBDOpenHelper(this, null)
        val cursor = preguntasDBHelper.obtenerPreguntas()
        //db = preguntasDBHelper.readableDatabase
        //val cursor: Cursor = db.rawQuery("SELECT * FROM ${MiBDOpenHelper.TABLA_PREGUNTAS}", null)
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
}