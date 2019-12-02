package com.example.exercise2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val calc: Button = findViewById(R.id.buttonCalculate)
        calc.setOnClickListener{calculate()}
        val reset:Button = findViewById(R.id.buttonReset)
        reset.setOnClickListener{resetText()}

    }

    private fun resetText() {
        val weight:EditText=findViewById(R.id.editTextWeight)
        val height:EditText=findViewById(R.id.editTextHeight)
        weight.setText("")
        height.setText("")
        imageViewProfile.setImageResource(R.drawable.empty)
        textViewBMI.text = "BMI:"
        weight.requestFocus()
    }

    private fun calculate() {

        val weight = editTextWeight.text.toString().toDouble()
        val height = editTextHeight.text.toString().toDouble()

        val height2 = (height /100)  * (height / 100)
        val bmi = weight / height2
        val bmi1:Double = String.format("%.2f",bmi).toDouble()

        when {
            bmi < 18.5 -> {
                imageViewProfile.setImageResource(R.drawable.under)
                textViewBMI.text = "BMI: $bmi1(Underweight)"
            }
            bmi in 18.5..24.9 -> {
                imageViewProfile.setImageResource(R.drawable.normal)
                textViewBMI.text = "BMI: $bmi1(Normal)"
            }
            bmi >= 25 -> {
                imageViewProfile.setImageResource(R.drawable.over)
                textViewBMI.text = "BMI: $bmi1(Overweight)"
            }
        }
    }
}
