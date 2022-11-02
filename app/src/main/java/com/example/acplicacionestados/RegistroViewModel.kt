package com.example.acplicacionestados

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class RegistroViewModel : ViewModel() {

    private var registroTexto: MutableLiveData<String>

    init {
        registroTexto = MutableLiveData<String>()
    }

    fun getRegistroTexto(): MutableLiveData<String> {
        if (registroTexto == null) {

        }
        return registroTexto
    }

}


