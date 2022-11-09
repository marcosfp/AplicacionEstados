package com.example.acplicacionestados

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.acplicacionestados.databinding.ActivityMainBinding
import com.example.acplicacionestados.fragmentos.FragmentoActivity


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.buttoEstados?.setOnClickListener {
            val intentEstados = Intent(this, EstadosActivity::class.java)
            startActivity(intentEstados)
        }
        binding.buttonMarcador?.setOnClickListener {
            val intentMarcador = Intent(this, FragmentoActivity::class.java)
            startActivity(intentMarcador)
        }

    }

}