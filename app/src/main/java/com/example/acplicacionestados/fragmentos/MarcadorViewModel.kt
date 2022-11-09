package com.example.acplicacionestados.fragmentos

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel


class MarcadorViewModel : ViewModel() {

    private var marcador: MutableLiveData<Int>

    init {
        marcador = MutableLiveData<Int>()
    }

    fun getMarcador(): MutableLiveData<Int> {
        if (marcador == null) {

        }
        return marcador
    }



}
