package com.example.financeapp



import java.io.Serializable

data class Transaction(val name: String, val price: Double) : Serializable


//data class Transaction(
//    val name: String,
//    val amount: Double
//) {
//}