package com.example.quizz.fragmentos

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.view.isVisible
import androidx.fragment.app.activityViewModels
import com.example.quizz.databinding.FragmentFragmentoSolucionBinding
import com.example.quizz.sqliteBD.MiBDOpenHelper


class FragmentoSolucion : Fragment() {

    private lateinit var preguntasDBHelper: MiBDOpenHelper
    private val fragmentoViewModel: FragmentoViewModel by activityViewModels()
    private var binding: FragmentFragmentoSolucionBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val fragmentoBinding = FragmentFragmentoSolucionBinding.inflate(inflater, container, false)
        binding = fragmentoBinding

        cargarDatosFin()
        comprobarPuntuacionMax()

        return fragmentoBinding.root
    }

    private fun comprobarPuntuacionMax() {

        //compruebo la puntuacion maxima
        var puntuacionMax = preguntasDBHelper.obtenerPuntuacionMax()
        if(puntuacionMax < fragmentoViewModel.aciertos){
            //si es menor la puntuacion maxima al numero de aciertos se cambia el valor en la base de datos
            puntuacionMax = fragmentoViewModel.aciertos
            preguntasDBHelper.crearPuntuacionMax(puntuacionMax.toString())
            binding!!.textoNuevaPuntuacionMax.setVisibility(TextView.VISIBLE)
        }

    }

    fun cargarDatosFin() {

        binding?.textoAciertos?.text = fragmentoViewModel.aciertos.toString()

        binding?.textoFallos?.text = (fragmentoViewModel.fallos - fragmentoViewModel.aciertos).toString()

    }

}