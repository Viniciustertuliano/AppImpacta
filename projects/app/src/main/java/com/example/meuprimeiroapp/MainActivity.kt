package com.example.meuprimeiroapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun calcImc(v:View){
        val peso: EditText = findViewById(R.id.edt_peso)
        val altura: EditText = findViewById(R.id.edt_altura)

        var txtresposta: TextView = findViewById(R.id.tv_result)

        var resp: Double

        val valorpeso:String? = peso.text.toString()
        val valoraltura:String? = altura.text.toString()

        if (valorpeso != null && valorpeso != "" && valorpeso != "0"
            && valoraltura != null && valoraltura != "" && valoraltura != "0"){

            resp = valorpeso.toDouble() / (valoraltura.toDouble() * valoraltura.toDouble())

            if (resp < 18.5){txtresposta.setText("Abaixo do peso")}
            else if ( resp >= 18.5 && resp <= 24.9){ txtresposta.setText("Peso normal")}
            else if ( resp >= 25 && resp <= 29.9){txtresposta.setText("Sobrepeso")}
            else if ( resp >= 30 && resp <= 34.9){txtresposta.setText("Obesidade grau 1")}
            else if ( resp >= 35 && resp <= 39.9){txtresposta.setText("Obesidade grau 2")}
            else {txtresposta.setText("Obesidade grau 3")}

        }else{
            Toast.makeText(this, "Digite o valor correto", Toast.LENGTH_LONG).show()
        }

    }

}