package com.example.degreesconverter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    lateinit var btnConvert : Button
    lateinit var temperatureInput : EditText
    lateinit var result: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btnConvert = findViewById<Button>(R.id.btnConverter)
        temperatureInput = findViewById<EditText>(R.id.tempInput)
        result = findViewById<TextView>(R.id.result)
        btnConvert.setOnClickListener {
            showMessage()
        }
    }

    private fun showMessage() {
        val temperatureText = temperatureInput.text.toString()
        if (temperatureText.isNotEmpty()) {
            try {
                val temperature = temperatureText.toDouble()
                val celsius = (temperature - 32) * 5 / 9
                result.text = celsius.toString()
            } catch (e: NumberFormatException) {
                Toast.makeText(this, "Ingrese una temperatura válida", Toast.LENGTH_SHORT).show()
            }
        } else {
            Toast.makeText(this, "Ingrese una temperatura", Toast.LENGTH_SHORT).show()
        }
    }
}
