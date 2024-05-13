package com.example.financeapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class TransactionAdapter(private val transactions: ArrayList<Transaction>):
    RecyclerView.Adapter<TransactionAdapter.Transactionholder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Transactionholder {
        val view=LayoutInflater.from(parent.context).inflate(R.layout.transaction_layout, parent, false)
        return Transactionholder(view)
    }


    override fun onBindViewHolder(holder: Transactionholder, position: Int) {
    val transaction = transactions[position]
    holder.name.text = transaction.name
    holder.amount.text = "${transaction.price}"
}


    override fun getItemCount(): Int {
        return transactions.size
    }

    class Transactionholder(view: View) : RecyclerView.ViewHolder(view){
        val name: TextView= view.findViewById(R.id.name);
        val amount: TextView= view.findViewById(R.id.amount);

    }
}




