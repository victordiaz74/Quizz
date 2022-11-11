package com.example.quizz.fragmentos

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import com.example.quizz.R
import com.example.quizz.databinding.FragmentFragmentoPreguntasBinding

class FragmentoPreguntas : Fragment() {

    private val fragmentoViewModel: FragmentoViewModel by activityViewModels()
    private lateinit var binding: FragmentFragmentoPreguntasBinding

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

        binding.btnComprobar.setOnClickListener{
            comprobarRespondido()
            val aux: Int = fragmentoViewModel.getMarcador().value ?: 0
            fragmentoViewModel.getMarcador().setValue(aux + 1)
            mostrarFragmentoRespuestas()


        }
        return  fragmentoBinding.root

    }

    private fun comprobarRespondido() {
        if (binding.grupoRespuestas.checkedRadioButtonId == -1){
            Toast.makeText(this.context, "No has seleccionado ninguna respuesta", Toast.LENGTH_SHORT).show()
        }else{
            if(binding.radiobtn1.isChecked)
            Toast.makeText(this.context, "Has seleccionado ${binding?.grupoRespuestas?.checkedRadioButtonId}", Toast.LENGTH_SHORT).show()

        }
    }


    private fun mostrarFragmentoRespuestas() {

        val transaction= fragmentManager?.beginTransaction()
        val fragmentoRespuestas = FragmentoRespuestas()

        transaction?.replace(R.id.fragmentContainerView,fragmentoRespuestas)
        transaction?.addToBackStack(null)
        transaction?.commit()
    }

}