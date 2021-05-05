package com.example.at01_consulta_alunos

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.TextView
import com.google.gson.Gson
import java.net.URL

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun consulta(v:View){

        val raView: EditText = findViewById(R.id.et_ra)
        val ra = raView.text.toString()

        val t1 = Thread{
            var enderecoURL = "https://cvciis5ov8.execute-api.us-east-1.amazonaws.com/beta/alunos?ra=" + ra
            var dadosJson = URL(enderecoURL).readText()

            Log.d("API",dadosJson)

            val regAluno = Gson().fromJson(dadosJson,RegAluno::class.java)

            Log.d("API",regAluno.ra)
            Log.d("API",regAluno.nome)
            Log.d("API",regAluno.turma)

            this@MainActivity.runOnUiThread(
                {
                    val nome: TextView = findViewById(R.id.tv_alunos)
                    nome.setText(regAluno.nome)
                }
            )
        }.start()

    }


}