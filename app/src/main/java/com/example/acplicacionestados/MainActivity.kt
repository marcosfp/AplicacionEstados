package com.example.acplicacionestados

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.example.acplicacionestados.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var variableTexto = "vacio"
    private val registroViewModel: RegistroViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button.setOnClickListener {

            variableTexto = binding.editTextVariable.text.toString()
            binding.textViewVariables.text =
                binding.textViewVariables.text.toString() + "\n boton: " + binding.editTextVariable.text.toString()

            binding.textViewSharedPrefeernces?.setText(binding.textViewSharedPrefeernces?.text.toString() + "\n boton: " + binding.editTextVariable.text.toString())

            val sharedPref = this.getPreferences(Context.MODE_PRIVATE)
            val editor = this.getPreferences(Context.MODE_PRIVATE).edit()
            val valorGuardado =
                sharedPref?.getString(getString(R.string.ValorGuardado), "No hay valor")
            editor.putString(
                getString(R.string.ValorGuardado),
                binding.textViewVariables?.text.toString() + "/n " + valorGuardado
            )
            editor.apply()
        }

        binding.buttonLimpiar?.setOnClickListener {
            variableTexto = ""
            binding.textViewVariables.text = ""

            binding.textViewSharedPrefeernces?.setText("")

            val editor = this.getPreferences(Context.MODE_PRIVATE).edit()
            editor.putString(
                getString(R.string.ValorGuardado),
                ""
            )
            editor.apply()
        }

        binding.editTextVariable.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                registroViewModel.getRegistroTexto().setValue(s.toString())

            }

            override fun afterTextChanged(editable: Editable) {
                registroViewModel.getRegistroTexto().setValue(editable.toString())
            }
        })
        val nameObserver = Observer<String> { texto ->
            // Update the UI, in this case, a TextView.
            binding.textViewModelView?.setText(texto)
        }
        registroViewModel.getRegistroTexto().observe(this, nameObserver)


    }

    override fun onResume() {
        super.onResume()
        establecervalorVariable("onResume")
        establecerSharedPrefereneces("onResume")
    }

    override fun onStart() {
        super.onStart()
        establecervalorVariable("onStart")
        establecerSharedPrefereneces("onStart")
    }

    override fun onPause() {
        super.onPause()

        establecervalorVariable("OnPause")
        establecerSharedPrefereneces("OnPause")
    }

    override fun onDestroy() {
        super.onDestroy()
        establecervalorVariable("onDestroy")
        establecerSharedPrefereneces("onDestroy")
    }

    fun establecervalorVariable(estado: String) {
        //Valor por variables
        binding.textViewVariables.text =
            binding.textViewVariables.text.toString() + "\n $estado : " + variableTexto


    }

    fun establecerSharedPrefereneces(estado: String) {
        //Valor SharedPreferences
        val sharedPref = this?.getPreferences(Context.MODE_PRIVATE)
        val valorGuardado = sharedPref?.getString(getString(R.string.ValorGuardado), "No hay valor")

        val nuevoValor = " $estado: \n Shared Preferences" + valorGuardado

        val editor = this.getPreferences(Context.MODE_PRIVATE).edit()
        sharedPref?.edit()?.putString(
            getString(R.string.ValorGuardado),
            nuevoValor
        )?.commit()

        binding.textViewSharedPrefeernces?.setText( nuevoValor)

        Toast.makeText(this, "$estado", Toast.LENGTH_LONG).show()
    }

}