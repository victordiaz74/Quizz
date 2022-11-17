package com.example.quizz.fragmentos

import android.database.Cursor
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.quizz.sqliteBD.MiBDOpenHelper

class FragmentoViewModel : ViewModel() {

    private var marcador: MutableLiveData<Int>
    private var puntuacionMaxima: MutableLiveData<Int>
    private var preguntasDBHelper: MiBDOpenHelper? = null
    private var preguntaActual = 1
    private var totalPreguntas:Int = 0
    private var correcta = false
    private var puntuacionMax = 0
    var aciertos = 0
    var fallos = 0

    init {
        marcador = MutableLiveData<Int>()
        puntuacionMaxima = MutableLiveData<Int>()
    }

    fun setCorrecta(estado: Boolean) {
        if(estado == true){
            aciertos += 1
        }else{
            fallos += 1
        }
        this.correcta = estado
    }

    fun getCorrecta(): Boolean {
        return correcta
    }

    fun setDatabase(b: MiBDOpenHelper) {
        this.preguntasDBHelper = b
    }

    fun getDatabase():MiBDOpenHelper? {
        return preguntasDBHelper
    }

    fun setMarcador(){
        var aux: Int = marcador.value?: 0
        marcador.setValue(aux + 1)

    }

    fun getMarcador(): MutableLiveData<Int>{
        if(marcador == null){

        }
        return marcador
    }

    fun setPuntuacionMaxima(){
        var aux: Int = puntuacionMax.value?: 0
        puntuacionMax.setValue(aux + 1)

    }

    fun getPuntuacionMaxima(): MutableLiveData<Int>{
        if(puntuacionMax == null){

        }
        return puntuacionMax
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

    fun getTotalPreguntas(): Int{
        return totalPreguntas
    }
}