package com.example.meuprimeiroprojeto

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.TextView
import org.w3c.dom.Text
import java.text.DecimalFormat

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        supportActionBar?.setHomeButtonEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val tvResult = findViewById<TextView>(R.id.textview_result)
        val tvClassificacao = findViewById<TextView>(R.id.textview_classificacao)

        val result = intent.getFloatExtra("EXTRA_RESULT", 0.1f)

        tvResult.text = result.toString()

        // var classificacao = "Classificacção: "
        // Concatenando string
        var classificacao = ""

        if(result < 18.5f){
            classificacao = "ABAIXO DO PESO"
        // Resultado in Range, outra forma de comparacao
        }else if(result in 18.5f..25.0f){
            classificacao = "NORMAL"
        }else if(result >= 25.0f && result <30.0f){
            classificacao = "SOBREPESO"
        }else if(result >= 30f && result < 35f){
            classificacao = "OBESIDADE I"
        }else if(result >= 35f && result < 40f){
            classificacao = "OBESIDADE II"
        }else {
            classificacao = "OBESIDADE GRAVE III"
        }

        tvClassificacao.text = getString(R.string.message_classificacao, classificacao)

        // Outro jeito de se fazer:

        /*val classificacao = if(result < 18.5f){
            "ABAIXO DO PESO"
        // Resultado in Range, outra forma de comparacao
        }else if(result in 18.5f..25.0f){
            "NORMAL"
        }else if(result >= 25.0f && result <30.0f){
            "SOBREPESO"
        }else if(result >= 30f && result < 35f){
            "OBESIDADE I"
        }else if(result >= 35f && result < 40f){
            "OBESIDADE II"
        }else {
            "OBESIDADE GRAVE III"
        } */
    }

    // adicionar botao de voltar
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        finish()
        return super.onOptionsItemSelected(item)
    }
}