package com.example.quizz.fragmentos

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import com.example.quizz.R
import com.example.quizz.databinding.FragmentFragmentoPreguntasBinding
import com.example.quizz.sqliteBD.MiBDOpenHelper

class FragmentoPreguntas : Fragment() {

    private lateinit var preguntasDBHelper: MiBDOpenHelper
    private val fragmentoViewModel: FragmentoViewModel by activityViewModels()
    private var binding: FragmentFragmentoPreguntasBinding? = null


    //Es llamado cuando se crea el fragmento
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        preguntasDBHelper = MiBDOpenHelper(this.context, null)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        preguntasDBHelper = fragmentoViewModel.getDatabase()!!
        val fragmentoBinding = FragmentFragmentoPreguntasBinding.inflate(inflater, container, false)
        binding = fragmentoBinding

        cargar()

        binding?.btnComprobar?.setOnClickListener{
            comprobarRespondido()
            mostrarFragmentoRespuestas()

        }
        return  fragmentoBinding.root

    }

    private fun cargar()
    {
        val pregunta = preguntasDBHelper.obtenerPreguntaId(fragmentoViewModel.getPreguntaActual().toString())

        binding?.textoPreguntas?.text = pregunta.getString(1)

        binding?.radiobtn1?.text = pregunta.getString(2)
        binding?.radiobtn2?.text = pregunta.getString(3)
        binding?.radiobtn3?.text = pregunta.getString(4)
        binding?.radiobtn4?.text = pregunta.getString(5)
    }

    private fun comprobarRespondido() {
        if (binding?.grupoRespuestas?.checkedRadioButtonId == -1){
            Toast.makeText(this.context, "No has seleccionado ninguna respuesta", Toast.LENGTH_SHORT).show()
        }else{

            Log.e("$preguntasDBHelper", "idPregunta que se le pasa a la consulta: $preguntasDBHelper")

            val solucion = preguntasDBHelper.obtenerPreguntaId(fragmentoViewModel.getPreguntaActual().toString())

            val correcta = solucion.getString(5).toString()

            if (binding?.radiobtn1?.isChecked == true && (binding?.radiobtn1?.text == correcta)){
                Toast.makeText(this.context, "Has seleccionado la respuesta 1", Toast.LENGTH_SHORT).show()
                fragmentoViewModel.setCorrecta(true)
            }
            else if (binding?.radiobtn2?.isChecked == true && (binding?.radiobtn2?.text == correcta)){
                Toast.makeText(this.context, "Has seleccionado la respuesta 2", Toast.LENGTH_SHORT).show()
                fragmentoViewModel.setCorrecta(true)

            }
            else if (binding?.radiobtn3?.isChecked == true && (binding?.radiobtn3?.text == correcta)){
                Toast.makeText(this.context, "Has seleccionado la respuesta 3", Toast.LENGTH_SHORT).show()
                fragmentoViewModel.setCorrecta(true)

            }
            else if (binding?.radiobtn4?.isChecked == true && (binding?.radiobtn4?.text == correcta)){
                Toast.makeText(this.context, "Has seleccionado la respuesta 4", Toast.LENGTH_SHORT).show()
                fragmentoViewModel.setCorrecta(true)

            }
            else{
                fragmentoViewModel.setCorrecta(false)

            }
            fragmentoViewModel.setPreguntaActual()
        }
    }


    private fun mostrarFragmentoRespuestas() {

        //se establece la transaccion entre fragments
        val transaction= fragmentManager?.beginTransaction()
        //se instancia el fragment al que vamos a cambiar
        val fragmentoRespuestas = FragmentoRespuestas()

        //se indica el elemento R al que se cambia
        transaction?.replace(R.id.fragmentContainerView,fragmentoRespuestas)
        transaction?.addToBackStack(null)
        //se muestra el fragment
        transaction?.commit()
    }

}