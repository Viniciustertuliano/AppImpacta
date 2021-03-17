package com.example.meuprimeiroapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun calcular(v:View){
        val alcool: EditText = findViewById(R.id.et_valorAlcool)
        val gasolina: EditText = findViewById(R.id.et_valorGasolina)

        var relacao: Double

        val valoralcool:String? = alcool.text.toString()
        val valorgasolina:String? = gasolina.text.toString()

        if (valoralcool != null && valoralcool!= "" &&
            valorgasolina != null && valorgasolina != ""){
            relacao = valoralcool.toDouble() / valorgasolina.toDouble()

            if (relacao < 0.7) {
                Toast.makeText(this, "Abasteça com Alcool", Toast.LENGTH_LONG).show()
            } else {
                Toast.makeText(this, "Abasteça com Gasolina", Toast.LENGTH_LONG).show()
            }
        }
        else{
            Toast.makeText(this, "Digite o valor correto", Toast.LENGTH_LONG).show()
        }
    }

}