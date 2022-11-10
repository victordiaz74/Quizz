package com.example.quizz.fragmentos

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class FragmentoViewModel : ViewModel() {

    private var marcador: MutableLiveData<Int>

    init {
        marcador = MutableLiveData<Int>()
    }

    fun getMarcador(): MutableLiveData<Int>{
        if(marcador == null){

        }
        return marcador
    }
}