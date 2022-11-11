package com.example.quizz.fragmentos

import android.database.Cursor
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.quizz.sqliteBD.MiBDOpenHelper

class FragmentoViewModel : ViewModel() {

    private var marcador: MutableLiveData<Int>
    private var preguntasDBHelper: MiBDOpenHelper? = null
    private var preguntaActual = 0
    private var totalPreguntas = 0
    private var correcta = false

    init {
        marcador = MutableLiveData<Int>()
    }

    fun setCorrecta(estado: Boolean)
    {
        this.correcta = estado
    }

    fun getCorrecta(): Boolean
    {
        return correcta
    }

    fun setDatabase(b: MiBDOpenHelper)
    {
        this.preguntasDBHelper = b
    }

    fun getDatabase():MiBDOpenHelper?
    {
        return preguntasDBHelper
    }

    fun setMarcador(num: Int){
        var aux: Int = marcador.value?: 0
        marcador.setValue(aux + 1)

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