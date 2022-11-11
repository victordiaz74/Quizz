package com.example.quizz.fragmentos

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
        binding?.btnSiguientePregunta?.setOnClickListener{

            val aux: Int = fragmentoViewModel.getMarcador().value ?: 0
            fragmentoViewModel.getMarcador().setValue(aux + 1)
            mostrarFragmentoPreguntas()

        }
        return fragmentoBinding.root
    }

    private fun mostrarFragmentoPreguntas() {

        val transaction = fragmentManager?.beginTransaction()

        val fragmentoPreguntas = FragmentoPreguntas()

        transaction?.replace(R.id.fragmentContainerView, fragmentoPreguntas)

        transaction?.addToBackStack(null)
        transaction?.commit()

    }

}