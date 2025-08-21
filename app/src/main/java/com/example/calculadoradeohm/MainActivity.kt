package com.example.calculadoradeohm

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val resistencia = findViewById<EditText>(R.id.Num1)
        val corrente = findViewById<EditText>(R.id.Num2)
        val resultado = findViewById<TextView>(R.id.Resultado)
        val botao = findViewById<Button>(R.id.btnCalcularOhm)

        val calc = CalcularOhm()

        botao.setOnClickListener {
            val r = resistencia.text.toString().toDoubleOrNull()
            val i = corrente.text.toString().toDoubleOrNull()

            if (r != null && i != null) {
                val tensao = calc.calcularPrimeiraLei(r, i)
                resultado.text = "Tensão = $tensao V"
            } else {
                resultado.text = "Digite valores válidos!"
            }
        }
    }
}


