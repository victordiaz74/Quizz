package com.example.quizz.fragmentos

import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.example.quizz.R
import com.example.quizz.databinding.FragmentFragmentoRespuestasBinding

class FragmentoRespuestas : Fragment() {

    private val fragmentoViewModel: FragmentoViewModel by activityViewModels()
    private var binding: FragmentFragmentoRespuestasBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val fragmentoBinding = FragmentFragmentoRespuestasBinding.inflate(inflater, container, false)
        binding = fragmentoBinding

        //paso vista de acierto o fallo
        solucionRespuesta()

        binding?.btnSiguientePregunta?.setOnClickListener{

            //paso a la siguiente pregunta actualizando el marcador
            siguiente()

        }
        return fragmentoBinding.root
    }

    private fun solucionRespuesta() {

        if(fragmentoViewModel.getCorrecta()){
            fragmentoViewModel.setMarcador()
            binding?.textoRespuestaCorrecta?.text = "HAS ACERTADO!!"
            binding?.layoutColor?.setBackgroundColor(Color.GREEN)
        }else{
            binding?.textoRespuestaCorrecta?.text = "HAS FALLADO!!"
            binding?.layoutColor?.setBackgroundColor(Color.RED)

        }

    }

    private fun siguiente() {

        //en caso que sea la ultima pregunta de la base de datos muestra resumen del quizz
        if(fragmentoViewModel.getTotalPreguntas()+1 == fragmentoViewModel.getPreguntaActual()){
            mostrarFragmentoSolucion()
        }else{
            fragmentoViewModel.setCorrecta(false)
            mostrarFragmentoPreguntas()
        }

    }

    private fun mostrarFragmentoSolucion() {

        val transaction = fragmentManager?.beginTransaction()

        val fragmentoSolucion = FragmentoSolucion()

        transaction?.replace(R.id.fragmentContainerView, fragmentoSolucion)

        transaction?.addToBackStack(null)
        transaction?.commit()


    }

    private fun mostrarFragmentoPreguntas() {

        val transaction = fragmentManager?.beginTransaction()

        val fragmentoPreguntas = FragmentoPreguntas()

        transaction?.replace(R.id.fragmentContainerView, fragmentoPreguntas)

        transaction?.addToBackStack(null)
        transaction?.commit()

    }

}