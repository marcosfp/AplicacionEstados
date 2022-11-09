package com.example.acplicacionestados.fragmentos

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.acplicacionestados.databinding.Fragment1Binding

class Fragment1 : Fragment() {

    private val marcadorViewModel: MarcadorViewModel by activityViewModels()
    private var binding: Fragment1Binding? = null

    //Es llamado cuando se crea el fragmento
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    //Es creado cuando el fragment se renderiza en la interfaz
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val fragmentBinding = Fragment1Binding.inflate(inflater, container, false)
        binding = fragmentBinding

        binding?.buttonFragment1?.setOnClickListener {

            val aux: Int = marcadorViewModel.getMarcador().value ?: 0
            marcadorViewModel.getMarcador().setValue(aux + 1)

        }
        return fragmentBinding.root
    }

}