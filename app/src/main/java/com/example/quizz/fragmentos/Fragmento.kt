package com.example.quizz.fragmentos

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import com.example.quizz.databinding.ActivityFragmentoBinding
import androidx.lifecycle.Observer
import com.example.quizz.MainActivity
import com.example.quizz.sqliteBD.MiBDOpenHelper

class Fragmento : AppCompatActivity() {


    private var binding: ActivityFragmentoBinding? = null
    private val fragmentoViewModel: FragmentoViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFragmentoBinding.inflate(layoutInflater)
        setContentView(binding!!.root)

        //inicializo la base de datos para tener en el activity todo
        val preguntasBDHelper = MiBDOpenHelper(this, null)
        //le paso la base de datos
        fragmentoViewModel.setDatabase(preguntasBDHelper)

        //numero total de preguntas que hay en la base de datos
        var cursor = preguntasBDHelper.obtenerPreguntas()
        fragmentoViewModel.setTotalPreguntas(cursor.count)

        val nameObserver = Observer<Int>{
            //Actualizar la UI porque es un TextView
            valor -> binding!!.textoPuntosMarcador?.setText(valor.toString())
        }

        fragmentoViewModel.getMarcador().observe(this, nameObserver)

    }

    fun btnVolver(view: View){
        intent = Intent(this, MainActivity::class.java,).apply{

        }
        startActivity(intent)
    }

}