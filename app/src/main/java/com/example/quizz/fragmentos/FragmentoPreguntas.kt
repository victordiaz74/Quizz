package com.example.quizz.fragmentos

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.example.quizz.databinding.FragmentFragmentoPreguntasBinding

class FragmentoPreguntas : Fragment() {

    private val fragmentoViewModel: FragmentoViewModel by activityViewModels()
    private var binding: FragmentFragmentoPreguntasBinding? = null

    //Es llamado cuando se crea el fragmento
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val fragmentoBinding = FragmentFragmentoPreguntasBinding.inflate(inflater, container, false)
        binding = fragmentoBinding

        binding?.btnComprobar?.setOnClickListener{
            val aux: Int = fragmentoViewModel.getMarcador().value ?: 0
            fragmentoViewModel.getMarcador().setValue(aux + 1)
        }
        return  fragmentoBinding.root

    }


}