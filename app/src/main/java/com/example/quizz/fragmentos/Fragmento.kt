package com.example.quizz.fragmentos

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.example.quizz.databinding.ActivityFragmentoBinding
import androidx.lifecycle.Observer
import com.example.quizz.R
import com.example.quizz.sqliteBD.MiBDOpenHelper

class Fragmento : AppCompatActivity() {

    private var binding: ActivityFragmentoBinding? = null
    private val fragmentoViewModel: FragmentoViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFragmentoBinding.inflate(layoutInflater)

        setContentView(binding?.root)

        mostrarFragmentoPreguntas()


        val base = MiBDOpenHelper(this, null)
        var cursor = base.obtenerPreguntas()
        fragmentoViewModel.setTotalPreguntas(cursor.count)


        val nameObserver = Observer<Int>{
            //Actualizar la UI porque es un TextView
            valor -> binding?.textoPuntosMarcador?.setText(valor.toString())
        }

        fragmentoViewModel.getMarcador().observe(this, nameObserver)

    }

    private fun mostrarFragmentoPreguntas() {

        val transaction = supportFragmentManager.beginTransaction()

        val fragmentoPreguntas = FragmentoPreguntas()

        transaction.replace(R.id.fragmentContainerView, fragmentoPreguntas)

        transaction.addToBackStack(null)
        transaction.commit()

    }




}