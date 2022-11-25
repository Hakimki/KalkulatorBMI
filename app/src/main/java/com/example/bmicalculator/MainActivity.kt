package com.example.bmicalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.bmicalculator.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {


    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.WeightPicker.minValue = 38
        binding.WeightPicker.maxValue = 150

        binding.heightPicker.minValue = 100
        binding.heightPicker.maxValue = 250

        binding.WeightPicker.setOnValueChangedListener{ _, _, _ ->
            calculateBMI()

        }
        binding.WeightPicker.setOnValueChangedListener{ _, _, _ ->
            calculateBMI()

        }

    }

    private fun calculateBMI(){
        var height = binding.heightPicker.value
        var Doubleheight = height.toDouble() / 100

        val weight = binding.WeightPicker.value

        val bmi = weight.toDouble() / (Doubleheight*Doubleheight)

        binding.resultsTV.text = String.format("Your BMI os : %.2f", bmi)
        binding.healthyTV.text = String.format("Considered : %s", healtyMessage(bmi))


    }

    private fun healtyMessage (bmi : Double) : String{

        if(bmi < 18.5)
            return "Underweight"
        if(bmi < 25.0)
            return "Healthy"
        if(bmi < 30 )
            return "Overweight"






        return "Obese"
    }
}