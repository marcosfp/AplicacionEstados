package com.example.acplicacionestados.fragmentos

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModelProvider
import com.example.acplicacionestados.R
import com.example.acplicacionestados.databinding.Fragment1Binding
import com.example.acplicacionestados.databinding.Fragment2Binding

class Fragment2 : Fragment() {

    private val marcadorViewModel: MarcadorViewModel by activityViewModels()
    private var binding: Fragment2Binding? = null

    //Es llamado cuando se crea el fragmento
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val fragmentBinding = Fragment2Binding.inflate(inflater, container, false)
        binding = fragmentBinding
        binding?.buttonFragmento2?.setOnClickListener {

            val aux: Int = marcadorViewModel.getMarcador().value ?: 0
            marcadorViewModel.getMarcador().setValue(aux + 1)

        }

        // Inflate the layout for this fragment
        return fragmentBinding.root
    }

}