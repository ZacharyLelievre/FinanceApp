package com.example.financeapp

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.financeapp.databinding.AddLayoutBinding

class Add : AppCompatActivity() {
    private lateinit var binding: AddLayoutBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Inflate the layout for this activity using View Binding and set the content view
        binding = AddLayoutBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Set up the 'Add' button's click listener to capture user input and return it
        binding.addButton.setOnClickListener {
            // Capture the text and numeric input from the 'label' and price EditText
            val name = binding.labelEditText.text.toString()
            val price = binding.priceEditText.text.toString().toDoubleOrNull() ?: 0.0

            // Create an Intent
            val resultIntent = Intent()
            resultIntent.putExtra("name", name)
            resultIntent.putExtra("price", price)
            setResult(Activity.RESULT_OK, resultIntent)
            finish()
        }

        binding.closeButton.setOnClickListener {
            finish()
        }
    }
}
