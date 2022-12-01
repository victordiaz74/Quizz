package com.example.quizz.sqliteBD

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.quizz.MainActivity
import com.example.quizz.SQLPreguntaListAdapter
import com.example.quizz.R
import com.example.quizz.databinding.ActivityListadoBinding

class SQLListadoPreguntas: AppCompatActivity() {

    private lateinit var preguntasDBHelper: MiBDOpenHelper
    private lateinit var miSQLiteRecyclerViewAdapter: SQLPreguntaListAdapter
    //para usar binding
    private lateinit var binding: ActivityListadoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //inicializamos el binding
        binding = ActivityListadoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        preguntasDBHelper = MiBDOpenHelper(this, null)


        initRecyclerView()
        val btnAddPregunta : Button = binding.btnAddPregunta1
        btnAddPregunta.setOnClickListener(){
            btnAddPregunta()
        }

    }

    fun initRecyclerView() {
        preguntasDBHelper = MiBDOpenHelper(this, null)
        val cursor = preguntasDBHelper.obtenerPreguntas()

        miSQLiteRecyclerViewAdapter=SQLPreguntaListAdapter( onClickListener = {posicion -> seleccionarItem(posicion)} )
        miSQLiteRecyclerViewAdapter.SQLPreguntaListAdapter(this,cursor)


        val rv = binding.listado

        rv.setHasFixedSize(true)
        rv.layoutManager = LinearLayoutManager(this)
        rv.adapter = miSQLiteRecyclerViewAdapter


    }

    fun btnVolver1(view: View){
        intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }

    fun btnAddPregunta(){
        intent = Intent(this, SQLAddNewPregunta::class.java)
        startActivity(intent)
    }

    fun seleccionarItem(posicion: String){

        intent = Intent(this, SQLMostrarPregunta::class.java).apply {
            putExtra("id",posicion)
            Log.e("idPregunta", "idPregunta = $posicion")

        }
        startActivity(intent)
    }
    @Override
    override fun onNewIntent(intent: Intent){
        super.onNewIntent(intent)
        setIntent(intent)
    }
}