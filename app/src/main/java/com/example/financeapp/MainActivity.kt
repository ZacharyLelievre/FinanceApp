package com.example.financeapp

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.financeapp.databinding.ActivityMainBinding
import java.io.Serializable

class MainActivity : AppCompatActivity() {
    // Late-initialized properties for UI and data management
    private lateinit var binding: ActivityMainBinding
    private lateinit var transactions: ArrayList<Transaction>
    private lateinit var transactionAdapter: TransactionAdapter
    private lateinit var linearLayoutManager: LinearLayoutManager

    // Request code for launching the Add activity
    private val addTransactionRequestCode = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Inflate the layout for this activity using View Binding
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Initialize the list of transactions
        transactions = arrayListOf()

        // Set up the RecyclerView
        transactionAdapter = TransactionAdapter(transactions)
        linearLayoutManager = LinearLayoutManager(this)
        binding.recyclerview.apply {
            adapter = transactionAdapter
            layoutManager = linearLayoutManager
        }

        // Set up the listener for the 'Add' button to start AddActivity
        binding.addBtn.setOnClickListener {
            val intent = Intent(this, Add::class.java)
            startActivityForResult(intent, addTransactionRequestCode)
        }

        // Set up the listener for the 'View Chart' button to start ChartActivity
        binding.viewChartButton.setOnClickListener {
            val intent = Intent(this, Chart::class.java)
            intent.putExtra("transactions", transactions as Serializable) // Pass transactions as Serializable
            startActivity(intent)
        }

        // Update UI with the total balance and expenses
        updateTotals()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        // Handle the result from AddActivity
        if (requestCode == addTransactionRequestCode && resultCode == Activity.RESULT_OK && data != null) {
            val name = data.getStringExtra("name") ?: ""
            val price = data.getDoubleExtra("price", 0.0)
            transactions.add(Transaction(name, price))
            transactionAdapter.notifyDataSetChanged() // Refresh the RecyclerView
            updateTotals() // Recalculate totals
        }
    }

    // Calculate and update total balance and expenses displayed on UI
    private fun updateTotals() {
        var totalBalance = 0.0
        var totalExpenses = 0.0

        for (transaction in transactions) {
            totalBalance += transaction.price
            if (transaction.price < 0) {
                totalExpenses += transaction.price
            }
        }

        // Update text views with formatted balance and expenses
        binding.balance.text = String.format("%.2f", totalBalance)
        binding.expense.text = String.format("%.2f", totalExpenses)
    }

}
