package com.example.quizz.fragmentos

import android.database.Cursor
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.quizz.sqliteBD.MiBDOpenHelper

class FragmentoViewModel : ViewModel() {

    private var marcador: MutableLiveData<Int>
    private lateinit var preguntasDBHelper: MiBDOpenHelper
    private var preguntaActual = 0
    private var totalPreguntas = 0

    init {
        marcador = MutableLiveData<Int>()
    }

    fun setMarcador(num: Int){
        var valor = Integer.parseInt(marcador.toString())

        //
    }
    fun getMarcador(): MutableLiveData<Int>{
        if(marcador == null){

        }
        return marcador
    }

    fun setPreguntaActual(){
        preguntaActual += 1
    }

    fun getPreguntaActual(): Int{
        return preguntaActual
    }

    fun setTotalPreguntas(num: Int){
        totalPreguntas = num
    }
}