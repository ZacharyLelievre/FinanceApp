package com.example.financeapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.financeapp.databinding.ActivityChartBinding


class Chart : AppCompatActivity() {
    private lateinit var binding: ActivityChartBinding
    private var transactions: ArrayList<Transaction> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityChartBinding.inflate(layoutInflater)
        setContentView(binding.root)

        transactions = intent.getSerializableExtra("transactions") as? ArrayList<Transaction> ?: arrayListOf()

        if (transactions.isEmpty()) {
            finish() // Exit if there are no transactions
            return
        }
        setupChart()
        updateChartData()

        binding.closeButton.setOnClickListener {
            finish() // Close this activity
        }
    }

    private fun setupChart() {
        // You can configure more chart settings here
        binding.barChart.animation.duration = 1000L // Example animation setup
    }

    private fun updateChartData() {
        var totalBalance = 0.0
        var totalExpenses = 0.0

        for (transaction in transactions) {
            totalBalance += transaction.price
            if (transaction.price < 0) {
                totalExpenses -= transaction.price // Making the expense positive
            }
        }

        val points = listOf(
            "Total" to totalBalance.toFloat(),
            "Expenses" to totalExpenses.toFloat()
        )

        binding.barChart.show(points) // This is a method you would need to ensure exists or is similar to how WilliamChart expects data
    }

}


