package com.example.acplicacionestados.fragmentos

import android.app.Fragment
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import com.example.acplicacionestados.R
import com.example.acplicacionestados.databinding.ActivityFragmentoBinding

class FragmentoActivity : AppCompatActivity() {
    lateinit var binding:ActivityFragmentoBinding


    private val marcadorViewModel: MarcadorViewModel by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFragmentoBinding.inflate(layoutInflater)

        setContentView(binding.root)

        binding.buttonFragmento1.setOnClickListener {
            mostrarFragmento1()
        }
        binding.buttonFragmento2.setOnClickListener{
            mostrarFragmento2()
        }


        val nameObserver = Observer<Int> { valor ->
            // Update the UI, in this case, a TextView.
            binding.tvMarcador?.setText(valor.toString())
        }
        marcadorViewModel.getMarcador().observe(this, nameObserver)



    }


    private fun mostrarFragmento1 (){

        //Se establece la transaccion de fragments, necesarios para añadir
        //quitar o reemplazar gragments
        val transaction= supportFragmentManager.beginTransaction()
        //se instancia el fragment a mostrar
        val fragmento1 = Fragment1()
        //Indicamos el elemneto del layout donde haremos el cambio
        transaction.replace(R.id.fragmentContainerView,fragmento1)
        //Se establece valor a null para inidcar que no se está interesado
        //En volver a ese fragmento más tarde, en caso contrario,
        //se indicaría el nombre del fragmento, por ejemplo gragment.TAG,
        //aprovechando la variable creada en la clase
        transaction.addToBackStack(null)
        //se muestra el fragment
        transaction.commit()
    }

    private fun mostrarFragmento2 (){

        val transaction= supportFragmentManager.beginTransaction()
        val fragmento2 = Fragment2()

        transaction.replace(R.id.fragmentContainerView,fragmento2)
        transaction.addToBackStack(null)
        transaction.commit()
    }

}