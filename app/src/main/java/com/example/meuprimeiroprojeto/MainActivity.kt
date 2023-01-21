package com.example.meuprimeiroprojeto

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnCalcular : Button = findViewById(R.id.btnCalcular)
        val edtWeight : EditText = findViewById(R.id.edittext_weight)
        val edtHeight : EditText = findViewById(R.id.edittext_height)
        // tv = TextView
        // val tvResult : TextView = findViewById(R.id.txtMsg)

        btnCalcular.setOnClickListener {

            // Recuperei a msg do usuario
            // val message : String = edtPeso.text.toString()

            // aqui eu mostro uma nova msg no TextView
            // tvResult.text = message

            // variaveis criados para verificar se usuario preencheu algo no EditText Weight and Height
            val heightStr = edtHeight.text.toString()
            val weightStr = edtWeight.text.toString()

            if(heightStr.isNotEmpty() && weightStr.isNotEmpty()) {
                /* jeito nao verficado!
                val height: Float = edtHeight.text.toString().toFloat()
                val weight: Float = edtWeight.text.toString().toFloat()*/

                //
                val height: Float = heightStr.toFloat()
                val weight: Float = weightStr.toFloat()

                val finalHeight: Float = height * height
                val result: Float = weight / finalHeight

                val intent = Intent(this, ResultActivity::class.java)
                    .apply {
                        putExtra("EXTRA_RESULT", result)
                    }
                startActivity(intent)
            } else {
                Toast.makeText(this, "Preencher todos os campos", Toast.LENGTH_LONG).show()
            }
        }
    }
}