package com.example.quizz.fragmentos

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.example.quizz.R
import com.example.quizz.databinding.FragmentFragmentoRespuestasBinding
import com.example.quizz.databinding.FragmentFragmentoSolucionBinding


class FragmentoSolucion : Fragment() {

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

        return fragmentoBinding.root
    }

    fun cargarDatosFin() {

        binding?.textoAciertos?.text = fragmentoViewModel.aciertos.toString()

        binding?.textoFallos?.text = (fragmentoViewModel.getTotalPreguntas() - fragmentoViewModel.aciertos).toString()

    }

}